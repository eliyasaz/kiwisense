package com.kiwisense.dal.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kiwisense.dal.model.ERole;
import com.kiwisense.dal.model.Role;

@Repository
public interface RoleRepository  extends GenericRepository<Role>{
	Optional<Role> findByName(ERole name);

}
