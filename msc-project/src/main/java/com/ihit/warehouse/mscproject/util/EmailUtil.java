package com.ihit.warehouse.mscproject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * Created by User on 3/21/2021.
 */
@Component
public class EmailUtil {
    @Autowired
    private JavaMailSender sender;

    String orderList = "";
    public void manageMail(String type, String toAddress, String tokenValue) {
        switch (type) {
            case "UserApprove":
                String s = "http://localhost:8080/setpassword?tk="+tokenValue + "&v=" + String.valueOf(System.currentTimeMillis());
                System.out.println(s);
                sendEmail(null , "Request Accepted", toAddress);
        }
    }
    private void sendEmail(String mailBody, String subject, String toAddress) {
        try {
            MimeMessage message = sender.createMimeMessage();

            // Enable the multipart flag!
            MimeMessageHelper helper = new MimeMessageHelper(message, true);


            helper.setTo(toAddress);
        helper.setText("<html><body>Here is a cat picture! <img src='cid:id101'/><body></html>", true);
//            helper.setText(mailBody, true);
            helper.setSubject(subject);

//            ClassPathResource file = new ClassPathResource("evote_min.jpg");
//            helper.addInline("id101", file);

            sender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
