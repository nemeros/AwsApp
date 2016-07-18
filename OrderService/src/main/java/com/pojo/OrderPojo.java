package com.pojo;

public class OrderPojo {
	private int id;
	private int userId;
	private String comment;
	private String valeur;
	
	
	public OrderPojo(){
		
	}
	
	public OrderPojo(int id, int userId, String comment, String valeur) {
		super();
		this.id = id;
		this.userId = userId;
		this.comment = comment;
		this.valeur = valeur;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}	
}
