package com.kiwisense.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiwisense.dal.model.Device;
import com.kiwisense.dal.model.Product;
import com.kiwisense.dal.model.ProductParameter;
import com.kiwisense.dal.repository.ProductRepository;
import com.kiwisense.exception.ResourceNotFoundException;

@Service
public class ProductService {
	Logger _LOG = LoggerFactory.getLogger(ProductService.class);

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getProducts() {
		return this.productRepository.findAll();
	}

	@Transactional
	public Product saveProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Transactional
	public Product getProduct(Long productId) {
		return this.productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found with id: " + productId));
	}

	public Product updateProduct(Long productId) {
		return getProduct(productId);
	}

	@Transactional
	public Product saveProductParameter(Long productId, List<ProductParameter> params) {
		Product prod = getProduct(productId);
		if (prod != null) {
			for (ProductParameter parameter : params) {
				if (parameter != null && parameter.getParameterName() != null) {
					parameter.setProduct(prod);
					prod.addParamter(parameter);
				}
				this.saveProduct(prod);
				return prod;
			}
		}
		return null;
	}

	public Set<ProductParameter> getProductParameters(Long productId) {
		Product prod = getProduct(productId);
		if (prod != null) {
			return prod.getParameters();
		}
		return null;
	}
	
	@Transactional
	public Device saveProductDevice(Long productId, Device device) {
		Product prod = getProduct(productId);
		if (prod != null) {
			prod.getDevices().add(device);
			prod = saveProduct(prod);
			return device;
		}
		return null;
	}

	public void deleteProduct(Long productId) {
		Product prod = this.productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found with id: " + productId)); 
		if (prod != null) {
			this.productRepository.delete(prod);
		}
	}

}
