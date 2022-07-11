package com.stackroute.services;

import com.stackroute.model.Patient;
import com.stackroute.repositories.PatientRepository;
import com.stackroute.utility.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService
{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient createPatientProfile(Patient patient)
    {
        UserDto dto = new UserDto();
        dto.setEmailId(patient.getPatientEmail());
        dto.setPassword(patient.getPatientPassword());
        dto.setUserRole(patient.getUserRole());

        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findByEmailId(String patientEmail)
    {
        return patientRepository.findById(patientEmail);
    }

    @Override
    public Patient updatePatientProfile(Patient patient, String patientEmail)
    {
        return patientRepository.save(patient);
    }


}
