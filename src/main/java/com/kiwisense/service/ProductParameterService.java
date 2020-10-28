package com.kiwisense.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiwisense.dal.repository.ProductParameterRepository;

@Service
public class ProductParameterService {
	Logger _LOG = LoggerFactory.getLogger(ProductParameterService.class);

	private ProductParameterRepository productParameterRepository;

	@Autowired
	public ProductParameterService(ProductParameterRepository productParameterRepository) {
		this.productParameterRepository = productParameterRepository;
	}

	public Long getProductParameterIdByName(String paramName, Long deviceId) {
		return this.productParameterRepository.findIdByParameterName(paramName, deviceId);
	}

}
