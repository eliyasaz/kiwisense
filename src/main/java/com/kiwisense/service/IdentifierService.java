package com.kiwisense.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.kiwisense.dal.model.ObjectSequenceInfo;
import com.kiwisense.dal.model.persistence.ObjectType;
import com.kiwisense.dal.repository.IdentifierRepository;

@Service
@Scope("singleton")
public class IdentifierService {
	Logger _LOG = LoggerFactory.getLogger(IdentifierService.class);

	private static final int DEFAULT_INCREMENT = 1000;

	private static HashMap<String, ObjectSequenceInfo> OBJECT_SEQUENCES = new HashMap<String, ObjectSequenceInfo>();

	private IdentifierRepository identifierRepository;

	public IdentifierService(IdentifierRepository identifierRepository) {
		this.identifierRepository = identifierRepository;
	}

	public synchronized Long getNextId(String className) throws Exception {
		// This method is called for (almost) every insert in to the database.
		// If this becomes a bottleneck because of synchronization, we might
		// have to split it up and partition it based on object type.

		// We will be getting a new object sequence info only once every
		// DEFAULT_INCREMENT times. So, this method should return very quickly.

		ObjectSequenceInfo osi = OBJECT_SEQUENCES.get(className);

		if (osi == null) {
			osi = getUpdatedObjectSequenceInfo(className);
			OBJECT_SEQUENCES.put(className, osi);
		} else {
			if (osi.getCurrentValue() == osi.getMaxValue()) {
				osi = getUpdatedObjectSequenceInfo(className);
				OBJECT_SEQUENCES.put(className, osi);
			}
		}

		return osi.incrementCurrentValue();
	}

	protected ObjectSequenceInfo getUpdatedObjectSequenceInfo(String className) throws Exception {

		ObjectSequenceInfo objInfo = null;
		try {
			objInfo = this.identifierRepository.findById(className).get();
		} catch (Exception et) {
		}
		if (objInfo == null) {
			objInfo = new ObjectSequenceInfo(className);
			long initialSequenceNumber = ObjectType.getInitialSequenceNumber(className);
			if (initialSequenceNumber == ObjectType.NULL_SEQUENCE_NUMBER) {
				_LOG.error("Failed to get the initial sequence number for class : " + className);

				throw new Exception("Failed to get the initial sequence number for class : " + className);

			}

			// RESERVE the first 10,000 id's for internal use.
			initialSequenceNumber = initialSequenceNumber + 10000;
			objInfo = new ObjectSequenceInfo(className);
			objInfo.setCurrentValue(initialSequenceNumber);
			objInfo.setMaxValue(DEFAULT_INCREMENT + initialSequenceNumber);
			try {
				objInfo = this.identifierRepository.save(objInfo);
			} catch (Exception et) {
				_LOG.error(et.getLocalizedMessage());
			}

		} else {

			long maxUsedSequenceNumber = objInfo.getMaxValue();// rs.getLong(1);
			objInfo.setCurrentValue(maxUsedSequenceNumber);
			objInfo.setMaxValue(maxUsedSequenceNumber + DEFAULT_INCREMENT);
			//objInfo = this.identifierRepository.saveAndFlush(objInfo);
			try {
				objInfo = this.identifierRepository.save(objInfo);
			} catch (Exception et) {
				_LOG.error(et.getLocalizedMessage());
			}


		}
		return objInfo;
	}

}
