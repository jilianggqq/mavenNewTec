package edu.gqq.designpattern.listenerwithevent;

import static java.lang.System.out;
public class EMS implements WithdrawListener {

	@Override
	public void update(WithdrawEvent we) {
		out.format("EMS : %s withdraw %d money.\n", we.getName(), we.getNum());
	}

}
