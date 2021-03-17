package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.Child;



public interface IAppointmentService {
	
	
	public void ajouterAppointment(Appointment appointment);
	public List<Child>getAllAppointmentByIdC( long idR);
	public List<String>listerAppointmentDir(long idC);
	public void addAppointmentP(long idR ,Appointment appointment);
	

}
