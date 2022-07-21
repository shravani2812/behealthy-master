package com.stackroute.config;

import com.stackroute.model.Email;
import com.stackroute.rabbitmq.AppointmentDto;
import com.stackroute.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private EmailService emailService;

    

    @RabbitListener(queues = MessageConfiguration.QUEUE)
    public void consumeUserDetails(AppointmentDto appointmentDto){
        System.out.println(appointmentDto.toString());
        Email email = new Email();
        email.setTo(appointmentDto.getPatientEmail());
        email.setMessage(" Your Appointment is Booked on:- " + appointmentDto.getAppointmentDate().toString() +
                " Your Appointment will begin at:- "+ appointmentDto.getAppointmentStartTime().toString() +
                "Your Appointment ends at:- " + appointmentDto.getAppointmentEndTime().toString());

        emailService.sendEmail(email);
    }

}
