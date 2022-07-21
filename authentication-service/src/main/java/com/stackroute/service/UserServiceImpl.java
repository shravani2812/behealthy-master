package com.stackroute.service;

import com.stackroute.dto.UserDto;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.model.User;
import com.stackroute.repo.AuthRepo;
import com.stackroute.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepository;

    @Autowired
    private AuthRepo authRepository;
    @Autowired
    public UserServiceImpl(UserRepo userRepository){
        this.userRepository = userRepository;

    }

    //This method updates the user details.
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    //This is implemetation method of finding user by email id and password
    @Override
    public User findByEmailIdAndPassword(String emailId, String password) throws UserNotFoundException {
        User user =  userRepository.findByEmailIdAndPassword(emailId , password);
        if(user == null){
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public UserDto getUserDetails(UserDto userDto) {
        return authRepository.save(userDto);
    }

}
