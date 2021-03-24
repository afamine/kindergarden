package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Order;
import tn.esprit.spring.repository.IOrderRep;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRep rep;

	@Override
	public void add(Order o) {

		rep.save(o);

	}

	@Override
	public void delete(Long id) {

		Order o = rep.findById(id).orElse(null);

		if (o != null) {

			rep.delete(o);
		}

	}

	@Override
	public void update(Order o) {

		rep.save(o);

	}

	@Override
	public List<Order> getAll() {
		return (List<Order>)rep.findAll();
	}

}
