package com.pojo;

public class UserPojo {

	private int id;
	private String valeur;
	
	public UserPojo(){
		
	}
	
	public UserPojo(int id, String valeur) {
		this.id = id;
		this.valeur = valeur;
	}	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
}
