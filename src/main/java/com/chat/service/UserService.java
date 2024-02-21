package com.chat.service;

import com.chat.model.User;
import com.chat.repository.UserRepository;
import com.chat.util.Exception.UserAlreadyExistException;
import com.chat.util.Exception.UserCredentialsIncorrectException;
import com.chat.util.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.chat.util.constants.Constants.*;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User registerUser(User user){

        // check if any user already exist with same name and email
        Optional<User> existing = userRepository.findByNameAndEmail(user.getName(), user.getEmail());
        if(existing.isPresent()){
            throw new UserAlreadyExistException(userExist);
        }

        //save user to the database
        return userRepository.save(user);
    }

    public User loginUser(User user){
        Optional<User> existingUser = userRepository.findByName(user.getName());
        if(existingUser.isEmpty()) {
            throw new UserNotFoundException(userNotFound);
        }
        if(!user.getPassword().equals(existingUser.get().getPassword())){
            throw new UserCredentialsIncorrectException(incorrectCredentials);
        }
        return existingUser.get();
    }

    public boolean isSenderPresent(String name){
        Optional<User> existingUser = userRepository.findByName(name);
        if(existingUser.isEmpty()){
            throw new UserNotFoundException(userNotFound);
        }
        return true;
    }

    public boolean isReceiverPresent(String name){
        Optional<User> existingUser = userRepository.findByName(name);
        if(existingUser.isEmpty()){
            throw new UserNotFoundException(userNotFound);
        }
        return true;
    }
}
