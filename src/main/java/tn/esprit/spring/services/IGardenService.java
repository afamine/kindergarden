package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Garden;



public interface IGardenService {
	
	public List<Garden> retrieveAllGarden();
	 public List<Garden> getAllGarden();

}
