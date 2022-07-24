package com.stackroute.config;

<<<<<<< HEAD
import com.stackroute.dto.UserDto;
=======

import com.stackroute.Rabbitmq.UserDto;
>>>>>>> fde964c6bd0f91b2261e5b4a731cef699e85101e
import com.stackroute.model.User;
import com.stackroute.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    UserService userService;

    @RabbitListener(queues = "auth_queue")
    public void consumeUserDetails(UserDto userDto){
        System.out.println(userDto.toString());
        User user = new User();
        user.setEmailId(userDto.getEmailId());
        user.setPassword(userDto.getPassword());
        user.setUserRole(userDto.getUserRole());
         userService.saveUser(user);

    }



}
