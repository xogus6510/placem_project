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

import com.placem.phonebook.dto.FriendDTO;
import com.placem.phonebook.entity.Friend;

@Service
public class FriendService {

	@PersistenceUnit
	EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
	
	
	//mysql 쿼리문
	//select tb_friend.frnd_seq, tb_friend.frnd_nm, tb_friend.created_date, tb_friend.modified_date, count(tb_friend.frnd_seq) from phonebookdb.tb_friend join phonebookdb.tb_phone on tb_friend.frnd_seq = tb_phone.frnd_seq where tb_phone.tel_no_3 = 6510 group by frnd_seq;
	public String test() {
		
		ModelMapper modelMapper = new ModelMapper();
		
		
		TypedQuery<Friend> query = em.createQuery("select r from Friend r",Friend.class);
		List<Friend> test = query.getResultList();
		//PhonebookDTO frienddto = modelMapper.map(query, PhonebookDTO.class);
	    List<FriendDTO> resultList = Arrays.asList(modelMapper.map(test,FriendDTO[].class));
	    for(FriendDTO a : resultList) {
	    	System.out.println(a);
	    }
		//System.out.println(frienddto + "dto");
		//System.out.println(test +"===jpql");
		//System.out.println(test.get(0).getFrndNm());
		
		
		return "test";
	}
	
	
}
