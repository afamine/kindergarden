package tn.esprit.spring.MessageController;

import java.io.File;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.el.ELException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletResponse;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.Nullable;
import java.util.LinkedHashMap;
import tn.esprit.spring.MessageRepository.MessageRepository;
import tn.esprit.spring.MessageRepository.NotificationRepository;
import tn.esprit.spring.MessageRepository.UserRepository;
import tn.esprit.spring.MessageService.IMessageService;
import tn.esprit.spring.MessageService.NotificationServeur;
import tn.esprit.spring.MessageService.TransactionExcelExporter;
import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.entities.Director;
import tn.esprit.spring.entities.Doctor;
import tn.esprit.spring.entities.EmailTemplate;
import tn.esprit.spring.entities.Invitation;
import tn.esprit.spring.entities.Message;
import tn.esprit.spring.entities.Notification;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.User;

import org.springframework.util.StringUtils;





@Scope(value = "session")
@Controller (value = "messageController")
@ELBeanName(value = "messageController")
@Join(path = "/", to = "/login.jsf")
public class ControllerMessageImpl {
	@Autowired
	NotificationServeur notification;
	@Autowired
	IMessageService iMessageService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	MessageRepository messageRepository;
	@Autowired
	NotificationRepository notificationrepository;
	private Long idU;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String picture;
	private Boolean loggedIn;
	private List<User> afficher;
	private String objectM;
    private String contentM;
    private List<Message> messages;
    private List<String>msgs;
    private long id;
    private User user;
	private Parent send;
	private Parent receive;
	private String from;
    @Temporal(TemporalType.DATE)
    private Date dateSend;
    public String dologin() {
    	String navigateTo = "null";
    	User u=iMessageService.authenticate(email, password);

    	if (u != null) {
    		navigateTo = "welcome.xhtml?faces-redirect=true";
    		loggedIn = true; }
    	
    		else {
    		FacesMessage facesMessage =

    		new FacesMessage("Login Failed: please check your username/password and try again.");

    		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
    		}
    		return navigateTo;
    		}
    public String sendMessage() {
    	String navigateTo = "null";
    	

    	
    		navigateTo = "/pages/admin/Message.xhtml?faces-redirect=true";
    		loggedIn = true; 
    	
    		return navigateTo;
    		}
	public IMessageService getiMessageService() {
		return iMessageService;
	}
	public void setiMessageService(IMessageService iMessageService) {
		this.iMessageService = iMessageService;
	}
	public UserRepository getUserRepository() {
		return userRepository;
	}
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public Long getIdU() {
		return idU;
	}
	public void setIdU(Long idU) {
		this.idU = idU;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	

	
	public String getObjectM() {
		return objectM;
	}
	public void setObjectM(String objectM) {
		this.objectM = objectM;
	}

	
	public String getContentM() {
		return contentM;
	}
	public void setContentM(String contentM) {
		this.contentM = contentM;
	}
	public List<User> getAfficher() {
		return afficher;
	}

	/*public List<User> getAfficher() {
	try{afficher=iMessageService.getAllUsers();}
	catch (Exception e) {
	      System.out.println("Something went wrong.");
	    }
	return afficher;
} */
	public void setAfficher(List<User> afficher) {
		this.afficher = afficher;
	}
	
	public MessageRepository getMessageRepository() {
		return messageRepository;
	}
	public void setMessageRepository(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateSend() {
		return dateSend;
	}
	public void setDateSend(Date dateSend) {
		this.dateSend = dateSend;
	}
	public List<Admin> getAdmins() {
		return (List<Admin>) iMessageService.getAllAdmins();
	}
	public void setAdmins(List<Admin> admins) {
	}

	/*public List<Message> getMessages(Message message) {
long i=2;
		 return iMessageService.getAllMessageByUsers(message);
       

	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}*/
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
		
	
	public List<String> getList() {
		return iMessageService.getAllMessageContentMByIdU(idU);
	}
	public void setList(List<String> list) {
	}
	public List<Message> getMessages() {
  messages=iMessageService.getAllMessages();
  return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void setMsgs(List<String> msgs) {
		this.msgs = msgs;
	}

	
	// add msg to admin : http://localhost:8081/SpringMVC/servlet/addMessageA/2
		  @PostMapping(value="/addMessageA/{idU}/{msgId}")
		  @ResponseBody
		  public void addMessageA(@PathVariable("idU") long idU ,@RequestPart Message message,@PathVariable("msgId") long msgId,@RequestParam(value = "file")  MultipartFile file ) throws IllegalStateException, IOException , MessagingException{
			  //message.setPicture("defaultPic.png");
			  
			  
				  
				  iMessageService.addMessageA (idU,  message,msgId,file);
		        }
			// add  msg to parent: http://localhost:8081/SpringMVC/servlet/addMessageP/2
		  @PostMapping("/addMessageP/{idU}")
		  @ResponseBody
		  public void addMessageP(@PathVariable("idU") long idU ,@RequestBody Message message) {
			  iMessageService.addMessageP (idU,  message);
		  
		  }
			// add  msg to parent: http://localhost:8081/SpringMVC/servlet/addMessageP/2
		  @PostMapping("/addMessageDoc/{idU}")
		  @ResponseBody 
		  public void addMessageDoc(@PathVariable("idU") long idU ,@RequestBody Message message) {
			  iMessageService.addMessageDoc (idU,  message);
		  
		  }
			// add msg to doctor : http://localhost:8081/SpringMVC/servlet/addMessageDic/2
		  @PostMapping("/addMessageDir/{idU}")
		  @ResponseBody
		  public void addMessageDir(@PathVariable("idU") long idU ,@RequestBody Message message) {
			  iMessageService.addMessageDir (idU,  message);
		  
		  }
			// Send invitation to parent: http://localhost:8081/SpringMVC/servlet/SendInvitation
		  @PostMapping("/SendInvitation/{idU}/{proprietaire}")
		  @ResponseBody
		  public void SendInvitation(@PathVariable("idU") long idU,@RequestBody Invitation invitation,@PathVariable("proprietaire") long proprietaire) {
			  iMessageService.SendInvitation (idU,  invitation,proprietaire);
		  
		  }
			// Accept invitation to parent: http://localhost:8081/SpringMVC/servlet/Accept
		  @PutMapping("/Accept/{idU}/{proprietaire}")
		  @ResponseBody
		  public void Accept(@PathVariable("idU") long idU,@RequestBody Invitation invitation,@PathVariable("proprietaire") long proprietaire) {
			  iMessageService.Accept ( idU,  invitation,proprietaire);
		  
		  }
			// Accept invitation to parent: http://localhost:8081/SpringMVC/servlet/Refuse
		  @PutMapping("/Refuse/{idU}/{proprietaire}")
		  @ResponseBody
		  public void Refuse(@PathVariable("idU") long idU,@RequestBody Invitation invitation,@PathVariable("proprietaire") long proprietaire) {
			  iMessageService.Refuse ( idU,  invitation,proprietaire);
		  
		  }
	
	
	/*public void listerMessages (int idUser, int idMessage)
	{
		
		iMessageService.listerMessages(idUser,  idMessage);
	}*/
 
    /*
	// http://localhost:8081/SpringMVC/servlet/getAllUsers
	@GetMapping("/getAllAdmins")
	 @ResponseBody
		 public List<String> getAllUsers() {
			 List<String> list = iMessageService.getAllAdmins();
			 return list;
	 }*/
    


	//Admin message http://localhost:8081/SpringMVC/servlet/listerMessages/{long matricule}
	 @GetMapping("/listerMessages/{idU}/{proprietaire}")
	  @ResponseBody
	  public  List<String> listerMessages(@PathVariable("idU") long idU ,@PathVariable("proprietaire") long proprietaire ) {
	  return iMessageService.listerMessages(idU,proprietaire);
	  }
	
		//Parent message http://localhost:8081/SpringMVC/servlet/listerMessagesP/{long matricule}
	 @GetMapping("/listerMessagesP/{idU}")
	  @ResponseBody
	  public  List<String> listerMessagesP(@PathVariable("idU") long idU) {
	  return iMessageService.listerMessagesP(idU);
	  }
		//Doctor message http://localhost:8081/SpringMVC/servlet/listerMessagesDoc/{long matricule}
	 @GetMapping("/listerMessagesDoc/{idU}")
	  @ResponseBody
	  public  List<String> listerMessagesDoc(@PathVariable("idU") long idU) {
	  return iMessageService.listerMessagesDoc(idU);
	  }
	
		//Director message http://localhost:8081/SpringMVC/servlet/listerMessagesDir/{long matricule}
	 @GetMapping("/listerMessagesDic/{idU}")
	  @ResponseBody
	  public  List<String> listerMessagesDir(@PathVariable("idU") long idU) {
	  return iMessageService.listerMessagesDir(idU);
	  }

	 
		//list inv http://localhost:8081/SpringMVC/servlet/getAllInvitation
	 @GetMapping("/getAllInvitation")
	  @ResponseBody
	  public  List<Invitation> getAllInvitation() {
	  return iMessageService.getAllInvitation();
	  }
	 
	 
	 // list Parent http://localhost:8081/SpringMVC/servlet/getAllParents
	 @GetMapping("/getAllParents")
	  @ResponseBody
	  public  List<Parent> getAllParents() {
	  return iMessageService.getAllParents();
	  }
	 
	 // list Admin http://localhost:8081/SpringMVC/servlet/getAllAdmins
	 @GetMapping("/getAllAdmins")
	  @ResponseBody
	  public  List<Admin> getAllAdmins() {
	  return iMessageService.getAllAdmins();
	  }
	 // list Director http://localhost:8081/SpringMVC/servlet/getAllDirectors
	 @GetMapping("/getAllDirectors")
	  @ResponseBody
	  public  List<Director> getAllDirectors() {
	  return iMessageService.getAllDirectors();
	  }
	 // list Doctor http://localhost:8081/SpringMVC/servlet/getAllDoctors
	 @GetMapping("/getAllDoctors")
	  @ResponseBody
	  public  List<Doctor> getAllDoctors() {
	  return iMessageService.getAllDoctors();
	  }
	 // list Doctor http://localhost:8081/SpringMVC/servlet/listerInvitationAccept
	 @GetMapping("/listerInvitation/{idU}")
	  @ResponseBody
	  public  List<String>  listerInvitation(@PathVariable("idU") long idU) {
	  return iMessageService.listerInvitation(idU);
	  }
	 // list Doctor http://localhost:8081/SpringMVC/servlet/getListAmis
	 @GetMapping("/getListAmis/{idU}")
	  @ResponseBody
	  public  List<String>  getListAmis(@PathVariable("idU") long idU  ) {
	  return iMessageService.getListAmis(idU);
	  }
	 
		// http://localhost:8081/SpringMVC/servlet/deleteInvitationById/{matricule}
	   @DeleteMapping("/deleteInvitationById/{id}")
	   @ResponseBody
	   public void deleteInvitationById(@PathVariable("id") Long id) {
		   iMessageService.deleteInvitationById(id);
	   }
	// http://localhost:8081/SpringMVC/servlet/deleteAmis/{matricule}
	   @DeleteMapping("/deleteAmis/{id}")
	   @ResponseBody
	   public void deleteAmis(@PathVariable("id") Long id) {
		   iMessageService.deleteAmis(id);
	   }
	   
		// http://localhost:8081/SpringMVC/servlet/deleteMessageById/{matricule}
	   @DeleteMapping("/deleteMessageById/{id}")
	   @ResponseBody
	   public void deleteMessageById(@PathVariable("id") Long id) {
		   iMessageService.deleteMessageById(id);
	   }
	   
	   
		//Admin message http://localhost:8081/SpringMVC/servlet/listerNotifications/{long matricule}
		 @GetMapping("/listerNotifications/{idU}")
		  @ResponseBody
		  public  List<String> listerNotifications(@PathVariable("idU") long idU) {
		  return iMessageService.listerNotifications(idU);
		  }
			// http://localhost:8081/SpringMVC/servlet/deleteNotificationById/{matricule}
		   @DeleteMapping("/deleteNotificationById/{id}")
		   @ResponseBody
		   public void deleteNotificationById(@PathVariable("id") Long id) {
			   iMessageService.deleteNotificationById(id);
		   }
	 
			@PostMapping(value="/sendEmail",consumes = "application/json", produces = "application/json")
			public String sendEmail(@RequestBody EmailTemplate notification) {
				try {
					//log.info("Sending Simple Text Email....");
					iMessageService.sendTextEmail(notification);
					return "Email Sent!";
					}
				
			 catch (Exception ex) {
				return "Error in sending email: " + ex;
			}
		
			}
	 

		/*	@PostMapping(value="/attachemail",consumes = "multipart/form-data")
			public String sendEmailWithAttachment(@RequestPart(value = "file") MultipartFile file) {
				try {
					
					iMessageService.sendEmailWithAttachment(file);
					return "Email Sent!";
				} catch (Exception ex) {
					return "Error in sending email: " + ex;
				}
			}*/
			/*// add  msg to parent: http://localhost:8081/SpringMVC/servlet/addMessageP/2
			  @PostMapping("/uploadFile")
			  @ResponseBody 
			  public void uploadFile(@RequestParam(value = "files") MultipartFile file,@RequestParam("user") long id ) throws IllegalStateException, IOException , MessagingException{
				  iMessageService.uploadFile (file,id);
			  
			  }	*/

			@GetMapping("/allExcel")
		    public void exportToExcel(HttpServletResponse response) throws IOException {
		        response.setContentType("application/octet-stream");
		        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		        String currentDateTime = dateFormatter.format(new Date());
		         
		        String headerKey = "Content-Disposition";
		        String headerValue = "attachment; filename=transactions.xlsx";
		        response.setHeader(headerKey, headerValue);
		         
		        List<Message> listTrans = iMessageService.listAll();
		         
		        TransactionExcelExporter excelExporter = new TransactionExcelExporter(listTrans);
		         
		        excelExporter.export(response);    
		    }  
		 
			@PostMapping("/exportEXCEL")
			@ResponseBody
			public Boolean exportExcel () {
				
				return true;
			}
}
