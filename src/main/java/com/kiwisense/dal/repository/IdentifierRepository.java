package com.kiwisense.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiwisense.dal.model.ObjectSequenceInfo;

@Repository
public interface IdentifierRepository extends JpaRepository<ObjectSequenceInfo, String> {

}