
package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Claim;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.repository.IProductRep;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	IProductRep rep;

	@Override
	public void addProduct(Product p) {
		rep.save(p);
		
		
		
		
		
	}
	
	@Override
	public void updateProduct(Product p) {
		rep.save(p);
		
	}

}
