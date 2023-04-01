package org.sid.service;


import org.sid.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;
	@Autowired
	public NotificationService (JavaMailSender javaMailSender)
	{
		this.javaMailSender=javaMailSender;
	}
	public void sendNotification(User user)throws Exception
	{
		SimpleMailMessage mail=new SimpleMailMessage();
		 mail.setTo(user.getEmailAdress());
		 mail.setFrom("wasimabidi01@gmail.com");
		 mail.setSubject("this is a simple notification");
		 mail.setText("this is a notification");
		 javaMailSender.send(mail);
	}
}
