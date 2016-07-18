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

import com.dao.OrderDao;
import com.pojo.OrderPojo;

@RestController
public class OrderService {
	
	@Autowired
	OrderDao orderDao;

	@RequestMapping(value="api/hello", produces="application/json", method=RequestMethod.GET)
	public ResponseEntity<String> helloFromService(String name){
		return new ResponseEntity<String>("Hello : " + name, HttpStatus.OK);
	}
	
	@RequestMapping(value="api/user", consumes="application/json", produces="application/json", method=RequestMethod.PUT)
	@ResponseStatus(code=HttpStatus.OK)
	public void saveUser(@RequestBody(required=true) OrderPojo order){
		orderDao.saveOrder(order);
	}	
	
	@RequestMapping(value="api/user", produces="application/json", method=RequestMethod.GET)
	public ResponseEntity<List<OrderPojo>> getUser(){
		return new ResponseEntity<List<OrderPojo>>(orderDao.getOrders(), HttpStatus.OK);
	}
}
