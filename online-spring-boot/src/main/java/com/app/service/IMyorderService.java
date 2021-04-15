package com.app.service;

import java.util.List;

import com.app.pojos.Myorder;

public interface IMyorderService {

	List<Myorder> getAllMyordersOfCurrentUser();
	
	Myorder getMyorderByMyorderId(int myorder_id);

}
