/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.email;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author HP
 */
public class EmailConfig {
    public static void main(String[] args) throws EmailException {
 
        // Tạo đối tượng Email
        Email email = new SimpleEmail();
 
        // Cấu hình thông tin Email Server
        email.setHostName(MailConfig.HOST_NAME);
        email.setSmtpPort(MailConfig.SSL_PORT);
        email.setAuthenticator(new DefaultAuthenticator(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD));
        email.setSSLOnConnect(true);
 
        // Người gửi
        email.setFrom(MailConfig.APP_EMAIL);
 
        // Người nhận
        email.addTo(MailConfig.RECEIVE_EMAIL);
 
        // Tiêu đề
        email.setSubject("Testing Subject");
 
        // Nội dung email
        email.setMsg("Code reset password : 1234");
 
        // send message
        email.send();
 
        System.out.println("Message sent successfully");
    }
}
