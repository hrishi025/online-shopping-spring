package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ProductsRepository;
import com.app.pojos.Products;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	public ProductServiceImpl() {
		System.out.println("in product service impl const");
	}

	@Autowired
	ProductsRepository repo;

	@Override
	public List<Products> productListAll() {
		return repo.findAll();
	}

//	@Override
//	public List<Products> productListSeller(int user_id) {
//		return repo.productListSeller(user_id);
//	}

	@Override
	public Products addProduct(Products product) {
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

//	@Override
//	public Products updateProductQuantity(int prod_id, float prod_qty) {
//		return repo.updateProductQuantity(prod_id,prod_qty);
//	}
//
//	@Override
//	public Products updateProductPrice(int prod_id, float prod_price) {
//		return repo.updateProductQuantity(prod_id,prod_price);
//	}

}
