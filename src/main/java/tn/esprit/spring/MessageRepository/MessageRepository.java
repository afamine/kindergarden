package tn.esprit.spring.MessageRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Message;
import tn.esprit.spring.entities.User;

@Repository
public interface MessageRepository extends JpaRepository <Message, Long> {

	public List<Message> getAllMessageByUsers(@Param("message")Message message);

	

}
