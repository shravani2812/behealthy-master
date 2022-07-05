package com.stackroute.services;

import com.stackroute.model.Patient;
import com.stackroute.repositories.PatientRepository;
import com.stackroute.utility.PatientProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService
{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient createPatientProfile(Patient patient)
    {
        PatientProfileDto dto = new PatientProfileDto();
        dto.setPatientEmail(patient.getPatientEmail());
        dto.setPatientPassword(patient.getPatientPassword());
        dto.setUserRole(patient.getUserRole());

        return patientRepository.save(patient);
    }
}
