package com.homework.demo.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
@Builder
public class MessageDto {
	
	@NotNull(message = "{Message.userid.NotNull}")
	private String userId;
	private long messageId;
	
	@NotNull(message = "{Message.content.NotNull}")
	@Size(max = 1000, message = "{Message.content.size}")
	private String messageContent;
	
	private LocalDateTime createdDate;
}
