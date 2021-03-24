package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Claim;
import tn.esprit.spring.entities.StateClaim;
import tn.esprit.spring.entities.TypeClaim;


public interface IClaimService {
	public void add(Claim c);
	public void delete (Long id);
	public void update(Claim c);
	public List<Claim> getAll();
	public List<Claim> getByType(TypeClaim type);
	public List<Claim> getByTypeState(TypeClaim type,StateClaim s);
}
