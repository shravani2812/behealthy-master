package com.stackroute.services;

import com.stackroute.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService
{
    public Doctor createDoctorProfile(Doctor doctor);

    public Optional<Doctor> findById(String doctorEmail);

    public List<Doctor> findDoctorBySpecialization(String specialization);

    public Doctor updateDoctorProfile(Doctor doctor, String doctorEmail);

    public List<Doctor> findHospital(String hospitalLocation);

    public List<Doctor> getAllDoctors();

}
