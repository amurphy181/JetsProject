package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier{
	
	private int passengerCapacity;

	public CargoPlane(String model, double speed, int range, long price, int passengerCapacity) {
		super(model, speed, range, price);
		this.passengerCapacity = passengerCapacity;
	}

	@Override
	public void loadCargo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Type: Cargo Plane\n" + "Model = " + getModel() + ", Speed = "
				+ getSpeed() + ", Range = " + getRange() + ", Cargo Capacity = " + passengerCapacity + 
				", Price = " + getPrice();
	}

}
