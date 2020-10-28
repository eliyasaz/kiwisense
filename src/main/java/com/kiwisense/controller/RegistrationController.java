package com.kiwisense.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiwisense.dal.model.ERole;
import com.kiwisense.dal.model.Role;
import com.kiwisense.dal.model.User;
import com.kiwisense.service.RoleService;
import com.kiwisense.service.UserService;
import com.kiwisense.service.security.jwt.ChangePasswordRequest;
import com.kiwisense.service.security.jwt.MessageResponse;
import com.kiwisense.service.security.jwt.SignupRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/changepassword")
	public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(changePasswordRequest.getEmail(), changePasswordRequest.getPassword()));
		User user = userService.getUser(changePasswordRequest.getEmail());
		user.setPassword(encoder.encode(changePasswordRequest.getPassword()));

		userService.saveUser(user);

		return ResponseEntity.ok(new MessageResponse("changed password successfully!"));
	}


	@PostMapping("/patients")
	public ResponseEntity<?> registerPatient(@Valid @RequestBody SignupRequest signUpRequest) {
		return registerUser(signUpRequest, ERole.ROLE_PATIENT);
	}

	@PostMapping("/doctors")
	public ResponseEntity<?> registerDoctor(@Valid @RequestBody SignupRequest signUpRequest) {
		return registerUser(signUpRequest, ERole.ROLE_DOCTOR);
	}

	@PostMapping("/admins")
	public ResponseEntity<?> registerAdmin(@Valid @RequestBody SignupRequest signUpRequest) {
		return registerUser(signUpRequest, ERole.ROLE_ADMIN);
	}
	
	public ResponseEntity<?> registerUser(SignupRequest signUpRequest, ERole roleToAssign) {
		if (userService.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		User user = modelMapper.map(signUpRequest, User.class);

		user.setPassword(encoder.encode(signUpRequest.getPassword()));
		Set<Role> roles = new HashSet<Role>();

		Role userRole = roleService.findByName(roleToAssign);

		roles.add(userRole);
		user.setRoles(roles);

		userService.saveUser(user);

		return ResponseEntity.ok(new MessageResponse("Registered successfully!"));
	}


}
