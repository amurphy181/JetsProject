package com.skilldistillery.jets;

public class JetsApplication {

	public static void main(String[] args) {

		System.out.println("Welcome to Air Base Alpha.\n" + "Please select an option:\n");

		AirField airfield = new AirField();
		int choice = 0;

//		while (choice != 8) {
			// choice = airfield.displayUserMenu();
			airfield.userSelection();

//		}

		// airfield.listFleet();
		// String fastestJet = airfield.viewFastestPlane();
		// System.out.println("\nFastest jet is the " + fastestJet);
		// StringBuilder flyAllJets = airfield.flyAllJets();
		// System.out.println("\nPreparing for flight:\n" + flyAllJets);

	}

}
