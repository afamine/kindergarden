package tn.esprit.spring.MessageRepository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.entities.Message;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.User;

@Repository
public interface UserRepository extends CrudRepository<Admin, Long> {

	User getUserByEmailAndPassword(String email, String password);

	void save(Parent parent);



	

}
