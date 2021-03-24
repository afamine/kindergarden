package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Claim;
import tn.esprit.spring.entities.Order;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.StateClaim;
import tn.esprit.spring.entities.TypeClaim;
import tn.esprit.spring.service.IClaimService;
import tn.esprit.spring.service.IOrderService;
import tn.esprit.spring.service.IProductService;

@RestController()
@RequestMapping("/director")
public class DirectorRestController {

	@Autowired
	IOrderService orderS;

	@Autowired
	IClaimService claimS;

	@Autowired
	IProductService proS;

	@PostMapping("/addOrder")
	@ResponseBody
	public void creerOrder(@RequestBody Order o) {

		orderS.add(o);

	}

	@GetMapping("/getAllOrder")
	@ResponseBody
	public List<Order> getAll() {

		return orderS.getAll();
	}

	@PostMapping("/addProduct")
	@ResponseBody
	public void creerProduct(@RequestBody Product p) {

		proS.addProduct(p);

	}
	@PutMapping("/updateProduct")
	@ResponseBody
	public void updateProduct(@RequestBody Product p ) {

		proS.updateProduct(p);

	}

	/**
	 * 
	 * 
	 * crud claim
	 * 
	 */

	@PostMapping("/addClaim")
	@ResponseBody
	public void addClaim(@RequestBody Claim c) {

		claimS.add(c);

	}

	@GetMapping("/getAllClaim")
	@ResponseBody
	public List<Claim> getAllClaim() {

		return claimS.getAll();
	}

	@DeleteMapping("/deleteClaim/{id}")
	@ResponseBody
	public void deleteClaim(@PathVariable("id") Long id) {

		claimS.delete(id);
	}

	@PutMapping("/updateClaim")
	@ResponseBody
	public void updateClaim(@RequestBody Claim c) {

		claimS.update(c);

	}

	@GetMapping("/getAllClaimByType/{type}")
	@ResponseBody
	public List<Claim> getAllClaimByType(@PathVariable("type") TypeClaim type) {

		return claimS.getByType(type);
	}

	@GetMapping("/getAllClaimByTypeAndState/{type}/{state}")
	@ResponseBody
	public List<Claim> getAllClaimByTypeAndState(@PathVariable("type") TypeClaim type,
			@PathVariable("state") StateClaim s) {

		return claimS.getByTypeState(type, s);
	}

}
