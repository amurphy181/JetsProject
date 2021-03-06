package com.skilldistillery.jets;

import java.util.Scanner;

public class AirField {

	Jet[] baseAlpha;

	{
		baseAlpha = new Jet[20];

		baseAlpha[0] = new FighterJet("F-22", 1500, 1900, 140_000_000, 4, 90);
		baseAlpha[1] = new FighterJet("F-15", 1875, 3000, 100_000_000, 4, 100);
		baseAlpha[2] = new CargoPlane("C-130", 350, 2300, 30_000_000, 92);
		baseAlpha[3] = new CargoPlane("C-5", 530, 6000, 100_000_000, 40);
		baseAlpha[4] = new FighterJet("F-18", 1200, 1275, 70_000_000, 4, 80);

	}

	Jet[] attackersSukhoi;

	{
		attackersSukhoi = new Jet[20];

		attackersSukhoi[0] = new Attackers("Su-37", 1550, 1800, 100_000_000, 4, 90);
		attackersSukhoi[1] = new Attackers("Su-37", 1550, 1800, 100_000_000, 4, 90);
		attackersSukhoi[2] = new Attackers("Su-37", 1550, 1800, 100_000_000, 4, 90);
	}

	public Pilots pilots[] = new Pilots[20];

	{
		pilots[0] = new Pilots("Yossarian");
		pilots[1] = new Pilots("Major Major");
		pilots[2] = new Pilots("Chuck Yeager");
		pilots[3] = new Pilots("Billy \"One-Eyed Wonder\" Cloudchaser");
		pilots[4] = new Pilots("Lando Calrissian");

	}

	public String[] pilotWithJet = new String[20];

