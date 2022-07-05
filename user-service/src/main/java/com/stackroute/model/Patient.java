package com.stackroute.model;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Document(collection = "patientProfile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient
{
    @Id
    @Email
    @NotNull
    private String patientEmail;
    private Binary patientImage;
    private String patientName;
    @NotNull
    private String patientPassword;
    private Long patientMobile;
    private Gender gender;
    private String patientCity;
    private UserRole userRole;

}
