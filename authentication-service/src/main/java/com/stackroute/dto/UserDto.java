package com.stackroute.dto;

import com.stackroute.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class UserDto {
    @Id
    private String emailId;
    private String password;
    private UserRole userRole;

}
