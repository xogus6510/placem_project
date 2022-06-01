package com.placem.phonebook.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.placem.phonebook.entity.BaseEntity;
import com.placem.phonebook.entity.Phone;

public interface PhoneRepository extends JpaRepository <Phone, Long> {

	List <Phone> findByTelSeq(long telSeq);	
	
	List <Phone> findByTelType(String telType);
	
	List <Phone> findByTelNo1(int telNo1);
	
	List <Phone> findByTelNo2(int telNo2);
	
	List <Phone> findByTelNo3(int telNo3);
	
	List <BaseEntity> findByCreatedDate(LocalDateTime createdDate);
	
	List <BaseEntity> findByModifiedDate(LocalDateTime modifiedDate);

	
}
