package com.homework.demo.dto;

import com.homework.demo.domain.Message;

public class MessageMapper {
	public static MessageDto toMessageDto(Message message) {
		return MessageDto.builder()
		.messageId(message.getId())
		.userId(message.getUserId())
		.messageContent(message.getContent())
		.createdDate(message.getCreatedDate())
		.build();
		
	}

}
