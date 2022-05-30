package com.placem.phonebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placem.phonebook.entity.Friend;

public interface FriendRepository extends JpaRepository <Friend, Long> {

	List <Friend> findByFrndSeq(long frndSeq);	
	
	List <Friend> findByFrndNm(String frndNm);
	
	List <Friend> findByRegDtm(String regDtm);
	
	List <Friend> findByModDtm(String modDtm);
	
}
