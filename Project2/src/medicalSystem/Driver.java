package medicalSystem;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class Driver {
	public static void main(String[] args) throws IOException, Exception {
		Scanner scnr = new Scanner(System.in);
		String typeOfUser;
		String username;
		String password;
		boolean isAccepted = false;
		PatientManager PM;
		
		Login.readPatientFile();
		Login.readMedStafftFile();
		
		while(!isAccepted) {
		
			System.out.println("Are you a patient or medical staff? Respond in all lowercase:");
			typeOfUser = scnr.nextLine();
			System.out.println("Enter username:"); 
			username = scnr.nextLine();
			System.out.println("Enter password:");
			password = scnr.nextLine();
		
			if(typeOfUser.equals("patient")) {
				if(Login.isPatientAccepted(username, password) != null) {
					PM = Login.isPatientAccepted(username, password);
					System.out.println("your logged in!");
					PMPromting(PM);
					//PM.something that moves main tasks to patient tasks
				}
				else {
					System.out.println("Login information is incorrect, please try again");
					isAccepted = false;
				}
				
			}
			else if(typeOfUser.equals("medical staff")) {
				if(Login.isMedStaffAccepted(username, password) != null) {
					PM = Login.isMedStaffAccepted(username, password);
					System.out.println("your logged in!");
					PMPromting(PM);
					isAccepted = true;
				}
				else {
					System.out.println("Login information is incorrect, please try again");
					isAccepted = false;
				}
				
			}
			else {
				System.out.println("Please type either \"patient\" or \"medical staff\"");
				isAccepted = false;
			}
		}
	}
	public static void PMPromting(PatientManager PM) throws IOException { //TODO: add user prompting
		Scanner scnr = new Scanner(System.in);
		int MenuVal = 0;
		int userSearchVal;
		PM.UserView();

		PM.orderPatientList();
		while(MenuVal != 5) {
			System.out.println("type the numbers listed on the main menu to preform task");
			System.out.println("MAIN MENU: 1 - view perseonal info 2 - search for a patient 3 - change info 4 - write a patient report 5 - quit");
			try {
				MenuVal = scnr.nextInt();
			}
			catch(Exception except) {
				System.out.println("That's not a number, try again");
				MenuVal = scnr.nextInt();
			}
			if(MenuVal == 1) {
				PM.UserView();
			}
			else if(MenuVal == 2) {
				try {
					System.out.println("Type the ID of the user you are searching for");
					userSearchVal = scnr.nextInt();
					PM.PatientSearch(userSearchVal);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else if(MenuVal == 3) {
				PM.changeInfo(scnr);
			}
			else if(MenuVal == 4) {
				PM.initiateReport(scnr);
			}
		}
		System.out.println("Goodbye");
	
		
	}
}
