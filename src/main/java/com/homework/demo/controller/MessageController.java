package com.homework.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homework.demo.dto.MessageDto;
import com.homework.demo.services.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody List<MessageDto> getMessageById( @RequestParam(value="userId") String userId) 
    {
		System.out.println(userId);
		System.out.println(messageService);
		List<MessageDto> messages = messageService.findMessageByUserId(userId);
		return messages;
    }
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public MessageDto createMessage(@RequestBody @Valid MessageDto messageDto) 
    {
		return messageService.createMessage(messageDto);
    }

}
