package com.yavuzahmet.emailsender.dto;

import lombok.Data;

@Data
public class BaseMailRequest {
    private String receiver;
    private String subject;
    private String body;
}