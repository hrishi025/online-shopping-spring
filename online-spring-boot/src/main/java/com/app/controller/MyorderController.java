package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ResponseDTO;
import com.app.service.IMyorderService;

@RestController
@CrossOrigin
@RequestMapping("/myorder")
public class MyorderController {
	public MyorderController() {
		System.out.println("in " + getClass().getName());
	}
	
	@Autowired
	IMyorderService myorderService;
	
	@GetMapping("/")
	public ResponseDTO<?> myorderFetch() {
		System.out.println("in user signup controller: ");
		return new ResponseDTO<>(HttpStatus.OK, "my orders fetched", myorderService.getAllMyordersOfCurrentUser());
	}
}
