package com.placem.phonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_friend")
public class Friend {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long frndSeq; 
	
	@Column (name = "frnd_nm")
	private String frndNm;
	
	@Column (name = "reg_dtm")
	private String regDtm; 
	
	@Column (name = "mod_dtm")
	private String modDtm;

	public long getFrndSeq() {
		return frndSeq;
	}

	public void setFrndSeq(long frndSeq) {
		this.frndSeq = frndSeq;
	}

	public String getFrndNm() {
		return frndNm;
	}

	public void setFrndNm(String frndNm) {
		this.frndNm = frndNm;
	}

	public String getRegDtm() {
		return regDtm;
	}

	public void setRegDtm(String regDtm) {
		this.regDtm = regDtm;
	}

	public String getModDtm() {
		return modDtm;
	}

	public void setModDtm(String modDtm) {
		this.modDtm = modDtm;
	} 
	
	
	
}
