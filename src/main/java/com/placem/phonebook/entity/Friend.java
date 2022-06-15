package com.placem.phonebook.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.repository.Query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_friend")
public class Friend extends BaseEntity {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long frndSeq; 
	
	@Column (name = "frnd_nm")
	private String frndNm;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="friend")
	  private List<Phone> phone = new ArrayList<Phone>();
	
	@Builder
	public Friend(long frndSeq, String frndNm, LocalDateTime createdDate, LocalDateTime modifiedDate) {
		this.frndSeq = frndSeq;
		this.frndNm = frndNm;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
}
