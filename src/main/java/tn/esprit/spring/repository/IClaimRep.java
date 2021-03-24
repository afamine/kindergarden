package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Claim;
import tn.esprit.spring.entities.StateClaim;
import tn.esprit.spring.entities.TypeClaim;

@Repository
public interface IClaimRep extends CrudRepository<Claim, Long> {
	
	public List<Claim>findByType(TypeClaim type);
	@Query("select c from Claim c where ( c.type like :t and c.stateC like :s ) ")
	public List<Claim>findByTypeStateC(@Param("t")TypeClaim type,@Param("s")StateClaim state);
	

}
