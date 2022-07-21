package com.stackroute.appointmentService.controller;


import com.stackroute.appointmentService.model.Timeslot;
import com.stackroute.appointmentService.service.SequenceGeneratorService;
import com.stackroute.appointmentService.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class TimeslotController {

    @Autowired
    TimeslotService timeslotService;
    @Autowired
    public SequenceGeneratorService sequenceGeneratorService;

     // to save timeslot

      @PostMapping("/saveTimeslot")
      public ResponseEntity<Timeslot> saveSlot(@RequestBody Timeslot timeslot) {
      timeslot.setSlotId(sequenceGeneratorService.getSequenceNumber(Timeslot.SEQUENCE_NAME));
      timeslot.setSlotAvailability(true);
      Timeslot slot= timeslotService.createSlot(timeslot);
      return new ResponseEntity(slot, HttpStatus.CREATED);
    }

   // to update slot availability by slotId

    @PatchMapping("/updateSlotAvailability/{slotId}")
    public ResponseEntity<Timeslot> updateSlotAvailability(@PathVariable(name="slotId" ) int slotId) {
       Timeslot slot = timeslotService.updateSlotAvailabilityBySlotId(slotId);
       return new ResponseEntity<>(slot, HttpStatus.OK);

    }


   // to get timeslot by slotDate and doctorEmail

    @GetMapping("/slotByDate/{slotDate}/{doctorEmail}")
    public ResponseEntity<List<Timeslot>> getSlotByDate(@PathVariable(name = "slotDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate slotDate
            ,@PathVariable("doctorEmail") String doctorEmail) {

        List<Timeslot> list= timeslotService.getSlotByDateAndDoctorEmail(slotDate,doctorEmail);

        return new ResponseEntity<>(list,HttpStatus.OK);
    }








}
