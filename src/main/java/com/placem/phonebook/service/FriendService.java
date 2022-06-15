package com.placem.phonebook.service;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.placem.phonebook.dto.PhonebookDTO;
import com.placem.phonebook.entity.Friend;

@Service
public class FriendService {

	@PersistenceUnit
	EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
	
	
	public String test() {
		
		ModelMapper modelMapper = new ModelMapper();
		
		
		TypedQuery<Friend> query = em.createQuery("select r from Friend r",Friend.class);
		List<Friend> test = query.getResultList();
		//PhonebookDTO frienddto = modelMapper.map(query, PhonebookDTO.class);
	    List<PhonebookDTO> resultList = Arrays.asList(modelMapper.map(test,PhonebookDTO[].class));
	    for(PhonebookDTO a : resultList) {
	    	System.out.println(a);
	    }
		//System.out.println(frienddto + "dto");
		//System.out.println(test +"===jpql");
		//System.out.println(test.get(0).getFrndNm());
		
		
		return "test";
	}
	
	
}
