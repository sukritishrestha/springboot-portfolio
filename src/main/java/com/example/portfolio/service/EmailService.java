package com.example.portfolio.service;

import com.example.portfolio.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;


    public void sendContactEmail(Contact contact) {
        sendEmail(contact.getEmail(), contact.getName(), contact.getMessage());
    }

    public void sendEmail(String from, String name, String message) {

        SimpleMailMessage mail = new SimpleMailMessage();

        // email where you want to receive messages
        mail.setTo("sukustha39@gmail.com");

        // subject
        mail.setSubject("Portfolio Contact Message");

        // reply to sender
        mail.setReplyTo(from);

        // email body
        mail.setText(
                "Name: " + name +
                        "\nEmail: " + from +
                        "\n\nMessage:\n" + message
        );

        mailSender.send(mail);
    }
}