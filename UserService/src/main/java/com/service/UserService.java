package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDao;
import com.pojo.UserPojo;

@RestController
public class UserService {
	
	@Autowired
	UserDao userDao;

	@RequestMapping(value="api/user", consumes="application/json", produces="application/json", method=RequestMethod.PUT)
	@ResponseStatus(code=HttpStatus.OK)
	public void saveUser(@RequestBody(required=true) UserPojo usr){
		userDao.saveUser(usr);
	}	
	
	@RequestMapping(value="api/user", produces="application/json", method=RequestMethod.GET)
	public ResponseEntity<List<UserPojo>> getUser(){
		return new ResponseEntity<List<UserPojo>>(userDao.getUsers(), HttpStatus.OK);
	}
}
