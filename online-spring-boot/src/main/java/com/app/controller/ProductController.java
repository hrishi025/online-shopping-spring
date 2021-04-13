package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ResponseDTO;
import com.app.pojos.Category;
import com.app.pojos.Company;
import com.app.pojos.Products;
import com.app.pojos.Users;
import com.app.service.IProductService;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

	@Autowired
	IProductService productService;

	@Autowired
	BucketController bucketController;

	public ProductController() {
		System.out.println("in " + getClass().getName());
	}

	@GetMapping("/list")
	public ResponseDTO<?> getProductListAll() {
		System.out.println("in get all products list product controller");
		return new ResponseDTO<>(HttpStatus.OK, "products found", productService.productListAll());
	}

	@GetMapping("/seller/{user_id}")
	public ResponseDTO<?> getProductListSeller(@PathVariable int user_id) {
		System.out.println("in get seller products list product controller: " + user_id);
		return new ResponseDTO<>(HttpStatus.OK, "products found", productService.productListSeller(user_id));
	}

	@PostMapping("/add")
	public ResponseDTO<?> addProduct(@RequestPart String prod_title, @RequestPart String prod_description,
			@RequestPart String prod_price, @RequestPart String prod_qty, @RequestPart String cat_id,
			@RequestPart String comp_id, @RequestPart(value = "file") MultipartFile file) {
		
		String imagePath = bucketController.uploadFile(file);

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		System.out.println(username);
		System.out.println("in get product add product controller: " + prod_description + " " + prod_price + " "
				+ prod_qty + " " + prod_title + " " + cat_id + " " + comp_id + " " + imagePath);

		Products p = new Products();
		p.setCategory(new Category());
		p.getCategory().setCatId(Integer.valueOf(cat_id));
		p.setCompany(new Company());
		p.getCompany().setCompId(Integer.valueOf(comp_id));
		p.setPhoto(imagePath);
		p.setProdPrice(Float.valueOf(prod_price));
		p.setProdQty(Integer.valueOf(prod_qty));
		p.setProdTitle(prod_title);
		p.setProdDescription(prod_description);
		p.setUser(new Users());
		p.getUser().setUserName(username);
		
		return new ResponseDTO<>(HttpStatus.OK, "product added", productService.addProduct(p));
	}

	@GetMapping("/{prod_id}")
	public ResponseDTO<?> getProductDetails(@PathVariable int prod_id) {
		System.out.println("in get product details product controller: " + prod_id);
		return new ResponseDTO<>(HttpStatus.OK, "product found", productService.getProductDetails(prod_id));
	}

	@DeleteMapping("/delete/{prod_id}")
	public ResponseDTO<?> deleteProduct(@PathVariable int prod_id) {
		System.out.println("in get product delete product controller: " + prod_id);
		return new ResponseDTO<>(HttpStatus.OK, "product deleted", productService.deleteProduct(prod_id));
	}

	@PostMapping("/update/{prod_id}")
	public ResponseDTO<?> updateProductQuantity(@PathVariable int prod_id, @RequestBody Products product) {
		System.out.println("in get product qty update product controller: " + product.getProdTitle()
				+ product.getProdQty() + product.getProdTitle() + product.getProdPrice());
		return new ResponseDTO<>(HttpStatus.OK, "product updated", productService.updateProductQuantity(prod_id,
				product.getProdQty(), product.getProdTitle(), product.getProdPrice()));
	}

}
