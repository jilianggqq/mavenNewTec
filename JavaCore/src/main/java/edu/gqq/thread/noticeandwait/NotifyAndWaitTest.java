package edu.gqq.thread.noticeandwait;

import static java.lang.System.out;

import java.util.Arrays;

public class NotifyAndWaitTest {
	public static void main(String[] args) {
		String[] s1 = { "Hi 1", "How are you ?", "I am also doing fine!" };
		String[] s2 = { "Hi 2", "I am good, what about you?", "Great!" };
		Chat chat = new Chat();


		new Thread(() -> {
			Arrays.stream(s1).forEach(x -> chat.Question(x));
		}).start();

		new Thread(() -> {
			Arrays.stream(s2).forEach(x -> chat.Answer(x));
		}).start();
	}
}

class Chat {
	boolean flag = false;

	public synchronized void Question(String msg) {
		Thread currentThread = Thread.currentThread();
		if (flag) {
			try {
				out.println(currentThread.getName() + "--- need answer, so waiting..");
				wait();
				out.println(currentThread.getName() + "--- is notified..");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {

			// Integer.parseInt("aa");
			System.out.println(msg);
		} catch (Exception e) {
			out.println(e.getMessage());
		} finally {
			flag = true;
			notify();
		}
	}

	public synchronized void Answer(String msg) {
		Thread currentThread = Thread.currentThread();
		if (!flag) {
			try {
				out.println(currentThread.getName() + "--- no question, so waiting..");
				wait();
				out.println(currentThread.getName() + "--- is notified.");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		out.println(msg);
		flag = false;
		notify();
	}
}
