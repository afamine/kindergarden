package tn.esprit.spring.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Garden;
import tn.esprit.spring.services.IGardenService;


@Scope(value = "session")
@Controller (value = "gardenController")
@ELBeanName(value = "gardenController")
@Join(path = "/", to = "/login.jsf")

public class GardenController {
	
	@Autowired 
	IGardenService gardenService;
	
	



	 //http://localhost:8081/SpringMVC/servlet/retrieve-all-garden 
	@GetMapping("/retrieve-all-garden") 
	@ResponseBody 
	 public List<Garden> getGaden() { 
		 List<Garden> list = gardenService.retrieveAllGarden(); 
		 return list; 
	} 

}
