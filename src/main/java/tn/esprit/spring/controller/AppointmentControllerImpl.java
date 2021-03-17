package tn.esprit.spring.controller;


import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.Child;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AppointmentRepository;

import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.IAppointmentService;


@Scope(value = "session")
@Controller (value = "appointmentController")
@ELBeanName(value = "appointmentController")
@Join(path = "/", to = "/login.jsf")
public class AppointmentControllerImpl {
	
	@Autowired
	IAppointmentService iappointmentService;
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	/*@Autowired 
	ChildRepository childRepository;*/
	
	//id Garden
	
	private Child idC;
	
	
	

	
	

	public IAppointmentService getIappointmentService() {
		return iappointmentService;
	}

	public void setIappointmentService(IAppointmentService iappointmentService) {
		this.iappointmentService = iappointmentService;
	}

	public AppointmentRepository getAppointmentRepository() {
		return appointmentRepository;
	}

	public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}

	

	

	

	

	

	public Child getIdC() {
		return idC;
	}

	public void setIdC(Child idC) {
		this.idC = idC;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	private List<Appointment> appointment; 
	
	public IAppointmentService getiappointmentService() {
		return iappointmentService;
	}
	
	
	
	
	@PostMapping("/ajouterAppointment") //   
	@ResponseBody 
	public void ajouterAppointment (@RequestBody Appointment appointment) { //
		iappointmentService.ajouterAppointment(appointment);
		
		//		
		}
	
	
	 
	//Director appointment http://localhost:8081/SpringMVC/servlet/listerAppointmentDir/{long }
		 @GetMapping("/listerAppointmentDic/{idR}")
		  @ResponseBody
		  public  List<String> listerAppointmentDir(@PathVariable("idR") long idR) {
		  return iappointmentService.listerAppointmentDir(idR);
		  }
		 
		 
		 
		// add  appointment to parent: http://localhost:8081/SpringMVC/servlet/addAppointmentP/2
		  @PostMapping("/addAppointmentP/{idC}")
		  @ResponseBody
		  public void addAppointmentP(@PathVariable("idC") long idC ,@RequestBody Appointment appointment) {
			  iappointmentService.addAppointmentP (idC,  appointment);
		  
		  }
		  
	
	
	/*//Admin app http://localhost:8081/SpringMVC/servlet/listerAppointment/{long matricule}
		 @GetMapping("/listerAppointment/{idU}")
		  @ResponseBody
		  public  List<String> listerMessages(@PathVariable("idU") long idU) {
		  return iappointmentService.listerAppointment(idU);
		  }
		/*
			//Parent message http://localhost:8081/SpringMVC/servlet/listerAppointmentP/{long matricule}
		 @GetMapping("/listerAppointmentP/{idU}")
		  @ResponseBody
		  public  List<String> listerMessagesP(@PathVariable("idU") long idU) {
		  return iappointmentService.listerAppointmentP(idU);
		  }
			//Doctor message http://localhost:8081/SpringMVC/servlet/listerAppointmentDoc/{long matricule}
		 @GetMapping("/listerAppointmentDoc/{idU}")
		  @ResponseBody
		  public  List<String> listerMessagesDoc(@PathVariable("idU") long idU) {
		  return iappointmentService.listerAppointmentDoc(idU);
		  }
		
			//Director message http://localhost:8081/SpringMVC/servlet/listerAppointmentDir/{long matricule}
		 @GetMapping("/listerAppointmentDic/{idU}")
		  @ResponseBody
		  public  List<String> listerAppointmentDir(@PathVariable("idU") long idU) {
		  return iappointmentService.listerAppointmentDir(idU);
		  }
		
	
	/*public int ajouterAppointment(Appointment ssiiConsulting) {
		iappointmentService.ajouterAppointment(ssiiConsulting);
		return ssiiConsulting.getIdR();
		//getIdC().getParent().getId().getDirector();
				
	}*/
	
	/*public List<String> getAllAppointmentNamesByChild(int appointmentId) {
		return iappointmentService.getAllAppointmentNamesByDirector(appointmentId);
	}*/

	

	

	
	
	
	
	

}
