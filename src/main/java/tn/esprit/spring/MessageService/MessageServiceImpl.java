package tn.esprit.spring.MessageService;


import static org.hamcrest.CoreMatchers.anyOf;
import javax.mail.Message.RecipientType;
import java.io.IOException;
import java.text.DateFormat;
import javax.mail.internet.InternetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.io.FileOutputStream;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessagePreparator;
import java.io.File;
import org.assertj.core.internal.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jayway.jsonpath.internal.Path;

import tn.esprit.spring.MessageRepository.DirectorRepository;
import tn.esprit.spring.MessageRepository.DoctorRepository;
import tn.esprit.spring.MessageRepository.InvitationRepository;
import tn.esprit.spring.MessageRepository.MessageRepository;
import tn.esprit.spring.MessageRepository.NotificationRepository;
import tn.esprit.spring.MessageRepository.ParentRepository;
import tn.esprit.spring.MessageRepository.UseRepository;
import tn.esprit.spring.MessageRepository.UserRepository;
import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.entities.Director;
import tn.esprit.spring.entities.Doctor;
import tn.esprit.spring.entities.EmailTemplate;
import tn.esprit.spring.entities.Etat;
import tn.esprit.spring.entities.Invitation;
import tn.esprit.spring.entities.Message;
import tn.esprit.spring.entities.Notification;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.User;
import org.springframework.data.domain.Sort;






