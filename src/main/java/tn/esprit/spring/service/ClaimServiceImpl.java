package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Claim;
import tn.esprit.spring.entities.StateClaim;
import tn.esprit.spring.entities.TypeClaim;
import tn.esprit.spring.repository.IClaimRep;

@Service
public class ClaimServiceImpl implements IClaimService {

	@Autowired
	IClaimRep claimRep;

	@Override
	public void add(Claim c) {
		
		c.setDateC(new Date());
		c.setStateC(StateClaim.untreated);
		claimRep.save(c);

	}

	@Override
	public void delete(Long id) {

		claimRep.deleteById(id);

	}

	@Override
	public void update(Claim c) {
		claimRep.save(c);

	}

	@Override
	public List<Claim> getAll() {
		return (List<Claim>) claimRep.findAll();
	}

	@Override
	public List<Claim> getByType(TypeClaim type) {
		return claimRep.findByType(type);
	}

	@Override
	public List<Claim> getByTypeState(TypeClaim type ,StateClaim s) {
		return claimRep.findByTypeStateC(type, s);
	}

}
