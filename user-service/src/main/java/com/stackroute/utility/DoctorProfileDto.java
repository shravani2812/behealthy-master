package com.stackroute.utility;

import com.stackroute.model.UserRole;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorProfileDto
{
    private String doctorEmail;
    private String doctorPassword;
    private UserRole userRole;

}
