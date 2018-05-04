package com.skilldistillery.jets;


public class JetsApplication {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Air Base Alpha.\n" + 
					       "Please select an option:\n");
		
		AirField airfield = new AirField();
		
		while(airfield.displayUserMenu() != 8){
			int choice = airfield.displayUserMenu();
			while(choice != 8) {
			airfield.userSelection(choice);
			}
			
		} 
		
//		airfield.listFleet();
//		String fastestJet = airfield.viewFastestPlane();
//		System.out.println("\nFastest jet is the " + fastestJet);
//		StringBuilder flyAllJets = airfield.flyAllJets();
//		System.out.println("\nPreparing for flight:\n" + flyAllJets);

	}
	
	
	
	

}
