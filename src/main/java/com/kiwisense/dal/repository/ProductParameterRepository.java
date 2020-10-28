package com.kiwisense.dal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kiwisense.dal.model.ProductParameter;

@Repository
public interface ProductParameterRepository extends GenericRepository<ProductParameter> {
	@Query(value = "SELECT p.object_id FROM parameter_info p INNER JOIN device_info d ON d.product_id = p.product_id WHERE p.parameter_name = ?1 AND d.object_id = ?2", nativeQuery = true)
	public Long findIdByParameterName(String parameterName, Long deviceId);

}
