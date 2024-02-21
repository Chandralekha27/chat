package com.chat.controller;

import com.chat.model.dto.MessageRequest;
import com.chat.service.MessageService;
import com.chat.util.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageRequest request){
        try{
            messageService.sendMessage(request);
            return ResponseEntity.ok().build();
        }catch (UserNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity allMessages(){
        return ResponseEntity.ok().build();
    }

}
