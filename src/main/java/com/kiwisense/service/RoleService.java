package com.kiwisense.service;

import org.springframework.stereotype.Service;

import com.kiwisense.dal.model.ERole;
import com.kiwisense.dal.model.Role;
import com.kiwisense.dal.repository.RoleRepository;
import com.kiwisense.exception.ResourceNotFoundException;

@Service
public class RoleService {

	private final RoleRepository roleRepository;
	
	public RoleService(RoleRepository roleRepository){
	 this.roleRepository = roleRepository ;	
	}
	
	public Role saveRole(Role role) {
		return this.roleRepository.save(role);
	}
	
	public Role findByName(ERole name) {
		return this.roleRepository.findByName(name)
				.orElseThrow(() -> new ResourceNotFoundException("Role Not Found with name: " + name));
	}
	
}
