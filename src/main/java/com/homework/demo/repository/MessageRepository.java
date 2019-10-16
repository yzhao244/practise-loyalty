package com.homework.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homework.demo.domain.Message;;

@Repository("messageRepository")
public interface MessageRepository extends JpaRepository<Message, Long>{
	
	List<Message> findByUserId(String userId);

}
