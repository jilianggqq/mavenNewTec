package edu.gqq.algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Top5Revenue {
	private static final String TRANSIENT = "transient";
	private static final String PATH = "/home/gqq/Downloads/events_time.csv";
	private static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		top5Revenue();
	}
	
	private static double getRevenue(String strRevenue) {
		if (strRevenue.startsWith("(")) {
			strRevenue = strRevenue.substring(1, strRevenue.length() - 1);
		}
		return Double.parseDouble(strRevenue);
	}

	public static void top5Revenue() {
		PriorityQueue<Item> pq = new PriorityQueue<>();
		
		String elem = null;
		try {
			FileReader fr = new FileReader(PATH);
			BufferedReader bReader = new BufferedReader(fr);
			while ((elem = bReader.readLine()) != null) {
				String[] elems = elem.split(",\\s");
				if (elems.length != 3 || !elems[1].equals(TRANSIENT)) {
					continue;
				}
//				System.out.println(elems[2]);
				if (elems[1].equals(TRANSIENT)) {
					Item item = new Item(elems[0], elems[1], getRevenue(elems[2]));
					pq.offer(item);
					if (pq.size() > MAX_SIZE) {
						pq.poll();
					}
				}
			}
			bReader.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// output
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}

class Item implements Comparable<Item> {
	String time;
	String type;
	double revenue;

	public Item(String time, String type, double revenue) {
		this.time = time;
		this.type = type;
		this.revenue = revenue;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s", time, type, revenue + "");
	}

	@Override
	public int compareTo(Item o) {
		return (int) (this.revenue - o.revenue);
	}

}
