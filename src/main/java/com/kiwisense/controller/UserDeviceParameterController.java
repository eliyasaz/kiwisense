package com.kiwisense.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiwisense.dal.dto.DeviceUserParameterDto;
import com.kiwisense.service.DeviceUserParameterService;
import com.kiwisense.service.security.jwt.MessageResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserDeviceParameterController {
	
	@Autowired
	DeviceUserParameterService deviceUserParameterService;

	@PostMapping("/user/device/paramters")
	public ResponseEntity<?> saveDeviceUserParamters(@Valid @RequestBody Set<DeviceUserParameterDto> deviceUserParametersDtos) {
		this.deviceUserParameterService.saveDeviceUserParameters(deviceUserParametersDtos);
		return ResponseEntity.ok(new MessageResponse("parameters saved successfully!"));
	}


}
