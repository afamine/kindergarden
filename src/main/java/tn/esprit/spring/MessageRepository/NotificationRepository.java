package tn.esprit.spring.MessageRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Notification;
import tn.esprit.spring.entities.Parent;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {

}
