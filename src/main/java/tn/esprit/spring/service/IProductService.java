package tn.esprit.spring.service;

import tn.esprit.spring.entities.Product;

public interface IProductService {
	
	public void addProduct(Product p);
	public void updateProduct(Product p);
	public void deleteProduct(Long id );

	

}
