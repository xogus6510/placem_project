package com.placem.phonebook.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.placem.phonebook.entity.BaseEntity;
import com.placem.phonebook.entity.Friend;
import com.placem.phonebook.entity.Phone;

public interface PhoneRepository extends JpaRepository <Phone, Long> {

	List <Phone> findByTelSeq(long telSeq);	
	
	List <Phone> findByTelType(String telType);
	
	List <Phone> findByTelNo1(String telNo1);
	
	List <Phone> findByTelNo2(String telNo2);
	
	List <Phone> findByTelNo3(String telNo3);
	
	List <Phone> findByCreatedDate(LocalDateTime createdDate);
	
	List <Phone> findByModifiedDate(LocalDateTime modifiedDate);
	
	//List <Phone> deleteByFriend(Friend friend);

	List<Phone> findAllByFriend(Friend friend);
	List<Phone> findByFriend(Friend friend);
}
