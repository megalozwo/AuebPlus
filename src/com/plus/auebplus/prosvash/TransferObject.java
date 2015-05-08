package com.plus.auebplus.prosvash;

public class TransferObject {

	boolean bus;
	String name;
	String caption;
	
	public TransferObject(){
		
	}
	public void setName(String s){
		this.name=s;
	}
	
	public void setcap(String caption){
		this.caption=caption;
	}
	public void setbus(boolean bus){
		this.bus=bus;
	}
	public String getName(){
		return this.name;
	}
	public String getCaption(){
		return this.caption;
	}
	public boolean getBus(){
		return bus;
	}
	
}
