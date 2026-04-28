package com.example.demo.service;

import com.example.demo.model.Message;
import com.example.demo.repo.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getPublicMessages() {
        return messageRepository.findAll().stream()
                .filter(Message::isPublic)
                .toList();
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }
}
