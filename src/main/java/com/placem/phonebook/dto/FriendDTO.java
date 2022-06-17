package com.placem.phonebook.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

import com.placem.phonebook.entity.Friend;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FriendDTO {
	long frndSeq;
	String frndNm, telNo3, createdDate, modifiedDate;
	int count;
}
