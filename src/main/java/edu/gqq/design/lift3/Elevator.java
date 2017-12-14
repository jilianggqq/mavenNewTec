package edu.gqq.design.lift3;

public class Elevator {
	private int cf;
	private int min;
	private int max;
	private boolean[] floors;

	private Direction direction;

	private boolean move;

	private int upCount;
	private int downCount;

	private IStopListener _stopListener;

	public Elevator() {
		reset();
	}
	
	public int getCurrentFloor() {
		return this.cf;
	}
	
	public Direction getDirection() {
		return this.direction;
	}

	public void reset() {
		min = Constants.MIN_FLOOR;
		max = Constants.MAX_FLOOR;
		cf = 0;
		floors = new boolean[Constants.FLOORS];
		direction = Direction.None;
		move = false;
		// TODO the count
		upCount = 0;
		downCount = 0;
	}

	/**
	 * set goal floor
	 * 
	 * @param floor
	 */
	public void setGoalFloor(int floor) {
		if (floor == cf || floors[floor]) {
			return;
		}
		if (floor > cf) {
			upCount++;
			if (floor > max) {
				max = floor;
			}
		}
		if (floor < cf) {
			downCount--;
			if (floor < min) {
				min = floor;
			}
		}
		floors[floor] = true;

		// TODO you forget changing the direction.
		if (direction == Direction.None) {
			direction = floor > cf ? Direction.Up : Direction.Down;
		}
	}

	/**
	 * elevator is moving
	 */
	public void moveStep() {
		// if it is not moving, check the direction.
		if (!move) {
			if (direction != Direction.None) {
				move = true;
				return;
			}
		}

		if (direction == Direction.Up) {
			cf++;
			if (floors[cf]) {
				// stop here
				floors[cf] = false;
				move = false;
				if (--upCount == 0) {
					max = Constants.MAX_FLOOR;
					// change direction
					direction = downCount == 0 ? Direction.None : Direction.Down;
				}
				if (_stopListener != null) {
					_stopListener.onStop();
				}
			}
		} else {
			cf--;
			if (floors[cf]) {
				// stop here
				floors[cf] = false;
				move = false;
				if (++downCount == 0) {
					min = Constants.MIN_FLOOR;
					// change direction
					direction = upCount == 0 ? Direction.None : Direction.Up;
				}
				_stopListener.onStop();
			}
		}
	}

	// TODO forget listener interface.
	public void setOnstopListener(IStopListener _listener) {
		this._stopListener = _listener;
	}

	public int getMax() {
		return max;
	}
	
	public int getMin() {
		return min;
	}
}
