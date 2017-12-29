package com.mavenSSM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavenSSM.dao.TestDao;
import com.mavenSSM.model.User;

@Service
public class TestService {
	@Autowired
	private TestDao td;
	
	public User getUser(){
		return td.getUser();
	}
}
