//*************************************************************************
// Title : A java programme to demonstrate Single Responsibility Principle.
// Author : Md Nazmul Huda Labib, CSE, Khulna University.
//*************************************************************************

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class represents a simple Logger responsible for logging messages.
 */
class Logger {

    /**
     * Logs a message to a file.
     *
     * @param message The message to log.
     */
    public void log(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true))) {
            writer.println(message);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}

/**
 * This class represents a simple EmailSender responsible for sending emails.
 */
class EmailSender {

    /**
     * Sends an email with the given subject and body.
     *
     * @param recipient The recipient of the email.
     * @param subject   The subject of the email.
     * @param body      The body of the email.
     */
    public void sendEmail(String recipient, String subject, String body) {
        // Code to send email
        System.out.println("Email sent to " + recipient + " with subject: " + subject + " and body: " + body);
    }
}

/**
 * This class demonstrates the usage of Logger and EmailSender classes.
 */
class Single_Responsibility_Principle {
    public static void main(String[] args) {
        // Log an error message using Logger
        Logger logger = new Logger();
        logger.log("Error: Null pointer exception occurred.");

        // Send an email using EmailSender
        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail("example@example.com", "Important Notification", "This is an important notification.");
    }
}

/**
 * In the above programme, the Logger class has a single responsibility of logging messages
 * to a file, and the EmailSender class has a single responsibility of sending emails.
 * Each class has its own specific task, adhering to the Single Responsibility Principle.
 */
