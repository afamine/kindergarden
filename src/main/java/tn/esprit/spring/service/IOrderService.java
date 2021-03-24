package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Order;



public interface IOrderService {
	
	public void add(Order o);
	public void delete (Long id);
	public void update(Order o);
	public List<Order> getAll();

}
