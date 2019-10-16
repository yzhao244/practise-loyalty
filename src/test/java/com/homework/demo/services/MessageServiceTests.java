package com.homework.demo.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.homework.demo.domain.Message;
import com.homework.demo.dto.MessageDto;
import com.homework.demo.repository.MessageRepository;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTests {
	
	@Mock
	private MessageRepository messageRepository;
	
	@Autowired
	private MessageService messageService;
	
	List<Message> messageList;
	
	@Before
	public void setUp() {
		messageList = new ArrayList<Message>();
		Message message1 = setupMessage("userid1");
		messageList.add(message1);
	}
	
	private Message setupMessage(String userId) {
		return Message.builder().userId(userId).content("unit test content").createdDate(LocalDateTime.now()).build();
	}
	
	@Test
	public void findMessageByUserId() {
		String userId = "userid1";
		
		Mockito.when(messageRepository.findByUserId(userId)).thenReturn(messageList);
		
		List<MessageDto> messageDtoList = messageService.findMessageByUserId(userId);
		
		assertTrue("The number of messages fetched by user id is 1 ", messageDtoList.size() == 1);
	}
	
	@Test
	public void createMessage() {
		Message message = Message.builder().userId("userid2").content("create a new message").createdDate(LocalDateTime.now()).build();
		Mockito.when(messageRepository.saveAndFlush(message)).thenReturn(message);
		
		MessageDto messageDto = MessageDto.builder().userId("userid2").messageContent("create one more message").createdDate(LocalDateTime.now()).build();
		
		MessageDto createdMessageDto = messageService.createMessage(messageDto);
		assertEquals(messageDto.getUserId(), createdMessageDto.getUserId());
		assertEquals(messageDto.getMessageContent(), createdMessageDto.getMessageContent());
		assertEquals(messageDto.getCreatedDate(), createdMessageDto.getCreatedDate());
	}

}
