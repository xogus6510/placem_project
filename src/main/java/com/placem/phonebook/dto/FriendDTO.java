package com.placem.phonebook.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

import com.placem.phonebook.entity.Friend;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class FriendDTO {
	private long frndSeq;
	private String frndNm, telNo3;
	private LocalDateTime  createdDate, modifiedDate;
	private Long count;
	
	public FriendDTO() {}

	public FriendDTO(long frndSeq, String frndNm, LocalDateTime createdDate, LocalDateTime modifiedDate, Long count) {
		super();
		this.frndSeq = frndSeq;
		this.frndNm = frndNm;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.count = count;
	}

	public FriendDTO(long frndSeq, String frndNm, LocalDateTime createdDate, LocalDateTime modifiedDate) {
		super();
		this.frndSeq = frndSeq;
		this.frndNm = frndNm;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	

}
