package OnlineAuction.service.Impl;

import OnlineAuction.entity.User;
import OnlineAuction.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService{

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendByEmail(String email, String message) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessage.setFrom(new InternetAddress("yosyp0108khemych@gmail.com"));
            helper.setTo(email);
            helper.setText(message, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }

    public void sendByUser(User user, String message) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessage.setFrom(new InternetAddress("yosyp0108khemych@gmail.com"));
            helper.setTo(user.getEmail());
            helper.setText(message, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }

}
