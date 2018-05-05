package com.skilldistillery.jets;

import java.util.Scanner;

public class AirField {

	Jet[] baseAlpha;

	{
		baseAlpha = new Jet[20];

		baseAlpha[0] = new FighterJet("F-15", 1500, 2000, 35_000_000, 8);
		baseAlpha[1] = new FighterJet("F-22", 1800, 2000, 35_000_000, 8);
		baseAlpha[2] = new CargoPlane("C-130 Hercules", 450, 2000, 35_000_000, 8);
		baseAlpha[3] = new CargoPlane("C-5 Galaxy", 500, 2000, 35_000_000, 40);
		baseAlpha[4] = new FighterJet("F-18", 2000, 2000, 35_000_000, 8);

	}

	void displayUserMenu() {
		System.out.println("\n1: List Fleet");
		System.out.println("2: Fly all jets");
		System.out.println("3: View fastest jet");
		System.out.println("4: View jet with longest range");
		System.out.println("5: Load all Cargo Jets");
		System.out.println("6: Dogfight!!");
		System.out.println("7: Add a jet to the fleet");
		System.out.println("8: Quit\n");

	}

	void userSelection() {
		boolean looper = true;
		while (looper) {
			displayUserMenu();
			Scanner input = new Scanner(System.in);
			int userChoice = input.nextInt();
			if (userChoice == 1) {
				listFleet();
			} else if (userChoice == 2) {
				System.out.println("Preparing planes for takeoff!\n");
				StringBuilder flyJets = (flyAllJets());
				System.out.println(flyJets);
			} else if (userChoice == 3) {
				String fastestJet = viewFastestPlane();
				System.out.println("The fastest plane in the fleet is the " + fastestJet);
			} else if (userChoice == 4) {
				String longestRange = viewPlaneWithLongestRange();
				System.out.println("The longest-ranging plane in the fleet is the " + longestRange);
			} else if (userChoice == 5) {
				StringBuilder cargoPlaneList = loadCargoPlanes();
				System.out.println(cargoPlaneList);
			} else if (userChoice == 6) {

			} else if (userChoice == 7) {
				addPlaneToFleet();
			} else if (userChoice == 8) {
				System.out.println("\nGoodbye! We hope you enjoyed your airfield simulator.");
				looper = false;
			}
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
			if (jet != null) {
				flyAllJets.append(jet.getModel() + " in the air!\n");
			}
		}
		return flyAllJets;
	}

	public void addPlaneToFleet() {
		Scanner input = new Scanner(System.in);
		System.out.println("What type of plane would you like to add to the fleet?");
		System.out.println("1. Fighter Jet");
		System.out.println("2. Cargo Plane");
		int planeType = input.nextInt();
		input.nextLine();
		System.out.print("Enter the model type: ");
		String planeModel = input.nextLine();
//		input.nextLine();
		System.out.print("Enter the top speed: ");
		double planeSpeed = input.nextDouble();
		System.out.print("Enter the range: ");
		int planeRange = input.nextInt();
		System.out.print("How much does Lockheed want for this one? Please enter: ");
		long planePrice = input.nextLong();
		input.nextLine();
		int planeMissileCapacity = 0;
		int planePassengerCapacity = 0;
		if (planeType == 1) {
			System.out.print("Please enter the total number of missiles: ");
			planeMissileCapacity = input.nextInt();
		} else if (planeType == 2) {
			System.out.print("Please enter the total number of passengers: ");
			planePassengerCapacity = input.nextInt();
		}

		for (int i = 0; i < baseAlpha.length; i++) {
			if (baseAlpha[i] == null) {
				if (planeType == 1) {
					baseAlpha[i] = new FighterJet(planeModel, planeSpeed, planeRange, planePrice, planeMissileCapacity);
					break;
				} else if (planeType == 2) {
					baseAlpha[i] = new CargoPlane(planeModel, planeSpeed, planeRange, planePrice, planePassengerCapacity);
					break;
				}
			}
		}

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

	public String viewPlaneWithLongestRange() {
		double range = 0;
		String longestRange = null;

		for (Jet jet : baseAlpha) {
			if (jet != null) {
				if (jet.getRange() > range) {
					range = jet.getRange();
					longestRange = jet.getModel();
				}
			}
		}
		return longestRange;
	}

	public StringBuilder loadCargoPlanes() {
		StringBuilder cargoPlane = new StringBuilder("\n");
		for (Jet jet : baseAlpha) {
			if (jet != null) {
				if (jet instanceof CargoPlane) {
					cargoPlane.append(jet.getModel() + " ready for loading! What say you, lackeys?!\n");
					cargoPlane.append((((CargoPlane) jet).loadCargo()) + "\n\n");
				}
			}
		}
		return cargoPlane;
	}

}
