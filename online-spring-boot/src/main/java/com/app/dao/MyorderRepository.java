package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Myorder;

public interface MyorderRepository extends JpaRepository<Myorder, Integer>{

}
