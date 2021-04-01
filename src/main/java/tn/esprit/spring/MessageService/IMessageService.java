package tn.esprit.spring.MessageService;

import java.io.IOException;
import java.util.Date;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.entities.Director;
import tn.esprit.spring.entities.Doctor;
import tn.esprit.spring.entities.EmailTemplate;
import tn.esprit.spring.entities.Invitation;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Message;
import tn.esprit.spring.entities.Notification;




public interface IMessageService {
	//public List<User> getAllUsers();
	//public List<String> getAllAdmins();
	public List<Admin> getAllAdmins();
	public List<Parent> getAllParents();
	public List<Doctor> getAllDoctors();
	public List<Director> getAllDirectors();
    //public void addMessage(Message message);
    public void addMessageA(long idU ,Message message ,long autreId,MultipartFile file )  throws IllegalStateException, IOException , MessagingException;
    public void addMessageP(long idU ,Message message);
    public void addMessageDoc(long idU ,Message message);
    public void addMessageDir(long idU ,Message message);
    public List<Message> getAllMessages();
    public List<String>listerMessages(long idU,long proprietaire);
    public List<String>listerMessagesP(long idU );
    public List<String>listerMessagesDoc(long idU);
    public List<String>listerMessagesDir(long idU);
    public List<String>getAllMessageContentMByIdU( long idU);
    public List<Message> getAllMessageByUsers(Message message);
	public User authenticate(String email, String password);
	public void SendInvitation(long idU ,Invitation invitation,long proprietaire);
	public void Accept(long idU ,Invitation invitation,long proprietaire );
	public void Refuse(long idU ,Invitation invitation,long proprietaire);
	//public void listerInvitation(long id);
	//public List<Integer>listerInvitation(long id);
	public List<Invitation> getAllInvitation();
	public List<String> listerInvitation(long idU) ;
	public List<Invitation> getInvitationsBySend( long sendId);
	public List<String> getListAmis( long idU);
	public void deleteInvitationById(long id);
	public List<String>listerNotifications(long idU);
	public void deleteNotificationById(long id);
	public void sendTextEmail(EmailTemplate notification);
	//public void sendEmailWithAttachment(MultipartFile file ,  String u,EmailTemplate notification)throws MessagingException ;
	//public void uploadFile(MultipartFile file,long id)throws IllegalStateException, IOException,MessagingException;
	public void sendMailWithAttachment(EmailTemplate notification, MultipartFile fileToAttach) ;
	List<Message> listAll();
	void deleteMessageById(long id);
	void deleteAmis(long id);
}
