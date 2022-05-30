package com.placem.phonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "tb_friend")
public class Friend {
	
	//private static final long serialVersionUID = -5129628467395047900L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long frndSeq;
	
	@Column (name = "frnd_nm")
	private String frndNm;
	
	@Column (name = "reg_dtm")
	//@CreationTimestamp
	private String regDtm; 
	
	@Column (name = "mod_dtm")
	//@CreationTimestamp
	private String modDtm;
	
	/*@Formula("(select count(*) from tb_phone p where p.frnd_seq = frnd_seq)")
	private Integer telCnt;*/
	
	/*@OneToMany(mappedBy = "friend", cascade = {CascadeType.REMOVE})
	private List<Phone> phoneList;*/
	

}
