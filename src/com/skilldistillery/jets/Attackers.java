package com.skilldistillery.jets;

public class Attackers extends Jet{
	
	private int missileCapacity;
	private int health;

	public Attackers(String model, double speed, int range, long price, int missileCapacity, int health) {
		super(model, speed, range, price);
		this.missileCapacity = missileCapacity;
		this.health = health;
	}

	public int getMissileCapacity() {
		return missileCapacity;
	}

	public void setMissileCapacity(int missileCapacity) {
		this.missileCapacity = missileCapacity;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	

}
