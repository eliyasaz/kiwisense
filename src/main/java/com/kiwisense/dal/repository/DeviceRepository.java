package com.kiwisense.dal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kiwisense.dal.model.Device;

@Repository
public interface DeviceRepository extends GenericRepository<Device> {
	
	@Query(value = "select object_id from device_info where device_name = ?1", nativeQuery = true)
	public Long findDeviceIdByName(String deviceName);

}
