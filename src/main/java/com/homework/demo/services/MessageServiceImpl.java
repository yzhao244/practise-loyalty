package com.homework.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.demo.domain.Message;
import com.homework.demo.dto.MessageDto;
import com.homework.demo.dto.MessageMapper;
import com.homework.demo.repository.MessageRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service("messageService")
@Transactional
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageRepository messageRepositry;
	
	public List<MessageDto> findMessageByUserId(String userId){
		List<Message> messageList = messageRepositry.findByUserId(userId);
		List<MessageDto> messageDtoList = messageList.stream().map(MessageMapper::toMessageDto).collect(Collectors.toList());
		return messageDtoList;
	}

	@Override
	public MessageDto createMessage(MessageDto messageDto) {
		Message message = Message.builder()
				.userId(messageDto.getUserId())
				.content(messageDto.getMessageContent())
				.createdDate(messageDto.getCreatedDate()).build();
		message = messageRepositry.saveAndFlush(message);
		
		return MessageMapper.toMessageDto(message);
	}
}
