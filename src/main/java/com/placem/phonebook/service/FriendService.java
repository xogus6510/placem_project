package com.placem.phonebook.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placem.phonebook.entity.Friend;
import com.placem.phonebook.repository.FriendRepository;
import com.placem.phonebook.repository.PhoneRepository;

@Service
public class FriendService {
	@Autowired
	private FriendRepository friendrepository;
	@Autowired
	private PhoneRepository phonerepository;

	@PersistenceUnit
	EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
	
	
	public String test() {
		TypedQuery<Friend> query = em.createQuery("select r from Friend r",Friend.class);
		List<Friend> test = query.getResultList();
		System.out.println(test +"===jpql");
		System.out.println(test.get(0).getFrndNm());
		return "완료";
	}
	
	
}
