package tn.esprit.spring.MessageRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.entities.User;
@Repository
public interface UseRepository extends JpaRepository<User, Long>{

}
