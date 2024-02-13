package com.chat.model.dto;

import lombok.Data;

@Data
public class MessageRequest {

    String sender;

    String receiver;

    String content;

}
