package com.stackroute.controller;

import com.stackroute.model.Doctor;
import com.stackroute.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class DoctorController
{
    @Autowired
    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    //method to create a doctor record in db

    @PostMapping("/doctor")
    public ResponseEntity<Doctor> createDoctorProfile(@Valid @RequestBody Doctor doctor)
    {
        return new ResponseEntity<>(doctorService.createDoctorProfile(doctor), HttpStatus.CREATED);
    }





}
