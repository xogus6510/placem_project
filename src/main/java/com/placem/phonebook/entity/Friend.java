package com.placem.phonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@ToString
@Table(name = "tb_friend")
public class Friend {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aa; 
	
	@Column (name = "frnd_nm")
	private String frndNm;
	
	@Column (name = "reg_dtm")
	private String regDtm; 
	
	@Column (name = "mod_dtm")
	private String modDtm; 
	
}
