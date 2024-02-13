package com.chat.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Message {

    @Id
    private String id;

    private Date timestamp;

    private String content;

    private String sender;

    private String receiver;

}
