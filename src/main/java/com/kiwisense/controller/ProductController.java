package com.kiwisense.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiwisense.dal.dto.DeviceDto;
import com.kiwisense.dal.dto.DeviceWithIdDto;
import com.kiwisense.dal.dto.ProductDto;
import com.kiwisense.dal.dto.ProductParameterDto;
import com.kiwisense.dal.dto.ProductParameterWithIdDto;
import com.kiwisense.dal.dto.ProductWithIdDto;
import com.kiwisense.dal.model.Device;
import com.kiwisense.dal.model.Product;
import com.kiwisense.dal.model.ProductParameter;
import com.kiwisense.service.ProductService;
import com.kiwisense.service.security.jwt.MessageResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<?> saveProduct(@Valid @RequestBody ProductDto prodDto) {

		if (prodDto == null)
			return ResponseEntity.badRequest().body(new MessageResponse("could not map"));

		ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		Product product = modelMapper.map(prodDto, Product.class);
		product = this.productService.saveProduct(product);
		
		ProductWithIdDto idDto = modelMapper.map(product, ProductWithIdDto.class);
		return ResponseEntity.ok(idDto);
	}

	@GetMapping("/products/{productId}")
	public ResponseEntity<?> getProduct(Long productId) {

		Product prod = this.productService.getProduct(productId);
		if (prod == null)
			return ResponseEntity.badRequest().body(new MessageResponse("Error: product not found."));

		ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		ProductWithIdDto prodDto = modelMapper.map(prod, ProductWithIdDto.class);
		return ResponseEntity.ok(prodDto);

	}

	@GetMapping("/products")
	public ResponseEntity<?> getProducts() {
		List<Product> products = this.productService.getProducts();
		ModelMapper modelMapper = new ModelMapper();
		List<ProductWithIdDto> productDtos = products.stream()
				.map(product -> modelMapper.map(product, ProductWithIdDto.class)).collect(Collectors.toList());

		return ResponseEntity.ok(productDtos);

	}

	@GetMapping("/products/{productId}/paramters")
	public ResponseEntity<?> getProductParamters(Long productId) {

		Product prod = this.productService.getProduct(productId);
		if (prod == null)
			return ResponseEntity.badRequest().body(new MessageResponse("Error: product not found."));

		ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		Set<ProductParameter> parameters = prod.getParameters();
		if (parameters == null)
			parameters = new HashSet<ProductParameter>();
		List<ProductParameterWithIdDto> parametersDtos = parameters.stream()
				.map(parameter -> modelMapper.map(parameter, ProductParameterWithIdDto.class)).collect(Collectors.toList());

		return ResponseEntity.ok(parametersDtos);

	}

	@PostMapping("/products/{productId}/parameters")
	public ResponseEntity<?> saveParamter(Long productId, @Valid @RequestBody Set<ProductParameterDto> paramDto) {
		ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		List<ProductParameter> parameters = paramDto.stream()
				.map(parameter -> modelMapper.map(parameter, ProductParameter.class)).collect(Collectors.toList());

		Product prd = this.productService.saveProductParameter(productId, parameters);
		if (prd == null)
			return ResponseEntity.badRequest().body(new MessageResponse("Error: product not found."));
		
		// may be wee need to send dtos with ids persisted
		return ResponseEntity.ok(new MessageResponse("added successfully!"));
	}

	@PostMapping("/products/{productId}/devices")
	public ResponseEntity<?> saveDevice(Long productId, @Valid @RequestBody DeviceDto paramDto) {
		ModelMapper modelMapper = new ModelMapper();

		Device device = modelMapper.map(paramDto, Device.class);

		device = this.productService.saveProductDevice(productId, device);
		DeviceWithIdDto dto = modelMapper.map(device, DeviceWithIdDto.class);
		return ResponseEntity.ok(dto);
	}

}
