package com.skilldistillery.jets;

public class JetsApplication {

	public static void main(String[] args) {

		System.out.println("Welcome to Air Base Alpha.\n" + "Please select an option:\n");

		AirField airfield = new AirField();

		airfield.userSelection();

	}

}
