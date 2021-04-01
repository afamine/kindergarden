package tn.esprit.spring.MessageRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Invitation;
import tn.esprit.spring.entities.Parent;
import tn.esprit.spring.entities.User;


public interface InvitationRepository extends CrudRepository <Invitation, Long>  {

	List<String> getAllInvitationBySend(long sendId);

	List<Invitation> getInvitationsBySend( long sendId);

}
