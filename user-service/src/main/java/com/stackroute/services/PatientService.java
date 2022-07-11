package com.stackroute.services;

import com.stackroute.model.Patient;

import java.util.Optional;

public interface PatientService
{
    public Patient createPatientProfile(Patient patient);

    public Optional<Patient> findByEmailId(String patientEmail);

    public Patient updatePatientProfile(Patient patient, String patientEmail);
}
