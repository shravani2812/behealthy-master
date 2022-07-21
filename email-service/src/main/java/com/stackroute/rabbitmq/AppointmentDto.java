package com.stackroute.rabbitmq;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AppointmentDto {

    private String patientEmail;
    private String doctorEmail;
    private LocalDate appointmentDate;
    private LocalTime appointmentStartTime;
    private LocalTime appointmentEndTime;
}
