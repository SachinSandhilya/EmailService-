package com.smtp.emailsender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smtp.emailsender.models.MailDetails;
import com.smtp.emailsender.service.MailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/mail")


public class MailController 
{

    @Autowired
    MailService mailService;

   @GetMapping("/launch")
    public String Launch()
    {
        return "Launched Successfully !!";
    }


    @PostMapping("/send")
    public  ResponseEntity<?> SendMail(@RequestBody MailDetails mailDetails) throws MessagingException
    {
        mailService.sendmail(mailDetails);
        return ResponseEntity.ok("Mail Sent successfully !!");
    }

    @PostMapping("/sendMailWithHtml")
    public  ResponseEntity<?> sendMailWithHtml(@RequestBody MailDetails mailDetails) throws MessagingException
    {
        mailService.sendmail(mailDetails);
        return ResponseEntity.ok("Mail Sent successfully !!");
    }
}
