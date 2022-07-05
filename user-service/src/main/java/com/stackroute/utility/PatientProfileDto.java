package com.stackroute.utility;

import com.stackroute.model.UserRole;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientProfileDto
{
    private String patientEmail;
    private String patientPassword;
    private UserRole userRole;
}
