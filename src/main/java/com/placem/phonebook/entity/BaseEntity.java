package com.placem.phonebook.entity;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class BaseEntity {

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@CreatedDate
	public LocalDateTime createdDate;

	@LastModifiedDate
	public LocalDateTime modifiedDate;

	// @PrePersist
	// public void onPrePersist(){
	// this.createdDate =
	// LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd
	// HH:mm:ss"));
	// }

	// @PreUpdate
	// public void onPreUpdate(){
	// this.modifiedDate =
	// LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd
	// HH:mm:ss"));
	// }
}
