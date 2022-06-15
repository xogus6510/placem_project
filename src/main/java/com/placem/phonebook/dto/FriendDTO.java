package com.placem.phonebook.dto;

import com.placem.phonebook.entity.Friend;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FriendDTO {
	long frndSeq;
	String frndNm, createdDate, modifiedDate;
}
