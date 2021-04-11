package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Integer prodId;

    @Column(name = "prod_title")
    private String prodTitle;

    @Column(name = "prod_description")
    private String prodDescription;

    @Column(name = "prod_price")
    private Float prodPrice;

    @Column(name = "prod_qty")
    private Integer prodQty;

    @Column(name = "seller_id")
    private Integer sellerId;

    @Column(name = "photo")
    private String photo;

    @JoinColumn(name = "cat_id", nullable = false)
    @ManyToOne(optional = false)
    private Category category;

    @JoinColumn(name = "comp_id", nullable = false)
    @ManyToOne(optional = false)
    private Company company;














    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getProdId() {
        return this.prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdTitle() {
        return this.prodTitle;
    }

    public void setProdTitle(String prodTitle) {
        this.prodTitle = prodTitle;
    }

    public String getProdDescription() {
        return this.prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public Float getProdPrice() {
        return this.prodPrice;
    }

    public void setProdPrice(Float prodPrice) {
        this.prodPrice = prodPrice;
    }

    public Integer getProdQty() {
        return this.prodQty;
    }

    public void setProdQty(Integer prodQty) {
        this.prodQty = prodQty;
    }

    public Integer getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
