package org.example;

public class EmailService {
    private EmailSender emailSender;

    public EmailService() {
        // this.emailSender = new ...
    }

    // Setter für Dependency Injection (für Tests)
    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendRegistrationEmail(User user) {
        String to = user.getEmail();
        String subject = "Willkommen bei unserer Anwendung!";
        String body = "Hallo " + user.getName() + ",\n\n" +
                "vielen Dank für Ihre Registrierung!";

        emailSender.sendEmail(to, subject, body);
    }
}
