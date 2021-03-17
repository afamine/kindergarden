package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.Child;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AppointmentRepository;
import tn.esprit.spring.repository.ChildRepository;
import tn.esprit.spring.repository.GardenRepository;
import tn.esprit.spring.repository.ParentRepository;




@Service
public class AppointmentServiceImpl implements IAppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	ChildRepository childRepository;
	
	
	
	@Autowired
	ParentRepository parentRepository;
	
	@Autowired
	GardenRepository gardenRepository;

	
	@Override
	public void ajouterAppointment(Appointment appointment) {	
		appointmentRepository.save(appointment).getObjetcR();
		
	}
	
	
	//add app pour parent
	@Override
	public void addAppointmentP(long idR, Appointment appoinment) {
		User users =  parentRepository.findById((idR)).orElse(null);
		
		appoinment.getChild();
		appointmentRepository.save(appoinment);
		
	}
	
	//lister rendez-vous pour directeur
	@Override
	public List<String> listerAppointmentDir(long idC) {
		Child dr = childRepository.findById((idC)).orElse(null);
		List<String> ss = new ArrayList<>();
		for(Appointment app : dr.getAppointments()){
			ss.add(app.getObjetcR());
			ss.add(app.getStateR());
		}

	return ss;
	}
	
	
	/*
	@Override
	public List<String> listerAppointmentDir(long id) {
		Child child = childRepository.findById((id)).orElse(null);
		List<String> ss = new ArrayList<>();
		for(Appointment app : child.getAppointments()){
			ss.add(app.getObjetcR());
			ss.add(app.getStateR());
			
		}

	return ss;
	}*/
	@Override
	public List<Child> getAllAppointmentByIdC(long idR) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	/*private static final Logger L = LogManager.getLogger(AppointmentServiceImpl.class);
	@Override
	public List<Appointment> retrieveAllAppointment() {
		List<Appointment> appointments=(List<Appointment>) appointmentRepository.findAll();
		for (Appointment appointment : appointments){
			L.info("appointment +++ :" + appointment);
		}
		return appointments;

}
	
	
	/*@Override
	public List<String> listerAppointment(long idU) {
		User users = userRepository.findById((idU)).orElse(null);
		List<String> ss = new ArrayList<>();
		for(Appointment app : users.getAppointment()){
			ss.add(app.getObjetcR());
			ss.add(app.getStateR());
				
		
		}

	return ss;
	}
	/*
	@Override
	public List<String> listerAppointmentP(long idU) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<String> listerAppointmentDoc(long idU) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<String> listerAppointmentDir(long idU) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Appointment> retrieveAllAppointment() {
		// TODO Auto-generated method stub
		return null;
	}

	/*public List<Appointment> getAllAppointment() {
		return (List<Appointment>) appointmentRepository.findAll();
	}*/


	
	
	/*public int ajouterAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
		return appointment.getIdR();
	}*/


	/*@Override
	public Appointment getAppointmentById(int appointmentId) {
		return appointmentRepository.findById(appointmentId).get();
	
	}*/


	
	


	/*@Override
	public List<String> getAllAppointmentNamesByDirector(int appointmentId) {
		Appointment appointmentManagedEntity = appointmentRepository.findById(appointmentId).get();
		List<String> depNames = new ArrayList<>();
		for(Director app : appointmentManagedEntity.getAppointment(){
			depNames.add(dep.getName());
		}
		
		return depNames;
		return null;
	}*/

	
}
