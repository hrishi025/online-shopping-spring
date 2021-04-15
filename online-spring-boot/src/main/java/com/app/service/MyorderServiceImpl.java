package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.MyorderRepository;
import com.app.pojos.Myorder;

@Service
@Transactional
public class MyorderServiceImpl implements IMyorderService {
	@Autowired
	MyorderRepository myorderRepo;

	@Autowired
	IUsersService usersService;

	@Override
	public List<Myorder> getAllMyordersOfCurrentUser() {
		List<Myorder> myorderList = myorderRepo.getMyOrderWithOrderDetais(usersService.getUser().getUserId());
		System.out.println(myorderList);
		return myorderList;
	}

	@Override
	public Myorder getMyorderByMyorderId(int myorder_id) {
		return myorderRepo.findById(myorder_id).get();
	}

}
