package edu.gqq.design.lift3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorController implements IStopListener, IController{
	
	List<Elevator> elevators;
	List<Queue<Integer>> passagers;
	
	public ElevatorController() {
		initElevators();
		initPassagers();
	}
	

	/**
	 * initialize passagers.
	 */
	private void initPassagers() {
		passagers = new ArrayList<>();
		for (int i = 0; i < Constants.FLOORS; i++) {
			passagers.add(new LinkedList<>());
		}
	}


	/**
	 * initialize elevators
	 */
	private void initElevators() {
		elevators = new ArrayList<>();
		for (int i = 0; i < Constants.FLOORS; i++) {
			Elevator elevator = new Elevator();
			elevator.setOnstopListener(this);
			elevators.add(elevator);
		}
		
	}
	
	/**
	 * loop every elevator. get the shortest distance.
	 * @param floor
	 */
	public void pickup(int floor) {
		int min = Constants.FLOORS;
		int nearstElevatorIdx = -1;
		for (int i = 0; i < Constants.FLOORS; i++) {
			Elevator elevator = elevators.get(i);
			int distance = 0;
			if (elevator.getDirection() == Direction.None) {
				distance = Math.abs(floor - elevator.getCurrentFloor());
			} else if (elevator.getDirection() == Direction.Up) {
				if (elevator.getCurrentFloor() < floor) {
					distance = floor - elevator.getCurrentFloor();
				} else {
					distance = 2 * elevator.getMax() - elevator.getCurrentFloor() - floor;
				}
			} else {
				if (elevator.getCurrentFloor() > floor) {
					distance = elevator.getCurrentFloor() - floor;
				} else {
					distance = elevator.getCurrentFloor() + floor - 2 * elevator.getMin();
				}
			}
			if (distance < min) {
				nearstElevatorIdx = i;
				distance = min;
			}
		}
		elevators.get(nearstElevatorIdx).setGoalFloor(floor);
		
	}


	@Override
	public void onStop(Object obj) {
		Elevator elevator = (Elevator)obj;
		int floor = elevator.getCurrentFloor();
		Queue<Integer> queue = passagers.get(floor);
		while (!queue.isEmpty()) {
			elevator.setGoalFloor(queue.poll());
		}
	}


	@Override
	public void step() {
		for (Elevator elevator : elevators) {
			elevator.moveStep();
		}
	}

}
