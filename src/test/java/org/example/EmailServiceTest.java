package org.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class EmailServiceTest {

    @Test
    public void testSendRegistrationEmail() {
        EmailService emailService = new EmailService();
        EmailSender mockEmailSender = mock(EmailSender.class);
        emailService.setEmailSender(mockEmailSender); // Injektion des Mocks

        User user = new User("max.mustermann@example.com", "Max Mustermann");
        emailService.sendRegistrationEmail(user);

        verify(mockEmailSender).sendEmail(
                eq("max.mustermann@example.com"),
                eq("Willkommen bei unserer Anwendung!"),
                anyString() // Wir überprüfen nicht den genauen Inhalt der E-Mail
        );
    }
}
