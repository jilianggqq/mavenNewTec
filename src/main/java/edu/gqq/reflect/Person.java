package edu.gqq.reflect;


public class Person {

	public interface IAcion{
		void doAction();
	}
	
	private IAcion ia;
	
	public void setIA(IAcion ia){
		this.ia = ia;
	}
	
	public void doAciont() {
		if(null!=ia)
			ia.doAction();
	}
	
	private int id;
	private String name;
	public String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
