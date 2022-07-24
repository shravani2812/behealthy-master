package com.stackroute.service;

<<<<<<< HEAD

=======
import com.stackroute.Rabbitmq.UserDto;
>>>>>>> fde964c6bd0f91b2261e5b4a731cef699e85101e
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.model.User;

public interface UserService {
    void saveUser(User user);
    User findByEmailIdAndPassword(String emailId , String password) throws UserNotFoundException;








}
