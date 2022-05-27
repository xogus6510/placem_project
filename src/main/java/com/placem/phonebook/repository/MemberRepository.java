package com.placem.phonebook.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.placem.phonebook.entity.Member;

public interface MemberRepository extends CrudRepository <Member, Long> {

	List <Member> findById(long id);	
	
	List <Member> findByFirstName(String firstName);
	
	List <Member> findByLastName(String lastName);
	
	List <Member> findByEmail(String email);
	
}
