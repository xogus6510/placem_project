package com.placem.phonebook.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	List<Phone> findAllByFriend(Friend friend);
	List<Phone> findByFriend(Friend friend);
	Page<Phone> findByTelNo3Equals(String TelNo3, Pageable pageable);
	
	@Query(value = "select count(*) from tb_phone m where m.frnd_seq = ?1", nativeQuery = true)
	long count(long frndSeq);
}
