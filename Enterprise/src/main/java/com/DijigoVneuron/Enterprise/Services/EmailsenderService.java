package com.DijigoVneuron.Enterprise.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailsenderService {
    @Autowired
    private JavaMailSender mailSender;
    public void sendmail(String toemail,
                         String subject,
                         String body){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("ahmedmeh36@gmail.com");
        simpleMailMessage.setTo(toemail);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);
        mailSender.send(simpleMailMessage);

    }
}
