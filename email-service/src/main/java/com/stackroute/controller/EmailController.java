package com.stackroute.controller;

import com.stackroute.model.Email;
import com.stackroute.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")

public class EmailController {

    @Autowired
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }



    // method to send-email
    @PostMapping("/sendemail")
    public String sendEmail(@RequestBody Email email){

        String status = emailService.sendEmail(email);
        return status;
    }



   /* // method to send-email
    @PostMapping("/sendemail")
    public ResponseEntity<?> sendEmail(@RequestBody Email email){

     //   Email email1 = emailService.sendEmail(email);
       // return new ResponseEntity<Email>(email1, HttpStatus.OK);
        try{
            emailService.sendEmail(email);
            return new ResponseEntity<String>("Email Sent Successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Email Sending Failure", HttpStatus.EXPECTATION_FAILED);
        }
    }*/

}
