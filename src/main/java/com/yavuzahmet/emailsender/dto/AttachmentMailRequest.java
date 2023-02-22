package com.yavuzahmet.emailsender.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachmentMailRequest extends BaseMailRequest{
    private String attachment;
}