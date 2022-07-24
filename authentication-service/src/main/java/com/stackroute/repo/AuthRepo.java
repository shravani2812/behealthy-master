package com.stackroute.repo;

import com.stackroute.Rabbitmq.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepo extends JpaRepository<UserDto, String>  {


}
