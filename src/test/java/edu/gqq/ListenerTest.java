package edu.gqq;

import edu.gqq.design.listener.Cat;
import edu.gqq.design.listener.Master;
import edu.gqq.design.listener.Mouse;
import edu.gqq.design.listenerwithevent.Atm;
import edu.gqq.design.listenerwithevent.EMS;
import edu.gqq.design.listenerwithevent.Email;
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
