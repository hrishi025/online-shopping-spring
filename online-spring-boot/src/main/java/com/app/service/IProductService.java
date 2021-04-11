package com.app.service;

import java.util.List;

import com.app.pojos.Products;

public interface IProductService {

	List<Products> productListAll();

//	List<Products> productListSeller(int user_id);

	Products addProduct(Products product);

	Products getProductDetails(int prod_id);

	String deleteProduct(int prod_id);

//	Products updateProductQuantity(int prod_id, float prod_qty);
//
//	Products updateProductPrice(int prod_id, float prod_price);
	
}
