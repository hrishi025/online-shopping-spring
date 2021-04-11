package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Entity
@Table(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    @JsonProperty("name")
    private String userName;

    @Column(name = "user_phone")
    @JsonProperty("phone")
    private String userPhone;

    @Column(name = "user_email", unique=true)
    @JsonProperty("email")
    private String userEmail;

    @Column(name = "user_password")
    @JsonProperty("password")
    private String userPassword;

    @Column(name = "user_status", columnDefinition ="int default 0")
    @JsonProperty("status")
    private Integer userStatus;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_role", columnDefinition = "varchar(30) default 'CUSTOMER'")
    @JsonProperty("role")
    private Role userRole;

    // FOR P.K in another side
    @JsonIgnore		// to ignore this property during signin causing lazy init
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    @JsonIgnore		// to ignore this property during signin causing lazy init
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts;

    @JsonIgnore		// to ignore this property during signin causing lazy init
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments;
    	
    @JsonIgnore		// to ignore this property during signin causing lazy init
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Myorder> myorders;














    public List<Myorder> getMyorders() {
        return myorders;
    }

    public void setMyorders(List<Myorder> myorders) {
        this.myorders = myorders;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Cart> getCarts() {
        return carts;
    }
    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
    public List<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    public Integer getUserId() {
        return this.userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPhone() {
        return this.userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getUserEmail() {
        return this.userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserPassword() {
        return this.userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public Integer getUserStatus() {
        return this.userStatus;
    }
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }
    public Role getUserRole() {
        return this.userRole;
    }
    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }
    
}
