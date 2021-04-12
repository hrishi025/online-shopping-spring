package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "myorder")
public class Myorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "myorder_id")
    private Integer myorderId;

    @Column(name = "orderDate")
    private String orderDate;

    @Column(name = "status")
    private Integer status;

    @Column(name = "total_price")
    private Float totalPrice;

    // userId col
    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(optional = false)
    private Users user;

    // addId col
    @JoinColumn(name = "add_id", nullable = false)
    @ManyToOne(optional = false)
    private Address address;








    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Integer getMyorderId() {
        return this.myorderId;
    }

    public void setMyorderId(Integer myorderId) {
        this.myorderId = myorderId;
    }
    public String getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

	@Override
	public String toString() {
		return "Myorder [myorderId=" + myorderId + ", orderDate=" + orderDate + ", status=" + status + ", totalPrice="
				+ totalPrice + ", user=" + user + ", address=" + address + "]";
	}



}
