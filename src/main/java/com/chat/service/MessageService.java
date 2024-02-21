package com.chat.service;

import com.chat.model.dto.MessageRequest;
import com.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.chat.util.builder.MessageDtoMapper.messageBuilder;
@Service
public class MessageService {

    @Autowired
    UserService userService;

    @Autowired
    MessageRepository messageRepository;

    public boolean sendMessage(MessageRequest message){
        if(userService.isSenderPresent(message.getSender())){
            if(userService.isReceiverPresent(message.getReceiver())){
                messageRepository.save(messageBuilder(message));
            }
        }
        return false;
    }

}
