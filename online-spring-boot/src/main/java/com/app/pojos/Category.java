package com.app.pojos;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cat_id")
	private Integer catId;

	@Column(name = "cat_title")
	private String catTitle;

	@Column(name = "cat_description")
	private String catDescription;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Products> products;

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public Integer getCatId() {
		return this.catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatTitle() {
		return this.catTitle;
	}

	public void setCatTitle(String catTitle) {
		this.catTitle = catTitle;
	}

	public String getCatDescription() {
		return this.catDescription;
	}

	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}
}
