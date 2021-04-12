package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EditProfileDTO;
import com.app.dto.ResponseDTO;
import com.app.dto.SigninDTO;
import com.app.pojos.Users;
import com.app.service.IUsersService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UsersController {

	public UsersController() {
		System.out.println("in " + getClass().getName());
	}

	@Autowired
	IUsersService usersService;

	@PostMapping("/signin")
	public ResponseDTO<?> userSignin(@RequestBody SigninDTO u) {
		System.out.println("in user signin controller: " + u);
		return new ResponseDTO<>(HttpStatus.OK, "sign in success", usersService.userSignin(u));
	}

	@PostMapping("/signup")
	public ResponseDTO<?> userSignup(@RequestBody Users u) {
		System.out.println("in user signup controller: " + u);
		return new ResponseDTO<>(HttpStatus.OK, "signup success", usersService.userSignup(u));
	}

	@GetMapping("/profile/{id}")
	public ResponseDTO<?> getProfile(@PathVariable int id) {
		System.out.println("in user get profile controller: " + id);
		return new ResponseDTO<>(HttpStatus.OK, "profile fetch success", usersService.getProfile(id));
	}

	@PostMapping("/update/{id}")
	public ResponseDTO<?> userUpdate(@PathVariable int id,@RequestBody EditProfileDTO u) {
		System.out.println("in user update controller: " + u + " " + id);
		return new ResponseDTO<>(HttpStatus.OK, "profile update success", usersService.userUpdate(id,u));
	}

	@PatchMapping("/seller/apply/{id}")
	public ResponseDTO<?> applyForSeller(@PathVariable int id) {
		System.out.println("in apply seller user controller: " + id);
		return new ResponseDTO<>(HttpStatus.OK, "seller apply success", usersService.applySeller(id));
	}

}
