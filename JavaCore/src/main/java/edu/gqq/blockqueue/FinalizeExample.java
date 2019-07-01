package edu.gqq.blockqueue;

public class FinalizeExample {
	public static void main(String[] args) {
		FinalizeExample f1 = new FinalizeExample();
		FinalizeExample f2 = new FinalizeExample();
		FinalizeExample f3 = new FinalizeExample();
		f1 = null;
		f2 = null;
		f3 = null;
		System.gc();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		// super.finalize();
		System.out.println("finalize called!");
	}
}
