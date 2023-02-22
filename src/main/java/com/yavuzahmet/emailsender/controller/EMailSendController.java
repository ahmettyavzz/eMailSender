package com.yavuzahmet.emailsender.controller;

import com.yavuzahmet.emailsender.dto.AttachmentMailRequest;
import com.yavuzahmet.emailsender.dto.BaseMailRequest;
import com.yavuzahmet.emailsender.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/send")
public class EMailSendController {
    private final MailService mailService;

    @PostMapping
    public String sendMail(@RequestBody BaseMailRequest mailRequest) {
        return mailService.sendEmail(mailRequest);
    }

    @PostMapping("/attachment")
    public String sendMailToAttachment(@RequestBody AttachmentMailRequest mailRequest) {
        return mailService.sendEmailAttachment(mailRequest);
    }
}