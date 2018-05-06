package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady{
	
	private int missileCapacity;

	public FighterJet(String model, double speed, int range, long price, int missileCapacity) {
		super(model, speed, range, price);
		this.missileCapacity = missileCapacity;
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

}
