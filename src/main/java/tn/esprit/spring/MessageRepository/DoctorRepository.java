package tn.esprit.spring.MessageRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Doctor;


@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
