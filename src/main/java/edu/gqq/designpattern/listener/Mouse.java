package edu.gqq.designpattern.listener;

import static java.lang.System.out;

public class Mouse implements Observer {

	@Override
	public void update() {
		out.println("zhizhi..");
	}

}
