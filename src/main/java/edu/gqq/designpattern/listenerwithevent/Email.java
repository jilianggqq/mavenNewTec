package edu.gqq.designpattern.listenerwithevent;

import static java.lang.System.out;
public class Email implements WithdrawListener {

	@Override
	public void update(WithdrawEvent we) {
		out.format("Email : %s withdraw %d money.\n", we.getName(), we.getNum());
	}

}
