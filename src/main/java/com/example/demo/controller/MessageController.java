
package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/public")
    public List<Message> getPublic() {
        return messageService.getPublicMessages();
    }

    @GetMapping("/private")
    public List<Message> getPrivate() {
        return messageService.getAllMessages();
    }

    @PostMapping("/messages")
    public Message create(@RequestBody Message message) {
        return messageService.createMessage(message);
    }
}
