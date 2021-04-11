package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ResponseDTO;
import com.app.pojos.Products;
import com.app.service.IProductService;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	public ProductController() {
		System.out.println("in " + getClass().getName());
	}
	
	@GetMapping("/list")
	public ResponseDTO<?> getProductListAll(){
		System.out.println("in get all products list product controller");
		return new ResponseDTO<>(HttpStatus.OK, "products found", productService.productListAll());
	}
	
//	@GetMapping("/seller/{user_id}")
//	public ResponseDTO<?> getProductListSeller(@PathVariable int user_id){
//		System.out.println("in get seller products list product controller: " + user_id);
//		return new ResponseDTO<>(HttpStatus.OK, "products found", productService.productListSeller(user_id));
//	}
	
	@PostMapping("/add")
	public ResponseDTO<?> addProduct(@RequestBody Products product){
		System.out.println("in get product add product controller: " + product);
		return new ResponseDTO<>(HttpStatus.OK, "product added", productService.addProduct(product));
	}
	
	@GetMapping("/{prod_id}")
	public ResponseDTO<?> getProductDetails(@PathVariable int prod_id){
		System.out.println("in get product details product controller: " + prod_id);
		return new ResponseDTO<>(HttpStatus.OK, "product found", productService.getProductDetails(prod_id));
	}
	
	@DeleteMapping("/delete/{prod_id}")
	public ResponseDTO<?> deleteProduct(@PathVariable int prod_id){
		System.out.println("in get product delete product controller: " + prod_id);
		return new ResponseDTO<>(HttpStatus.OK, "product deleted", productService.deleteProduct(prod_id));
	}
	
//	//TODO:UPDATE QTY & PRICE NOT WORKING
//	@PatchMapping("/quantity/update/{prod_id}")
//	public ResponseDTO<?> updateProductQuantity(@PathVariable int prod_id, @RequestBody int prod_qty){
//		System.out.println("in get product qty update product controller: " + prod_id + prod_qty);
//		return new ResponseDTO<>(HttpStatus.OK, "product quantity updated", productService.updateProductQuantity(prod_id, prod_qty));
//	}
//	@PatchMapping("/price/update/{prod_id}")
//	public ResponseDTO<?> updateProductPrice(@PathVariable int prod_id, @RequestBody int prod_price ){
//		System.out.println("in get product price update product controller: " + prod_id + " "+ prod_price);
//		return new ResponseDTO<>(HttpStatus.OK, "product price updated", productService.updateProductPrice(prod_id, prod_price));
//	}

}
