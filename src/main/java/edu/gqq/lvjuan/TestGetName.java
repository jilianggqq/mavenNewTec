package edu.gqq.lvjuan;

import edu.gqq.common.G;

public class TestGetName {
	public static void main(String[] args) {
		P1 p = new PP().getP();
		G.println(p.getClass().getName());
	}
}

class P1 {

}

class P2 extends P1 {

}

class PP {

	public P1 getP() {
		return new P2();
	}
}
