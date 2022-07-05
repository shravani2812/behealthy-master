package com.stackroute.controller;

import com.stackroute.model.Patient;
import com.stackroute.services.PatientService;
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
public class PatientController
{
    @Autowired
    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    //method to create a patient record in db

    @PostMapping("/patient")
    public ResponseEntity<Patient> createPatientProfile(@Valid @RequestBody Patient patient)
    {
        return new ResponseEntity<>(patientService.createPatientProfile(patient), HttpStatus.CREATED);
    }

}
