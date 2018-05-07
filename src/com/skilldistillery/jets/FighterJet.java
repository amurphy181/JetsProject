package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady{
	
	private int missileCapacity;
	private int health;

	public int getMissileCapacity() {
		return missileCapacity;
	}

	public void setMissileCapacity(int missileCapacity) {
		this.missileCapacity = missileCapacity;
	}

	public FighterJet(String model, double speed, int range, long price, int missileCapacity, int health) {
		super(model, speed, range, price);
		this.missileCapacity = missileCapacity;
		this.setHealth(health);
	}

	@Override
	public void fight() {
		System.out.println("Gentlemen, gentlemen!! There will be only fighting in the war room!");
	}

	@Override
	public String toString() {
		return "Type: Fighter Jet\n" + "Model = " + getModel() + ", Speed = "
				+ getSpeed() + ", Range = " + getRange() + ", Missile Capacity = " + missileCapacity + 
				", Price = " + getPrice();
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
