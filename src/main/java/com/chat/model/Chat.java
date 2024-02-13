package com.chat.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Chat {

    @Id
    private String id;

    private String name;

    private boolean isGroupChat;

    private List<User> users;

    private User groupAdmin;

    private Message latestMessage;

}
