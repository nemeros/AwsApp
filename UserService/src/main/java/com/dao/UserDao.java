package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pojo.UserPojo;

@Repository
public class UserDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(@Qualifier("nemerospg") DataSource ds){
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	/**
	 * 
	 * @param usr
	 */
	public void saveUser(UserPojo usr){
		StringBuilder query = new StringBuilder(150);
		query.append("INSERT INTO T_USER (VALEUR) VALUES (?)");
		
		this.jdbcTemplate.update(query.toString(), usr.getValeur());
	}
	
	/**
	 * 
	 * @return
	 */
	public List<UserPojo> getUsers(){
		StringBuilder query = new StringBuilder(150);
		query.append("SELECT ID, VALEUR FROM T_USER");
		
		return this.jdbcTemplate.query(query.toString(), (rs, cnt) -> 
			{return new UserPojo(
					rs.getInt("ID"),
					rs.getString("VALEUR"));});
	}
}
