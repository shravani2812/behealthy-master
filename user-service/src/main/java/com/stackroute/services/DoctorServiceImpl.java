package com.stackroute.services;

import com.stackroute.model.Doctor;
import com.stackroute.repositories.DoctorRepository;
import com.stackroute.rabbitMq.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService
{

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }


    @Override
    public Doctor createDoctorProfile(Doctor doctor)
    {
        UserDto dto = new UserDto();
        dto.setEmailId(doctor.getDoctorEmail());
        dto.setPassword(doctor.getDoctorPassword());
        dto.setUserRole(doctor.getUserRole());

        return doctorRepository.save(doctor);
    }

    @Override
    public Optional<Doctor> findById(String doctorEmail)
    {
        return doctorRepository.findById(doctorEmail);
    }

    @Override
    public List<Doctor> findDoctorBySpecialization(String specialization)
    {
        List<Doctor> doctors =doctorRepository.findBySpecialization(specialization);
        return doctors;
    }

    @Override
    public Doctor updateDoctorProfile(Doctor doctor, String doctorEmail)
    {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> findHospital(String hospitalLocation)
    {
        List<Doctor> hospitals = doctorRepository.findByHospitalLocation(hospitalLocation);
        return hospitals;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }


}
