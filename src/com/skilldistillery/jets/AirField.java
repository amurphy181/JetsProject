package com.skilldistillery.jets;

import java.util.Scanner;

public class AirField {
	
	int userChoice = displayUserMenu();

	Jet[] baseAlpha;

	{
		baseAlpha = new Jet[20];

		baseAlpha[0] = new FighterJet("F-15", 1500, 2000, 35_000_000, 8);
		baseAlpha[1] = new FighterJet("F-22", 1800, 2000, 35_000_000, 8);
		baseAlpha[2] = new CargoPlane("C-130 Hercules", 450, 2000, 35_000_000, 8);
		baseAlpha[3] = new CargoPlane("C-5 Galaxy", 500, 2000, 35_000_000, 40);
		baseAlpha[4] = new FighterJet("F-18", 2000, 2000, 35_000_000, 8);

	}

	int displayUserMenu() {
		System.out.println("1: List Fleet");
		System.out.println("2: Fly all jets");
		System.out.println("3: View fastest jet");
		System.out.println("4: View jet with longest range");
		System.out.println("5: Load all Cargo Jets");
		System.out.println("6: Dogfight!!");
		System.out.println("7: Add a jet to the fleet");
		System.out.println("8: Quit");
		Scanner input = new Scanner(System.in);
		int userChoice = input.nextInt();
		return userChoice;

	}
	
	void userSelection(int userChoice) {
		switch(userChoice) {
		case 1:
			listFleet();
			break;
		case 2:
			flyAllJets();
			break;
		case 3:
			viewFastestPlane();
			break;
		case 4:
		case 5:
		case 6:
		case 7:
		}
	}

	public void listFleet() {
		Jet[] baseAlphaList = baseAlpha;
		for (int i = 0; i < baseAlphaList.length; i++) {

			if (baseAlphaList[i] != null) {
				System.out.println(baseAlphaList[i].toString());

			}
		}
	}
	
	public StringBuilder flyAllJets() {
		StringBuilder flyAllJets = new StringBuilder();
		for (Jet jet : baseAlpha) {
			if(jet != null) {
				flyAllJets.append(jet.getModel() + " in the air!\n");
			}
		}
		return flyAllJets;
	}

	public String viewFastestPlane() {
		double speed = 0;
		String fastest = null;

		for (Jet jet : baseAlpha) {
			if (jet != null) {
				if (jet.getSpeed() > speed) {
					speed = jet.getSpeed();
					fastest = jet.getModel();
				}
			}
		}
		return fastest;
	}

}
