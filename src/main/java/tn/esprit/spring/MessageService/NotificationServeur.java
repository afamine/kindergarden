package tn.esprit.spring.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.spring.MessageRepository.UseRepository;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.User;

@Service
public class NotificationServeur {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	UseRepository useRepository;
	public NotificationServeur(JavaMailSender javaMAilSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotification(User parent){
		
		String password="";
		
		for (int i=0;i<10;i++ ) {
			password = password+randomCharacter("abcdefjhijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUV");
		}
		String randomdigit=randomCharacter("123456789");
		password=insertAtRandom(password, randomdigit);
		String randomSymbol=randomCharacter("+-*/§/.?$&£@@@");
		password = insertAtRandom(password, randomSymbol);
		parent.setPassword(password);
		useRepository.save(parent);
		
		//sending email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(parent.getEmail());
		mail.setFrom("nesrinezouaoui583@gmail.com");
		mail.setSubject("nesrine");
		mail.setText(password);
		javaMailSender.send(mail);
	}
	public static String randomCharacter(String charachter) {
		int n = charachter.length();
		int r = (int)(n*Math.random());
		
		return charachter.substring(r,r+1);
	}
	public static String insertAtRandom(String str,String toInsert) {
		int n = str.length();
		int r=(int)(n * Math.random());
		return str.substring(0,r)+ toInsert + str.substring(r);
	}	
	
	
	
}
