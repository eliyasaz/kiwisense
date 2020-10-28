package com.kiwisense.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiwisense.dal.dto.DeviceUserParameterDto;
import com.kiwisense.dal.model.DeviceUserParamter;
import com.kiwisense.dal.repository.DeviceUserParamterRepository;

@Service
public class DeviceUserParameterService {
	Logger _LOG = LoggerFactory.getLogger(DeviceUserParameterService.class);

	@Autowired
	private DeviceUserParamterRepository deviceUserParameterRepository;

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductParameterService productParameterService;

	@Transactional
	public void saveDeviceUserParameters(Set<DeviceUserParameterDto> deviceUserParametersDtos) {
		Map<String, Long> deviceNameToIdMap = new HashMap<String, Long>();
		Map<String, Long> paramNameToIdMap = new HashMap<String, Long>();
		Map<String, Long> userNameToIdMap = new HashMap<String, Long>();
		if (deviceUserParametersDtos != null) {
			for (DeviceUserParameterDto dto : deviceUserParametersDtos) {
				String userEmail = dto.getEmail();
				String deviceName = dto.getDeviceName();
				String paramName = dto.getParameterName();
				String paramValue = dto.getParameterValue();
//				String riskFactor = dto.getRemarks()

				LocalDateTime assessmenTime = dto.getAssessmenTime();

				Long deviceId = null;
				Long userId = null;// this.userService.findUserByName(userName);
				Long paramId = null;
				if (deviceNameToIdMap.containsKey(deviceName)) {
					deviceId = deviceNameToIdMap.get(deviceName);
				} else {
					try {
						deviceId = this.deviceService.getDeviceIdByName(deviceName);
						deviceNameToIdMap.put(deviceName, deviceId);
					} catch (Exception et) {
						_LOG.error(et.getLocalizedMessage());
					}
				}
				if (deviceId != null) {
					String paramKey = paramName + "__SEP__" + deviceName;

					if (paramNameToIdMap.containsKey(paramKey)) {
						paramId = paramNameToIdMap.get(paramKey);
					} else {
						try {
							paramId = this.productParameterService.getProductParameterIdByName(paramName, deviceId);
							paramNameToIdMap.put(paramKey, paramId);
						} catch (Exception et) {
							_LOG.error(et.getLocalizedMessage());
						}
					}

					if (userNameToIdMap.containsKey(userEmail)) {
						userId = userNameToIdMap.get(userEmail);
					} else {
						try {
							userId = this.userService.findUserByEmail(userEmail);
							userNameToIdMap.put(userEmail, userId);
						} catch (Exception et) {
							_LOG.error(et.getLocalizedMessage());
						}
					}
				}

				if (deviceId != null && paramId != null && userId != null) {
					DeviceUserParamter dup = new DeviceUserParamter();

					dup.setDeviceId(deviceId);
					dup.setParameterId(paramId);
					dup.setUserId(userId);
					dup.setParameterValue(paramValue);
					dup.setAssessmentDate(assessmenTime);

					this.deviceUserParameterRepository.save(dup);
				}

			}
		}

	}

}
