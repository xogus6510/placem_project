package com.placem.phonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_friend")
public class Friend extends BaseEntity {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long frndSeq; 
	
	@Column (name = "frnd_nm")
	private String frndNm;
	
	 // public void update(String frndNm) {
	 //       this.frndNm = frndNm;
	 //  }
	
	//@ManyToOne
	//private Phone phone;
	
	
	
	
}
