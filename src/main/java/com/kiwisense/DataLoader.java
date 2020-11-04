//package com.kiwisense;
//
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.kiwisense.dal.dto.DeviceUserParameterDto;
//import com.kiwisense.dal.model.Device;
//import com.kiwisense.dal.model.ERole;
//import com.kiwisense.dal.model.Product;
//import com.kiwisense.dal.model.ProductParameter;
//import com.kiwisense.dal.model.Role;
//import com.kiwisense.dal.model.User;
//import com.kiwisense.service.DeviceUserParameterService;
//import com.kiwisense.service.ProductService;
//import com.kiwisense.service.RoleService;
//import com.kiwisense.service.UserService;
//
//@Configuration
//@Component
//public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
//
//	private final UserService userService;
//
//	private final RoleService roleService;
//
//	@Autowired
//	PasswordEncoder encoder;
//
//	@Autowired
//	ProductService productService;
//
//	@Autowired
//	DeviceUserParameterService dupService;
//
//	public DataLoader(UserService userService, RoleService roleService, ProductService productService,
//			DeviceUserParameterService dupService) {
//		this.userService = userService;
//		this.roleService = roleService;
//		this.dupService = dupService;
//		this.productService = productService;
//	}
//
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//
//		Role adminRole = new Role(ERole.ROLE_ADMIN);
//
//		roleService.saveRole(adminRole);
//
//		Role doctorRole = new Role(ERole.ROLE_DOCTOR);
//
//		roleService.saveRole(doctorRole);
//
//		Role merchantRole = new Role(ERole.ROLE_PATIENT);
//
//		roleService.saveRole(merchantRole);
//
//		User user = new User();
//		user.setEmail("admin@kiwisense.com");
//		user.setPassword(encoder.encode("kiwisense"));
//
//		Set<Role> roles = new HashSet<Role>();
//		roles.add(adminRole);
//
//		user.setRoles(roles);
//		userService.saveUser(user);
//
//		User user1 = new User();
//		user1.setEmail("testreg@gmail.com");
//		user1.setPassword(encoder.encode("kiwisense"));
//
//		Set<Role> rolesn = new HashSet<Role>();
//		rolesn.add(merchantRole);
//
//		user1.setRoles(rolesn);
//		userService.saveUser(user1);
//
//
//		for (int x = 0; x < 1; x++) {
//			createData(x, user1);
//		}
//	}
//
//	public void createData(int x, User user1) {
//		Product prod = new Product();
//
//		String productName = x == 0 ? "Kiwi Watch" : "Kiwi Watch" + x;
//		prod.setProductName(productName);
//		prod.setProductCategory("Watch");
//		prod.setStatus("Good");
//		prod.setVendor("KIWI");
//
//		ProductParameter param = new ProductParameter();
//
//		param.setParameterName("STEPS");
//		param.setParameterType("string");
//		prod.addParamter(param);
//		param.setProduct(prod);
//
//		param = new ProductParameter();
//		param.setParameterName("DISTANCE");
//		param.setParameterType("string");
//		prod.addParamter(param);
//		param.setProduct(prod);
//
//		param = new ProductParameter();
//		param.setParameterName("BURNT_CALORIES");
//		param.setParameterType("string");
//		prod.addParamter(param);
//		param.setProduct(prod);
//
//		param = new ProductParameter();
//		param.setParameterName("HEART_RATE");
//		param.setParameterType("string");
//		prod.addParamter(param);
//		param.setProduct(prod);
//
//		param = new ProductParameter();
//		param.setParameterName("SPO2");
//		param.setParameterType("string");
//		prod.addParamter(param);
//		param.setProduct(prod);
//
//		param = new ProductParameter();
//		param.setParameterName("TEMPERATURE");
//		param.setParameterType("string");
//		prod.addParamter(param);
//		param.setProduct(prod);
//
//		Device device = new Device();
//
//		String deviceName = x == 0 ? "123456" : "123456" + x;
//		device.setDeviceName(deviceName);
//
//		prod.addDevice(device);
//		device.setProduct(prod);
//		device.setAssignedTo(user1);
//		device.setSoldDate(LocalDateTime.now());
//		device.setRemark("sold");
//
//		productService.saveProduct(prod);
//
//		DeviceUserParameterDto dupDto = new DeviceUserParameterDto();
//		dupDto.setDeviceName("zzzzz-zzzzz-yyyy-aaaaa");
//		dupDto.setEmail("admin@kiwisense.com");
//		dupDto.setParameterName("TEMPERATURE");
//		dupDto.setParameterValue("97F");
//		Set<DeviceUserParameterDto> dtos = new HashSet<DeviceUserParameterDto>();
//		dtos.add(dupDto);
//
//		this.dupService.saveDeviceUserParameters(dtos);
//
//	}
//}
