package com.plus.auebplus.secretary;



public class SecretaryObject implements Comparable<SecretaryObject> {

	String title;
	int layout;
	
	public SecretaryObject(String string, int secretarygoe) {
		// TODO Auto-generated constructor stub
		
		this.setTitle(string);
		this.setLayout(secretarygoe);
	}
	public void setTitle(String s){
		this.title=s;
	}
	public void setLayout(int i){
		this.layout=i;
	}
	public int getLayout(){
		return this.layout;
	}
	public String getTitle(){
		return this.title;
	}
	@Override
	public int compareTo(SecretaryObject another) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
