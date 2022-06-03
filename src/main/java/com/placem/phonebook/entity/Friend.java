package com.placem.phonebook.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="friend", cascade = CascadeType.ALL, orphanRemoval = true)
	   private List<Phone> phone;
	
	 // public void update(String frndNm) {
	 //       this.frndNm = frndNm;
	 //  }	
}
