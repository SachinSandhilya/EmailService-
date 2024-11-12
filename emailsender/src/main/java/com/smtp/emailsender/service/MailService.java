package com.smtp.emailsender.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.smtp.emailsender.models.MailDetails;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService 
{

    @Autowired 
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromMail;


    public void sendmail(MailDetails mailDetails) throws MessagingException
     {
       
        MimeMessage mimeMessage= javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        
        helper.setTo(mailDetails.getToMail());
        helper.setFrom(fromMail);
        helper.setSubject(mailDetails.getSubject());
        helper.setText(mailDetails.getBody());
       
        // First getting the attachement-path 
        String attachmentPath = mailDetails.getAttachmentPath();
        File file = new File(attachmentPath);

        helper.addAttachment(file.getName(), file);

        javaMailSender.send(mimeMessage);
      
     }


}
