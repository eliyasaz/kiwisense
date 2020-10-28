package com.kiwisense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiwisense.dal.model.Device;
import com.kiwisense.dal.repository.DeviceRepository;
import com.kiwisense.exception.ResourceNotFoundException;

@Service
public class DeviceService {
     
	private DeviceRepository deviceRepository;
	
	@Autowired
	public DeviceService(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}
	
	public Device getDevice(Long deviceId) {
		return this.deviceRepository.findById(deviceId)
				.orElseThrow(() -> new ResourceNotFoundException("Device Not Found with id: " + deviceId));
	}
	
	public Long getDeviceIdByName(String deviceName) {
		return this.deviceRepository.findDeviceIdByName(deviceName);
	}
}
