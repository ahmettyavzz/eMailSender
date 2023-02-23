# Email Sender

This project is a sample application for sending emails using Spring Boot and JavaMailSender.

### Configuration

Before using this application, you need to set up your email sending settings in the application.properties file. An
example file is shown below:

```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=example@example.com
spring.mail.password=your_password
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.auth=true
```

### Usage

`POST /v1/send `

To send a basic email, make a POST request to /v1/send with the following payload:

```
{
"receiver": "example@example.com",
"subject": "Test Mail",
"body": "Hello World!"
}
```

`POST /v1/send/attachment `

To send an email with an attachment, make a POST request to /v1/send/attachment with the following payload:

```
{
  "receiver": "example@example.com",
  "subject": "Test Mail",
  "body": "Hello World!",
  "attachment": "/path/to/attachment"
}
```





