package edu.gqq;

import edu.gqq.designpattern.listener.Cat;
import edu.gqq.designpattern.listener.Master;
import edu.gqq.designpattern.listener.Mouse;
import edu.gqq.designpattern.listenerwithevent.Atm;
import edu.gqq.designpattern.listenerwithevent.EMS;
import edu.gqq.designpattern.listenerwithevent.Email;
import junit.framework.TestCase;

public class ListenerTest extends TestCase {
	public void testListener() {
		Cat cat = new Cat();
		cat.addObserver(new Master());
		cat.addObserver(new Mouse());
		cat.cry();

		Atm atm = new Atm();
		atm.addListeners(new Email());
		atm.addListeners(new EMS());
		atm.withDraw("zhangsan", 3);
		atm.withDraw("lisi", 100);

	}
}
