package com.placem.phonebook.service;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.placem.phonebook.dto.FriendDTO;

@Service
public class FriendService {

	@PersistenceUnit
	EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
	
	public List<FriendDTO> num3Search(String searchtext, Pageable pageable) {

		System.out.println(pageable + "pageable");
		System.out.println(pageable.getPageNumber() +"/"+pageable.getPageSize() + "/" + pageable.getSort());
		String jpql = "select new com.placem.phonebook.dto.FriendDTO(m.frndSeq, m.frndNm, m.createdDate, m.modifiedDate, count(m.frndSeq)) from Friend m join Phone t on m.frndSeq = t.friend where t.telNo3 = ?1 group by m.frndSeq";	
		TypedQuery<FriendDTO> query = em.createQuery(jpql, FriendDTO.class).setParameter(1, searchtext);
		List<FriendDTO> list = query.getResultList();
		return list;
	}
}
