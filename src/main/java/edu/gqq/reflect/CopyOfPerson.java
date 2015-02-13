package edu.gqq.reflect;

import java.util.function.Consumer;

public class CopyOfPerson implements Consumer<CopyOfPerson> {

	public interface IAcion {
		void doAction();
	}

	public CopyOfPerson() {
	}

	public CopyOfPerson(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}


	private int id;
	public long count;
	private String name;
	public String email;

	// private Address address;

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

	@Override
	public void accept(CopyOfPerson t) {
		System.out.format("{id:%d,name:%s}", id, name);
	}

	@Override
	public String toString() {
		return String.format("{id:%d, name:%s, email:%s}", id, name, email);
	}

	// public Address getAddress() {
	// return address;
	// }
	//
	// public void setAddress() {
	// Address a = new Address();
	// a.addr = "dixon";
	// this.address = a;
	// }
}
