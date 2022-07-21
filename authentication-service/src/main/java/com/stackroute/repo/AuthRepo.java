package com.stackroute.repo;

import com.stackroute.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepo extends JpaRepository<UserDto, String>  {


}
