package com.app.service;

import com.app.pojos.Address;
import com.app.pojos.Cart;

import java.util.List;

public interface ICartService {

	Cart addToCart(Cart cart, String username);

	List<Cart> getCartItems(String username);

	String deleteCart(int cart_id);

	Cart updateCart(Cart cart);

	Cart cartCheckout(int user_id, Address address);

}
