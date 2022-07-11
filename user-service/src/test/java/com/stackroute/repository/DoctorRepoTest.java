package com.stackroute.repository;

import com.stackroute.model.Doctor;
import com.stackroute.model.Gender;
import com.stackroute.model.UserRole;
import com.stackroute.repositories.DoctorRepository;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class DoctorRepoTest
{
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private Doctor doctor;

    @BeforeEach
    void setUp()
    {
        doctor = new Doctor();
        doctor.setDoctorEmail("tannu@gmail.com");
        doctor.setDoctorPassword("t@123");
        doctor.setUserRole(UserRole.DOCTOR);
        doctor.setDoctorImage("IMg");
        doctor.setFirstName("Tannu");
        doctor.setLastName("Gowda");
        doctor.setAddress("12, 2nd cross Jayanagar");
        doctor.setAge("24");
        doctor.setGender(Gender.FEMALE);
        doctor.setContactNo(9855554444L);
        doctor.setGraduation("MBBS");
        doctor.setMrn("7787727278");
        doctor.setSpecialization("Orthopedic");
        doctor.setYoe("3");
        doctor.setHospitalLocation("Bengaluru");
        doctor.setHospitalName("Forties");
    }

    @AfterEach
    void tearDown()
    {
        doctorRepository.deleteAll();
        doctor = null;
    }

    @Test
    public void toSaveDoctorAndReturnSavedDoctor()
    {
        doctorRepository.save(doctor);
        Doctor doctor1 = doctorRepository.findById(doctor.getDoctorEmail()).get();
        assertEquals("tannu@gmail.com", doctor1.getDoctorEmail());
    }

}
