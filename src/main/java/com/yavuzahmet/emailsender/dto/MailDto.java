package com.yavuzahmet.emailsender.dto;

import lombok.Data;

@Data
public class MailDto {
    private String receiver;
    private String sender;
    private String subject;
    private String body;
}