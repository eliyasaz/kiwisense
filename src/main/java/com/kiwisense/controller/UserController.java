package com.kiwisense.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.kiwisense.dal.dto.UserDto;
import com.kiwisense.dal.model.User;
import com.kiwisense.exception.ResourceNotFoundException;
import com.kiwisense.service.UserService;



@Controller
public class UserController {
    public final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
    	this.userService = userService;
    }
    
    @GetMapping("/users")
	@ResponseBody
	public List<User> getUsers() {
		return this.userService.getUsers();
	}
    
    @GetMapping("/users/{id}")
	@ResponseBody
	public User getUser(@PathVariable Long id) {
		return this.userService.getUser(id);
	}
    
    @ResponseBody
	@PostMapping("/users")
	public UserDto saveUser(@Valid @RequestBody UserDto userDto) {
    	System.out.println(" BEFIRE            "+userDto.toString());
		ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		User user = modelMapper.map(userDto, User.class);
    	user = this.userService.saveUser(user);
    	userDto = modelMapper.map(user, UserDto.class);
    	return userDto;
	}
	
    @ResponseBody
  	@PutMapping("/users/{userId}")
    /*
     * @param userAttributes modified attributes of User which needs to be modified.
     * @param userId user id of user to which we need to modify attributes.
     */
  	public UserDto updateUser(@RequestBody Map<String, String> userAttributes, @PathVariable Long userId) {   
    	User user = this.userService.getUser(userId);
    	ModelMapper mapper = new ModelMapper();
    	mapper.map(userAttributes, user);
    	user = this.userService.updateUser(user);
    	UserDto userDto = mapper.map(user, UserDto.class);
      	return userDto;
  	}
  	
//    public Object getMapped(Object obj, Object.class  className) {
//    	return Object
//    }
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(ResourceNotFoundException ex, WebRequest request) {
    	return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }

	
}
