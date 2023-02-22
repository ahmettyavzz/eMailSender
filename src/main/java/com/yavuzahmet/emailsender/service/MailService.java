package com.yavuzahmet.emailsender.service;

import com.yavuzahmet.emailsender.dto.AttachmentMailRequest;
import com.yavuzahmet.emailsender.dto.BaseMailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;
    private final MailProperties mailProperties;

    public String sendEmail(BaseMailRequest mailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailRequest.getReceiver());
        message.setSubject(mailRequest.getSubject());
        message.setText(mailRequest.getBody());
        mailSender.send(message);
        return returnMessage(mailProperties.getUsername(), mailRequest.getReceiver());
    }

    public String sendEmailAttachment(AttachmentMailRequest mailRequest) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(mailRequest.getReceiver());
            mimeMessageHelper.setText(mailRequest.getBody());
            mimeMessageHelper.setSubject(mailRequest.getSubject());
            FileSystemResource file = new FileSystemResource(new File(mailRequest.getAttachment()));
            mimeMessageHelper.addAttachment(Objects.requireNonNull(file.getFilename()), file);

            mailSender.send(mimeMessage);

            return returnMessage(mailProperties.getUsername(), mailRequest.getReceiver());
        } catch (MessagingException e) {
            return "Error while sending mail";
        }
    }

    public String returnMessage(String sender, String receiver) {
        return "Message sent from " + sender + " to " + receiver;
    }
}
