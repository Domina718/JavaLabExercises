package com.example.demo.controller;

import com.example.demo.dto.MessageRequest;
import com.example.demo.dto.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Controller
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ResponseMessage getMessage(MessageRequest messageRequest){

        return new ResponseMessage(HtmlUtils.htmlEscape(messageRequest.getContent()));
    }

    @MessageMapping("/topic/notification/{id}")
    @SendToUser("/topic/private-messages")
    public ResponseMessage getPrivateMessage(MessageRequest messageRequest, Principal principal){

        return new ResponseMessage(HtmlUtils.htmlEscape("Sending private message to user "
                + principal.getName() + ": " + messageRequest.getContent()));
    }


}
