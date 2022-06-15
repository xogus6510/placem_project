package com.placem.phonebook.dto;

import com.placem.phonebook.entity.Friend;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhoneDTO {
	long telSeq;
	String friend, telType, telNo1, telNo2, telNo3, createdDate, modifiedDate;
}
