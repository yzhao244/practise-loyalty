package com.homework.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGE")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MESSAGE_SEQUENCE")
	@SequenceGenerator(sequenceName = "MESSAGE_SEQ", name = "MESSAGE_SEQUENCE")
	@Column(name="ID", updatable = false, nullable = false)
	private long id;
	
	@Basic(optional = false)
	@Column(name = "CONTENT")
	private String content;
	
	@Basic(optional = false)
	@Column(name = "USER_ID")
	private String userId;
	
	@Basic(optional = false)
	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;
}
