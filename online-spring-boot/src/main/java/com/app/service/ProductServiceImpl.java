package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ProductsRepository;
import com.app.dao.UsersRepository;
import com.app.pojos.Products;
import com.app.pojos.Users;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	public ProductServiceImpl() {
		System.out.println("in product service impl const");
	}

	@Autowired
	ProductsRepository repo;

	//for getting seller products
	@Autowired
	UsersRepository userRepo;
	
	@Override
	public List<Products> productListAll() {
		return repo.findAll();
	}

	@Override
	public List<Products> productListSeller(int user_id) {
		Users u = userRepo.findById(user_id).get();
		return repo.findAllByUser(u);
	}

	@Override
	public Products addProduct(Products product) {
		System.out.println(product.getCategory().getCatId());
		System.out.println(product.getCompany().getCompId());
		return repo.save(product);
	}

	@Override
	public Products getProductDetails(int prod_id) {
		return repo.findById(prod_id).get();
	}

	@Override
	public String deleteProduct(int prod_id) {
		if (repo.existsById(prod_id)) {
			repo.deleteById(prod_id);
			return "deleted successfully";
		}
		return "no product found";
	}

	@Override
	public Products updateProductQuantity(int prod_id, int prod_qty, String prod_title, Float prod_price) {
		Products p = repo.findById(prod_id).get();
		p.setProdQty(prod_qty);
		p.setProdPrice(prod_price);
		p.setProdTitle(prod_title);
		return repo.save(p);
	}

}
