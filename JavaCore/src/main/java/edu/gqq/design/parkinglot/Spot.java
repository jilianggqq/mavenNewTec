package edu.gqq.design.parkinglot;

public class Spot {
	private int _id;
	private Size _size;
	private boolean isUsed;
	public Spot(int id, Size size) {
		_id = id;
		_size = size;
		isUsed = false;
	}
	
	public void setUsed() {
		isUsed = true;
	}
	
	public void setIdle() {
		isUsed = false;
	}
	
	public boolean isUsed() {
		return isUsed;
	}

	public int get_id() {
		return _id;
	}

	public Size get_size() {
		return _size;
	}
	
	@Override
	public String toString() {
		return String.format("{id : %d, size : %s}", _id, _size.toString());
	}
}
