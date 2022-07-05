package com.stackroute.model;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Document(collection = "doctorProfile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Doctor
{

    @Id
    @Email
    @NotNull
    private String doctorEmail;
    private Binary doctorImage;
    private String doctorName;
    private Long doctorMobile;
    @NotNull
    private String doctorPassword;
    private String doctorCity;
    private Gender gender;
    private String qualification;
    private String specialization;
    private String YOE;
    private UserRole userRole;

}
