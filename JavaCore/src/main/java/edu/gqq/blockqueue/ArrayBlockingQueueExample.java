package edu.gqq.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueExample {
	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);
		Thread consumer = new Thread(new BlockingQueueConsumer(blockingQueue));
		Thread producer = new Thread(new BlockingQueueProducer(blockingQueue));
		producer.start();
		consumer.start();
	}
}

class BlockingQueueConsumer implements Runnable {
	protected BlockingQueue<String> blockingQueue;

	public BlockingQueueConsumer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
				System.out.println(blockingQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class BlockingQueueProducer implements Runnable {

	protected BlockingQueue<String> blockQueue;

	public BlockingQueueProducer(BlockingQueue<String> blockQueue) {
		this.blockQueue = blockQueue;
	}

	@Override
	public void run() {
		while (true) {

			try {
				// Thread.sleep(500);
				blockQueue.put("abc");
				System.out.println("putting abc");

				blockQueue.put("def");
				System.out.println("putting def");
				Thread.sleep(1000);
				blockQueue.put("ghi");
				System.out.println("putting ghi");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
