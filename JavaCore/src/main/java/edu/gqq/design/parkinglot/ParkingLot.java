package edu.gqq.design.parkinglot;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

public class ParkingLot {
	public long zipCode;
	private Queue<Spot> smallSpots;
	private Queue<Spot> mediumSpots;
	private Queue<Spot> largeSpots;
	private Queue<Spot> xlargeSpots;
	private Map<Vehicle, Spot> parking;

	
	public static void main(String[] args) {
		ParkingLot pLot = new ParkingLot(95035, 2, 50, 8, 2);
		Bus bus1 = new Bus();
		Spot spot1 = pLot.placeVehicle(bus1);
		System.out.println(spot1.get_id());
		Bus bus2 = new Bus();
		Spot spot2 = pLot.placeVehicle(bus2);
		System.out.println(spot2.get_id());
		pLot.removeVehicle(bus1);
		Bus bus3 = new Bus();
		Spot spot3 = pLot.placeVehicle(bus3);
		if (spot3 == null) {
			System.out.println("no parking lot.");
		} else {
			System.out.println(spot3.get_id());
		}
		
//		pLot.removeVehicle(bus2);
		pLot.removeVehicle(bus3);
		
		for (int i = 0; i < 20; i++) {
			Trunk trunk = new Trunk();
			Spot spot = pLot.placeVehicle(trunk);
			if (spot == null) {
				System.out.println("null");
			} else {
				System.out.println(spot);
			}
		}
		
	}
	
	public ParkingLot(long zipCode, int smallNum, int mediumNum, int largeNum, int xlargeNum) {
		this.zipCode = zipCode;
		parking = new HashMap<>();
		smallSpots = new LinkedList<>();
		mediumSpots = new LinkedList<>();
		largeSpots = new LinkedList<>();
		xlargeSpots = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < smallNum; i++) {
			Spot spot = new Spot(cnt++, Size.Small);
			smallSpots.offer(spot);
		}
		for (int i = 0; i < mediumNum; i++) {
			Spot spot = new Spot(cnt++, Size.Medium);
			mediumSpots.offer(spot);
		}
		for (int i = 0; i < largeNum; i++) {
			Spot spot = new Spot(cnt++, Size.Large);
			largeSpots.offer(spot);
		}
		
		for (int i = 0; i < xlargeNum; i++) {
			Spot spot = new Spot(cnt++, Size.XLarge);
			xlargeSpots.offer(spot);
		}
	}
	
	/**
	 * place one vehicle.
	 * 
	 * @param vl
	 * @return
	 */
	public Spot placeVehicle(Vehicle vl) {
		Spot spot = getSpotForVehicle(vl);
		parking.put(vl, spot);
		return spot;
	}

	private Spot getSpotForVehicle(Vehicle vl) {
		if (vl.getSize() == Size.XLarge) {
			if (!xlargeSpots.isEmpty()) {
				return xlargeSpots.poll();
			}
			return null;
		} else if (vl.getSize() == Size.Large) {
			if (!largeSpots.isEmpty()) {
				return largeSpots.poll();
			} else if (!xlargeSpots.isEmpty()) {
				return xlargeSpots.poll();
			} else {
				return null;
			}
		} else if (vl.getSize() == Size.Medium) {
			if (!mediumSpots.isEmpty()) {
				return mediumSpots.poll();
			} else if (!largeSpots.isEmpty()) {
				return largeSpots.poll();
			} else if (!xlargeSpots.isEmpty()) {
				return xlargeSpots.poll();
			} else {
				return null;
			}
		} else {
			if (!smallSpots.isEmpty()) {
				return smallSpots.poll();
			} else if (!mediumSpots.isEmpty()) {
				return mediumSpots.poll();
			} else if (!largeSpots.isEmpty()) {
				return largeSpots.poll();
			} else if (!xlargeSpots.isEmpty()) {
				return xlargeSpots.poll();
			} else {
				return null;
			}
		}
	}

	/**
	 * remove one vehicle from spot.
	 * 
	 * @param vl
	 * @return
	 */
	public Spot removeVehicle(Vehicle vl) {
		if (!parking.containsKey(vl)) {
			return null;
		}
		Spot spot = parking.get(vl);
		addToQueue(spot);
		parking.remove(vl);
		return spot;
	}

	private void addToQueue(Spot spot) {
		Size size = spot.get_size();
		if (size == Size.Small) {
			smallSpots.offer(spot);
		} else if (size == Size.Medium) {
			mediumSpots.offer(spot);
		} else if (size == Size.Large) {
			largeSpots.offer(spot);
		} else {
			xlargeSpots.offer(spot);
		}
	}
}