@Service
public class MessageServiceImpl implements IMessageService{
@Autowired
UserRepository userrepository ;
@Autowired
MessageRepository messagerepository;
@Autowired
ParentRepository parentrepository;
@Autowired
DoctorRepository docteurrepository;
@Autowired
DirectorRepository directorrepository;
@Autowired
InvitationRepository invitationrepository;
@Autowired
UseRepository useRepository;
@Autowired
NotificationRepository notificationrepository;
@Autowired
NotificationServeur notification;
@Autowired
private JavaMailSender javaMailSender;
@Value("${email.address}")
private String attchEmailAddr;
@Value("${app.upload.dir:${user.home}}")
public String uploadDir;
@Autowired
private JavaMailSender mailSender;
 
/*@Override
public List<String> getAllAdmins() {
	List<Admin> users = (List<Admin>) userrepository.findAll();
	List<String> userAll = new ArrayList<>();
	
	for(Admin user : users){
		userAll.add(user.getLastName());
		
		
	}

	return userAll;
}*/


@Override
public List<Admin> getAllAdmins() {
	return (List<Admin>) userrepository.findAll();
}

/*@Override
public void addMessage(Message message) {
	messagerepository.save(message);
	
}*/

@Override
public List<Message> getAllMessages() {
	
	return (List<Message>) messagerepository.findAll();
}
//hedhi te5dm
@Override
public List<String> listerMessages(long idU ,long proprietaire) {
	User users = useRepository.findById((idU)).orElse(null);
	Parent propp=parentrepository.findById((proprietaire)).get();
	List<String> ss = new ArrayList<>();
	List<Boolean>b =new ArrayList<>();
	List<Date>d=new ArrayList<>();
	Notification nots = new Notification();
	for(Message msg : users.getMessages()){
		
		Notification notification = new Notification();
		ss.add(msg.getObjectM());
		ss.add(msg.getContentM());
		d.add(msg.getDateSend());
		b.add(msg.isMsgLu());
		msg.setMsgLu(true);
		nots.setMsgLu(true);
		ss.add(msg.getUsers().getFirstName());
		ss.add(b.toString());
		ss.add(d.toString());
		messagerepository.save(msg);
		
		}
for(Message msg : propp.getMessages()){
		
		Notification notification = new Notification();
		ss.add(msg.getObjectM());
		ss.add(msg.getContentM());
		d.add(msg.getDateSend());
		b.add(msg.isMsgLu());
		msg.setMsgLu(true);
		nots.setMsgLu(true);
		ss.add(msg.getUsers().getFirstName());
		ss.add(b.toString());
		ss.add(d.toString());
		messagerepository.save(msg);
		
		}
	
		//ss.add(msg.getDateSend());


return ss;
}
//lister msg pour parent
@Override
public List<String> listerMessagesP(long idU) {
	User users = parentrepository.findById((idU)).orElse(null);
	List<String> ss = new ArrayList<>();
	for(Message msg : users.getMessages()){
		ss.add(msg.getObjectM());
		ss.add(msg.getContentM());
		
	}

return ss;
}
//lister msg pour docteur
@Override
public List<String> listerMessagesDoc(long idU) {
	User users = docteurrepository.findById((idU)).orElse(null);
	List<String> ss = new ArrayList<>();
	List<Date>dd=new ArrayList<>();
	
	for(Message msg : users.getMessages()){

	
		ss.add(msg.getObjectM());
		ss.add(msg.getContentM());
		dd.add(msg.getDateSend());
		 String dateStr = String.valueOf(dd);
		 ss.add(dateStr);
		
		
	}

return ss;

}
//lister msg pour directeur
@Override
public List<String> listerMessagesDir(long idU) {
	User users = directorrepository.findById((idU)).orElse(null);
	List<String> ss = new ArrayList<>();
	for(Message msg : users.getMessages()){
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		date =msg.getDateSend();
		String strDate = dateFormat.format(date);
         
		ss.add(msg.getObjectM());
		ss.add(msg.getContentM());
		ss.add(strDate);

	}

return ss;
}



public List<String>getAllMessageContentMByIdU( long idU) {
	User use = userrepository.findById(idU).get();
	List<String> depNames = new ArrayList<>();
	for(Message dep : use.getMessages()){
		
		depNames.add(dep.getContentM());
	}
	
	return depNames;
}

@Override
public List<Message> getAllMessageByUsers(Message message) {
	// TODO Auto-generated method stub
	return messagerepository.getAllMessageByUsers( message);
}

@Override
public User authenticate(String email, String password) {
	return userrepository.getUserByEmailAndPassword(email, password);
}
//hedhi te5dm
@Override
public void addMessageA(long idU, Message message,long autreId,MultipartFile file) throws IllegalStateException, IOException, MessagingException  {
	User users =  useRepository.findById((idU)).orElse(null);
	
	String froms =users.getEmail();
	User autreIdd=useRepository.findById((autreId)).get();
	String to =autreIdd.getEmail();
	users.setAutre(autreIdd);
	 
	
	String mail=autreIdd.getEmail();
	//Notification no =new Notification (message.getObjectM(), froms, autreIdd); 
	Notification notification = new Notification();

    if(users.getIdU()!=(autreId)){
    message.setUsers(users);
	message.setFr(froms);
	message.setUser(autreIdd);
	//message.setDateSend(System.currentTimeMillis());
	//String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
   // message.setPicture(fileName);

file.transferTo(new File("C:\\upload\\"+autreIdd+file.getOriginalFilename()));
message.setPicture("image"+autreIdd+file.getOriginalFilename());
//message.setPicture(file.getContentType());
	notification.setUsers(users);
	notification.setUser(autreIdd);
	notification.setTitleN(message.getObjectM());
	notification.setContentN(message.getContentM());
	notification.setMsgLu(message.isMsgLu());
	EmailTemplate nots = new EmailTemplate(mail ,message.getObjectM(),message.getContentM() );
	sendTextEmail(nots);
	//sendMailWithAttachment(nots,file);
	notificationrepository.save(notification);
	messagerepository.save(message);
	
	}

	
}
@Override
public void SendInvitation(long idU , Invitation invitation ,long proprietaire) {
  Parent parent =  parentrepository.findById((idU)).orElse(null);
  // parent.setProprietaire(parent);
   Parent propp=parentrepository.findById((proprietaire)).get();
   parent.setProprietaire(propp);

  // long invitId =invitation.getId();
   //Invitation invitations =  invitationrepository.findById((invitId)).orElse(null);
   Parent po= parent.getProprietaire();
   Etat io =invitation.getEtat();
   if(parent.getIdU()!=(propp.getIdU()))
   {
   invitation.setSend(parent);
   invitation.setReceive(po);
   invitation.setEtat(io.WAITING);
   //User u= new User("nes", "nes", "hh", "nesrinezouaoui583@gmail.com");
  // notification.sendNotification(u);
   }   
   invitationrepository.save(invitation);
}
//add message pour parent
@Override
public void addMessageP(long idU, Message message) {
	User users =  parentrepository.findById((idU)).orElse(null);
	String froms =users.getEmail();
    //User autreIdd=useRepository.findById((autreId)).get();
    message.setUsers(users);
	message.setFr(froms);
	//message.setUser(autreIdd);
	if(listerMessagesP(idU) ==null)
	{message.setMsgLu(true);}
	else{message.setMsgLu(false);}
	messagerepository.save(message);
	
}
//add message pour doctor
@Override
public void addMessageDoc(long idU, Message message) {
	User users =  docteurrepository.findById((idU)).orElse(null);
	
	
	message.setUsers(users);
	messagerepository.save(message);
	
}
//add message pour director
@Override
public void addMessageDir(long idU, Message message) {
	User users =  directorrepository.findById((idU)).orElse(null);
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	Date d= new Date();
	try {
		d = dateFormat.parse("01/02/2015");
		
		message.setUsers(users);
		message.setDateSend(d);
		messagerepository.save(message);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}


/*
@Override
public void listerInvitation(long idU) {
	Parent users = parentrepository.findById((idU)).orElse(null);
	
	List<String> ss = new ArrayList<>();
	for(Invitation invit : users.getProprietaire(){
		//ss.add(msg.getObjectM());
		//ss.add(msg.getContentM());
		
}*/

	@Override
	public List<Invitation> getAllInvitation() {
		return (List<Invitation>) invitationrepository.findAll();
	}

	@Override
	public List<Parent> getAllParents() {
		return (List<Parent>) parentrepository.findAll();
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return (List<Doctor>) docteurrepository.findAll();
	}

	@Override
	public List<Director> getAllDirectors() {
		return (List<Director>) directorrepository.findAll();
	}

	@Override
	public void Accept( long idU ,Invitation invitation,long proprietaire ) {
		
		/*Parent receive=invitation.getReceive();
	    Parent send =invitation.getSend();
		invitation.setReceive(receive);
		invitation.setSend(send);*/
		  Parent parent =  parentrepository.findById((idU)).orElse(null);
		  // parent.setProprietaire(parent);
		   Parent propp=parentrepository.findById((proprietaire)).get();
		   Parent po= parent.getProprietaire();
		   invitation.setSend(parent);
		   invitation.setReceive(po);
		Etat i =Etat.ACCEPET;
		
		  invitation.setEtat(i);
	    invitationrepository.save(invitation);
		
	}

	@Override
	public void Refuse(long idU, Invitation invitation, long proprietaire) {
		  Parent parent =  parentrepository.findById((idU)).orElse(null);
		  // parent.setProprietaire(parent);
		   Parent propp=parentrepository.findById((proprietaire)).get();
		   Parent po= parent.getProprietaire();
		   
		   invitation.setSend(parent);
		   invitation.setReceive(po);
		Etat i =Etat.REFUSE;
		
		  invitation.setEtat(i);
	    invitationrepository.save(invitation);
	    
	}
	
	@Override
	public List<String> listerInvitation(long idU) {
		Parent parent =  parentrepository.findById((idU)).orElse(null);
		List<Invitation> invit = (List<Invitation>) invitationrepository.findAll();
		List<String> user = new ArrayList<>();
		Etat io =null;
		for(Invitation categori : invit){
			if(categori.getSend().getIdU()==idU ){
			user.add(categori.getSend().getEmail());
			user.add(categori.getEtat().toString());
			
			}
			else
			{
				user.add(categori.getReceive().getEmail());
				user.add(categori.getEtat().toString());
			}
			}
			
			
		

		return user;

	}

	@Override
	public List<Invitation> getInvitationsBySend( long sendId) {

	
		return invitationrepository.getInvitationsBySend(sendId);
	}

	@Override
	public List<String> getListAmis(long idU ) {
		Parent parent =  parentrepository.findById((idU)).orElse(null);
		//Parent propp=parentrepository.findById((proprietaire)).get();
		List<Invitation> invit = (List<Invitation>) invitationrepository.findAll();
		List<String> user = new ArrayList<>();
		Etat io =Etat.ACCEPET;
	
		for(Invitation inv : invit){
			
			if( inv.getEtat()==Etat.ACCEPET & inv.getReceive().getIdU()==idU )
				{user.add(inv.getSend().getEmail());}
			else {user.add(inv.getReceive().getEmail());}
			
				
				
				
				
		
		}return user;
	
 
}
	@Override
	public void deleteAmis(long id) {
		Parent parent =  parentrepository.findById((id)).orElse(null);
		List<Invitation> invit = (List<Invitation>) invitationrepository.findAll();
		List<String> user = new ArrayList<>();
		Etat io =Etat.ACCEPET;
		for(Invitation inv : invit){
		if( inv.getEtat()==Etat.ACCEPET & inv.getReceive().getIdU()==id )
		{invitationrepository.delete(invitationrepository.findById(id).get());}
		else{invitationrepository.delete(invitationrepository.findById(id).get());}
		}
	}


	@Override
	public void deleteInvitationById(long id) {
		invitationrepository.delete(invitationrepository.findById(id).get());
		
	}
	@Override
	public void deleteMessageById(long id) {
		Message msg = messagerepository.findById((id)).orElse(null);
		
		if(msg.isMsgLu()==false){
			messagerepository.delete(messagerepository.findById(id).get());}
		
	}
	@Override
	public List<String> listerNotifications(long idU) {
		User users = useRepository.findById((idU)).orElse(null);
		List<String> ss = new ArrayList<>();

		for(Notification not : users.getNotifications()){
			ss.add(not.getTitleN());
			ss.add(not.getContentN());
			//ss.add(not.getUsers().getFirstName());
			notificationrepository.save(not);
			//ss.add(msg.getDateSend());
	}

	return ss;
	}

	@Override
	public void deleteNotificationById(long id) {
		notificationrepository.delete(notificationrepository.findById(id).get());
		
	}



	public void sendTextEmail(EmailTemplate notification) {
	
		MimeMessage msg = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setTo(notification.getSendTo());
			helper.setSubject(notification.getSubject());
			helper.setText(notification.getBody());
			//helper.setSentDate(notification.getDateSend());
				//msg.(notification.getPicture().getOriginalFilename());
				FileSystemResource file = new FileSystemResource("C:\\upload\\file.jpg");
				helper.addAttachment(file.getFilename(), file);
				javaMailSender.send(msg);
			
	
		}
	
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}