	void displayUserMenu() {
		System.out.println("\n1: List Fleet");
		System.out.println("2: Fly all jets");
		System.out.println("3: View fastest jet");
		System.out.println("4: View jet with longest range");
		System.out.println("5: Load all Cargo Jets");
		System.out.println("6: Dogfight!!");
		System.out.println("7: List pilots");
		System.out.println("8: Add a pilot");
		System.out.println("9: Add a jet to the fleet");
		System.out.println("10: View flight times of jet aircraft");
		System.out.println("11: Match planes to pilots");
		System.out.println("12: Review Aircraft/Airman matches");
		System.out.println("13: Quit\n");

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
			} else if (userChoice == 6) { // figure out the dog fighting aspect
				System.out.println("\nAttackers inbound! Scramble the fighters!");
				Dogfight();
				System.out.println("This is not quite working properly yet.");
			} else if (userChoice == 7) { // view list of pilots
				System.out.println("Pilots available: ");
				StringBuilder pilotNames = listPilots();
				System.out.println(pilotNames);
			} else if (userChoice == 8) { // add a pilot to the roster
				addPilotToRoster();
			} else if (userChoice == 9) {
				addPlaneToFleet();
			} else if (userChoice == 10) {
				aircraftFlightTimes();
			} else if (userChoice == 11) { // match up the planes to a pilot, non-random
				System.out.println("Matching planes to pilots!");
				jetPilotMatchup();
				System.out.println(
						"Completed. Please select the correct menu item to view the results for today's flights.");
			} else if (userChoice == 12) { // list the array that shows the pilot with plane matchup
				System.out.println("Aircraft with Airman matches are as follows: ");
				StringBuilder pilotWithPlaneList = listPilotMatchup();
				System.out.println(pilotWithPlaneList);
			} else if (userChoice == 13) {
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

	// take input for different plane types, then use those variable to populate new
	// plane constructors
	public void addPlaneToFleet() {
		Scanner input = new Scanner(System.in);
		System.out.println("What type of plane would you like to add to the fleet?");
		System.out.println("1. Fighter Jet");
		System.out.println("2. Cargo Plane");
		int planeType = input.nextInt();
		input.nextLine();
		System.out.print("Enter the model type: ");
		String planeModel = input.nextLine();
		// input.nextLine();
		System.out.print("Enter the top speed: ");
		double planeSpeed = input.nextDouble();
		System.out.print("Enter the range: ");
		int planeRange = input.nextInt();
		System.out.print("How much does Lockheed want for this one? Please enter: ");
		long planePrice = input.nextLong();
		input.nextLine();
		int planeMissileCapacity = 0;
		int planePassengerCapacity = 0;
		int planeHealth = 0;
		if (planeType == 1) {
			System.out.print("Please enter the total number of missiles: ");
			planeMissileCapacity = input.nextInt();
			System.out.print("Please enter the total health: ");
			planeHealth = input.nextInt();
		} else if (planeType == 2) {
			System.out.print("Please enter the total number of passengers: ");
			planePassengerCapacity = input.nextInt();
		}

		for (int i = 0; i < baseAlpha.length; i++) {
			if (baseAlpha[i] == null) {
				if (planeType == 1) {
					baseAlpha[i] = new FighterJet(planeModel, planeSpeed, planeRange, planePrice, planeMissileCapacity,
							planeHealth);
					break;
				} else if (planeType == 2) {
					baseAlpha[i] = new CargoPlane(planeModel, planeSpeed, planeRange, planePrice,
							planePassengerCapacity);
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

	public StringBuilder loadCargoPlanes() { // call the load method on cargo planes exclusively
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

	public void aircraftFlightTimes() { // print out total flight time (range/speed in m.p.h.) when called
		System.out.println("\nFlight time information (at full burn):\n");
		for (Jet jet : baseAlpha) {
			if (jet != null) {
				String flightTime = jet.fly();
				System.out.println("           Aircraft model: " + jet.getModel());
				System.out.println("    Available flight time: " + flightTime + " hours.\n");
			}
		}
	}

	// output name by iterating through the pilots list for all non-null pilots
	public StringBuilder listPilots() {
		StringBuilder nameList = new StringBuilder("");
		for (Pilots pilots2 : pilots) {
			if (pilots2 != null) {
				nameList.append("\t" + pilots2.pilotName + "\n");
			}
		}
		return nameList;

	}

	public void addPilotToRoster() { // use a switch to add a predetermined pilot, or add one of your own
		System.out
				.println("Hiring? \n\nPlease select from a pilot from the list below, or press \"5\" to add your own.");
		System.out.println("1. Colonel Plandebuilt");
		System.out.println("2. Shuck Todgers");
		System.out.println("3. Le Petit Bonhomme de Neige");
		System.out.println("4. Harold. Just Harold.");
		System.out.println("5. Add your own!");
		Scanner input = new Scanner(System.in);
		int pilotChoice = input.nextInt();
		input.nextLine();

		for (int i = 0; i < pilots.length; i++) {
			if (pilots[i] == null) {
				if (pilotChoice == 1) {
					System.out.println("Colonel Plandebuilt, at your service!");
					pilots[i] = new Pilots("Colonel Plandebuilt");
					break;
				} else if (pilotChoice == 2) {
					System.out.println("Shuck Todgers, inebriated but ready!");
					pilots[i] = new Pilots("Shuck Todgers");
					break;
				} else if (pilotChoice == 3) {
					System.out.println("Le Petit Bonhomme de Neige, eager for altitude!");
					pilots[i] = new Pilots("Le Petit Bonhomme de Neige");
					break;
				} else if (pilotChoice == 4) {
					System.out.println("Harold.");
					pilots[i] = new Pilots("Harold");
					break;
				} else if (pilotChoice == 5) {
					System.out.println("Have someone in mind, eh? \nEnter on the dotted line: ...........");
					String pilotName = input.nextLine();
					pilots[i] = new Pilots(pilotName);
					System.out.println("\nAirman " + pilotName + ", trained and ready!");
					break;
				} else {
					System.out.println("No choice like an incorrect choice.");
				}
			}
		}

	}

	public void jetPilotMatchup() {

		int count = 0;

		for (Jet jet : baseAlpha) {
			if (jet != null && pilots[count] != null) {
				pilotWithJet[count] = ("Plane: " + jet.getModel() + "\tPilot: " + pilots[count].getPilotName());
				count++;
			}
		}

	}

	public StringBuilder listPilotMatchup() {
		StringBuilder pilotMatchup = new StringBuilder();
		for (String pilotWithJet2 : pilotWithJet) {
			if (pilotWithJet2 != null) {
				pilotMatchup = (pilotMatchup.append(pilotWithJet2 + "\n"));
			}
		}
		return pilotMatchup;

	}

	public void Dogfight() {
		String attackerName;
		String defenderName;

		int defenderHealth;
		int attackerHealth;
		int missilesDefender;
		int missilesDefenderDamage = 25;
		int missilesDefenderRemaining;
		int missilesAttacker;
		int missilesAttackerDamage = 25;
		int missilesAttackerRemaining;

		boolean defenderAlive = true;
		boolean attackerAlive = true;
		double hitChance;
		for (int i = 0; i < baseAlpha.length; i++) {
			
				if (baseAlpha[i] instanceof FighterJet) { // run first fighter in the base through the gauntlet. Best of luck.
					missilesDefender = ((FighterJet) baseAlpha[i]).getMissileCapacity();
					defenderHealth = ((FighterJet) baseAlpha[i]).getHealth();

				if (defenderAlive == true && attackerAlive == true) {
					defenderName = ((FighterJet) baseAlpha[i]).getModel();
					for (int j = 0; j < attackersSukhoi.length; j++) {

						attackerName = ((Attackers) attackersSukhoi[j]).getModel();
						attackerHealth = ((Attackers) attackersSukhoi[j]).getHealth();
						missilesAttacker = ((Attackers) attackersSukhoi[j]).getMissileCapacity();
							do { // defensive attack sequence begins
								if(attackerAlive == true) {
								System.out.println("\nEyes on bogey! \nDefender firing missile!");
								hitChance = Math.random();
								if (hitChance <= 0.9 && missilesDefender > 0 && attackerHealth > 0) { // 9/10 of a chance of hitting the
																				// target
									attackerHealth = (attackerHealth - missilesDefenderDamage);
									missilesDefender -= 1;
									missilesDefenderRemaining = ((FighterJet) baseAlpha[i]).getMissileCapacity() - missilesDefender;
									System.out.println("\nMissile number " + missilesDefenderRemaining + " has hit!");
									System.out.println(attackerName + " now has " + attackerHealth + " health.");
									if (attackerHealth < 0) {
										System.out.println("\nSplash our bandit!");
										attackerAlive = false;
										j++;
//										attackersSukhoi[j] = null;
									}

									// line up for a second shot, defense
									double secondShot = Math.random();
									if (secondShot < 0.5 && attackerAlive == true && missilesDefender > 0) {
										attackerHealth = (attackerHealth - missilesDefenderDamage);
										missilesDefender = missilesDefender - 1;
										missilesDefenderRemaining = ((FighterJet) baseAlpha[i]).getMissileCapacity() - missilesDefender;
										System.out.println("\nMissile number " + missilesDefenderRemaining + " has hit!");
										System.out.println("\nSuccessful second shot!!");
										System.out.println(attackerName + " now has " + attackerHealth + " health.");
										if (attackerHealth < 0) {
											System.out.println("\nSplash our bandit!");
											attackerAlive = false;
											j++;
//											attackersSukhoi[j] = null;
										}

									} else if (hitChance > 0.9) {
										System.out.println("Defensive missile missed the target!");
									}

									// attacker comes back with a missile shot
									else if (defenderAlive == true && attackerAlive == true && missilesAttacker > 0) {
										System.out.println("\nHe's getting behind me!");
										System.out.println(
												attackerName + " firing missile at " + baseAlpha[i].getModel() + "!");
										hitChance = Math.random();
										if (hitChance <= 0.9 && missilesAttacker > 0 && attackerHealth > 0) {
											defenderHealth = (defenderHealth - missilesAttackerDamage);
											if (defenderHealth < 0) {
												defenderAlive = false;
											}
											missilesAttacker -= 1;
											System.out.println(baseAlpha[i].getModel() + " friendly hit! "
													+ baseAlpha[i].getModel() + " health now " + defenderHealth);

											secondShot = Math.random();
											if (secondShot < 0.5 && attackerAlive == true && missilesDefender > 0) {
												defenderHealth = (defenderHealth - missilesDefenderDamage);
												missilesDefender = missilesDefender - 1;
												((Attackers) attackersSukhoi[j]).setHealth(attackerHealth);
												System.out.println("Successful second enemy shot!!\n");
												System.out.println(
														defenderName + " now has " + attackerHealth + " health.");
												if (defenderHealth < 0) {
													defenderAlive = false;
													
//													attackersSukhoi[j] = null;
												}

											}
										} else {
											System.out.println("Enemy missile missed!");
											break;
										}
									} else {
										break;
									}
								}
								}
							} while (defenderHealth > 0 && attackerHealth > 0) ;

						
					}
				}

			} 
				break;
		} 

	}

}
