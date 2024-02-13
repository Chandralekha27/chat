package com.chat.util.builder;

import com.chat.model.Message;
import com.chat.model.dto.MessageRequest;

import java.util.Date;

public class MessageDtoMapper {
    public static Message messageBuilder(MessageRequest message) {
        Message sendMessage = new Message();
        sendMessage.setContent(message.getContent());
        sendMessage.setSender(message.getSender());
        sendMessage.setReceiver(message.getReceiver());
        sendMessage.setTimestamp(new Date());
        return sendMessage;
    }
}
