package tn.esprit.spring.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Appointment;


@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
/*
	@Query(value = "INSERT INTO Appointment (jour,id_creneau,id_enfant) VALUES (:j, :c, :e)", nativeQuery = true) 
	@Transactional
	public Appointment ajouterRv(@Param("j") Date jour, @Param("c") long créneau, @Param("e") long enfant); 
	@Query("select rv from Rv rv where rv.creneau.teacher.id=?1 and rv.jour=?2")
	Iterable <Appointment> getRvTeacherJour(long idTeacher, Date jour);
	@Query("Select r from Appointment r where r.id=:id")
	public Appointment getRvById(@Param("id") long id);
*/
	
	//public List<Appointment> getAllAppointmentByUsers(@Param("appointment")Appointment appointment);

}
