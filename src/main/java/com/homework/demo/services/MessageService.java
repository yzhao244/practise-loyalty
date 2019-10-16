package com.homework.demo.services;

import java.util.List;

import com.homework.demo.dto.MessageDto;

public interface MessageService {

	List<MessageDto> findMessageByUserId(String userId);
	
	MessageDto createMessage(MessageDto messageDto);
}
