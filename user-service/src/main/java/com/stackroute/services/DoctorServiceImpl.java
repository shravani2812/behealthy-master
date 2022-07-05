package com.stackroute.services;

import com.stackroute.model.Doctor;
import com.stackroute.repositories.DoctorRepository;
import com.stackroute.utility.DoctorProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService
{

    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    public Doctor createDoctorProfile(Doctor doctor)
    {
        DoctorProfileDto dto = new DoctorProfileDto();
        dto.setDoctorEmail(doctor.getDoctorEmail());
        dto.setDoctorPassword(doctor.getDoctorPassword());
        dto.setUserRole(doctor.getUserRole());

        return doctorRepository.save(doctor);
    }
}
