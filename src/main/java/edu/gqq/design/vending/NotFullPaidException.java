package edu.gqq.design.vending;

public class NotFullPaidException extends RuntimeException {
	private long remaining;

	public NotFullPaidException(String msg, long remaining) {
		super(msg);
		this.remaining = remaining;
	}

	@Override
	public String getMessage() {
		return super.getMessage() + this.remaining;
	}

}
