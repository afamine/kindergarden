package tn.esprit.spring.MessageRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Director;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Long>{

}
