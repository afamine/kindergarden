package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Garden;
import tn.esprit.spring.repository.GardenRepository;

@Service
public class GardenServiceImpl implements IGardenService {
	
	@Autowired
	GardenRepository gardenRepository;
	
	


	@Override
	public List<Garden> retrieveAllGarden() {
		List<Garden> gardens =(List<Garden>) gardenRepository.findAll();
		for(Garden garden:gardens) {
			System.out.println(garden);
		}
		return gardens;
	}
	
	@Override
	public List<Garden> getAllGarden() {
		
		return (List<Garden>) gardenRepository.findAll();
	}
	
	
	

}
