package com.kiwisense.listeners;

import javax.persistence.PrePersist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kiwisense.dal.model.BaseModel;
import com.kiwisense.service.IdentifierService;

@Component
public class BaseModelListener {

	private IdentifierService idService;

	@Autowired
	public BaseModelListener(IdentifierService idService) {
		this.idService = idService;
	}

	@PrePersist
	public void prePersist(BaseModel model) {
		if (model != null && this.idService != null) {
			String className = model.getClass().getName();
			Long id = null;
			try {
				id = this.idService.getNextId(className);
				model.setId(id);
			} catch (Exception et) {
			}
		}
	}

}
