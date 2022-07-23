package com.stackroute.service;

import com.stackroute.Rabbitmq.UserDto;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.model.User;

public interface UserService {
    User saveUser(User user);
    User findByEmailIdAndPassword(String emailId , String password) throws UserNotFoundException;

    UserDto getUserDetails(UserDto userDto);



}
