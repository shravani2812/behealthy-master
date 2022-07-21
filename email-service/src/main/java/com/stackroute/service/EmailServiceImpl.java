package com.stackroute.service;

import com.stackroute.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;


    public String sendEmail(Email email) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
          //  mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(email.getTo());
            mimeMessageHelper.setSubject("Be Healthy Appointment Booking Details");
            mimeMessageHelper.setText(email.getMessage());

          /*  FileSystemResource file = new FileSystemResource(new File(email.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);
*/            javaMailSender.send(mimeMessage);

            return "Mail Sent Successfully...";

        }

        catch (MessagingException e) {

            return "Error while sending mail!!!";

        }
    }



   /* @Override
    public Email sendEmail(Email email) {

        try{
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("sendermail79@gmail.com");
            message.setTo(email.getTo());
          //  message.setSubject("Be Healthy Appointment Booking Details");
            message.setSubject(email.getSubject());
            message.setText(email.getMessage());

            javaMailSender.send(message);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return email;
    }*/
}




