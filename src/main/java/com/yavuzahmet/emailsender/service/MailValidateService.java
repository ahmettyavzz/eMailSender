package com.yavuzahmet.emailsender.service;

import java.util.regex.Pattern;

public class MailValidateService {
    public static boolean isEmailValid(String email) {
        {
            if (email == null || email.isEmpty()) {
                return false;
            }
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            return pattern.matcher(email).matches();
        }
    }
}