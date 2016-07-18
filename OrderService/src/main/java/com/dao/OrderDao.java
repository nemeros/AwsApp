package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pojo.OrderPojo;

@Repository
public class OrderDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(@Qualifier("nemerospg") DataSource ds){
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	/**
	 * 
	 * @param usr
	 */
	public void saveOrder(OrderPojo order){
		StringBuilder query = new StringBuilder(150);
		query.append("INSERT INTO T_ORDER (USR_ID, COMMENT, VALEUR) VALUES (?, ?, ?)");
		
		this.jdbcTemplate.update(query.toString(), new Object[] {order.getUserId(), order.getComment(), order.getValeur()});
	}
	
	/**
	 * 
	 * @return
	 */
	public List<OrderPojo> getOrders(){
		StringBuilder query = new StringBuilder(150);
		query.append("SELECT ID, USR_ID, COMMENT, VALEUR FROM T_ORDER");
		
		return this.jdbcTemplate.query(query.toString(), (rs, cnt) -> 
			{return new OrderPojo(
					rs.getInt("ID"),
					rs.getInt("USR_ID"),
					rs.getString("COMMENT"),
					rs.getString("VALEUR"));});
	}
}
