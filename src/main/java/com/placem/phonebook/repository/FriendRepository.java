package com.placem.phonebook.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placem.phonebook.entity.BaseEntity;
import com.placem.phonebook.entity.Friend;

public interface FriendRepository extends JpaRepository <Friend, Long> {

	List <Friend> findByFrndSeq(long frndSeq);	
	
	List <Friend> findByFrndNm(String frndNm);
	
	List <BaseEntity> findByCreatedDate(LocalDateTime createdDate);
	
	List <BaseEntity> findByModifiedDate(LocalDateTime modifiedDate);
	
}
