package com.placem.phonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_phone")
public class Phone extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long telSeq; 
	
	@Column (name = "frnd_seq")
	private String frndSeq;
	
	@Column (name = "tel_type")
	private String telType;
	
	@Column (name = "tel_no_1")
	private int telNo1;
	
	@Column (name = "tel_no_2")
	private int telNo2;
	
	@Column (name = "tel_no_3")
	private int telNo3;
	

    
	
		
}