	public void sendEmailWithAttachments(MultipartFile multipartFile,  String u ,EmailTemplate notification) throws MessagingException {

		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		
		try {
			if (attchEmailAddr.contains(",")) {
				String[] emails = attchEmailAddr.split(",");
				int receipantSize = emails.length;				
				
					helper.setTo(u);
					helper.setSubject(notification.getSubject());
					helper.setText(notification.getBody(), true);
					FileSystemResource file = new FileSystemResource("C:\\upload\\file.jpg");
					helper.addAttachment(file.getFilename(), file);
					javaMailSender.send(msg);
				

			} else {
				helper.setTo(attchEmailAddr);
				helper.setSubject("Attachment File !");
				// default = text/plain
				// true = text/html
				helper.setText("<h1>" + "Find the Attachment file" + "</h1>", true);
				InputStreamSource attachment = new ByteArrayResource(multipartFile.getBytes());

				helper.addAttachment(multipartFile.getOriginalFilename(), attachment);
				javaMailSender.send(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*@Override
	public void uploadFile(MultipartFile file ,long id) throws IllegalStateException, IOException, MessagingException {
		Message message =  messagerepository.findById((id)).orElse(null); 
		ClassLoader classLoader = getClass().getClassLoader();
         String path =  classLoader.getResource(".").getFile();
		file.transferTo(new File("C:\\upload\\"+"image" + message+file.getOriginalFilename()));
		
		
		
		message.setPicture("image"+message+file.getOriginalFilename());
		sendEmailWithAttachment(file);
		messagerepository.save(message);
	}*/
	public void sendMailWithAttachment(EmailTemplate notification,MultipartFile multipartFile) 
	{
	    MimeMessagePreparator preparator = new MimeMessagePreparator() 
	    {
	        public void prepare(MimeMessage mimeMessage) throws Exception 
	        {
	            mimeMessage.setRecipient(RecipientType.TO, new InternetAddress(notification.getSendTo()));
	            mimeMessage.setFrom(new InternetAddress("nesrinezouaoui583@gmail.com"));
	            mimeMessage.setSubject(notification.getSubject());
	            mimeMessage.setText(notification.getBody());
	             
	            //FileSystemResource file = new FileSystemResource(new File(fileToAttach));
	            InputStreamSource attachment = new ByteArrayResource(multipartFile.getBytes());
	            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	            helper.addAttachment(multipartFile.getOriginalFilename(), attachment);
	        }
	    };
	     
	    try {
	        mailSender.send(preparator);
	    }
	    catch (MailException ex) {
	        // simply log it and go on...
	        System.err.println(ex.getMessage());
	    }
	}

	@Override
	public List<Message> listAll() {
		 
		        return messagerepository.findAll(Sort.by("dateSend").ascending());
		    
	}

	



}