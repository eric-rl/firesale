package com.company.firesale.controller;

import com.company.firesale.json_classes.ChatMessageJsonClass;
import com.company.firesale.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatController {

    private final ChatMessageService chatMessageService;

    @Autowired
    public ChatController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @MessageMapping("/chat.sendMessage")
    public void sendChatMessage(ChatMessageJsonClass message, Principal principal) {
        System.out.println("Message Received from user: " + principal);
        System.out.println("Message: " + message.getTextContent());
        System.out.println("Sending to conversation ID: " + message.getConversationId());

        chatMessageService.postMessage(message, principal.getName());
    }
}
