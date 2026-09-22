package medicalSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;


public class PatientManager {
	private User user;
	private User currView;
	private static ArrayList<Patient> orderedPatientList;

	public PatientManager(User user, ArrayList<Patient> patientList) {
		this.user = user;
		currView = user;
		orderedPatientList = patientList;
	}
	
	
	public static void orderPatientList() {
		
		for(int i = 0;i < orderedPatientList.size() - 1; ++i) {
			for(int j = 0;j < orderedPatientList.size() - 1; ++j) {
				if(orderedPatientList.get(j).getID() >  orderedPatientList.get(j + 1).getID()) {
					Collections.swap(orderedPatientList, j , j + 1);
				}
			}
		}
	}
	
	
	public static Patient searchPatientList(int value) {
		int bIndex = 0;
		int mIndex;
		int fIndex = orderedPatientList.size();
		
		orderPatientList();
		while(bIndex <= fIndex) {
			mIndex = (bIndex + fIndex)/2;
			if(value == orderedPatientList.get(mIndex).getID()) {
				return orderedPatientList.get(mIndex);
			}
			else if(value < orderedPatientList.get(mIndex).getID()) {
				fIndex = mIndex - 1;
			}
			else {
				bIndex = mIndex + 1;
			}
		}
		return null;
	}
	
	
	public void UserView() { 
		System.out.println(currView.toString());
	}
	
	
	public void PatientSearch(int givenID) throws Exception { 
		if(user instanceof Patient) {
			throw new Exception("Patients cannot do patient search");
		}
		else if(user instanceof MedStaff) {
			currView = searchPatientList(givenID);
			if(currView != null) {
				UserView();
			}
			else {
				currView = user;
				System.out.println("Incorrect input, please try again");
			}
		}
	}
	
	
	public void changeInfo(Scanner scnr) throws IOException {
		String chosenAttribute;
		String chosenEdit;
		if(currView instanceof Patient) {
			System.out.println("What informataion would you like to change? Type either \"password\" \"name\" \"email\" or \"treatment notes.\"");
		}
		else {
			System.out.println("What informataion would you like to change? Type either \"password\" \"name\" \"email\" or \"department.\"");
		}
		chosenAttribute = scnr.nextLine();
		System.out.println("What would you like to change it to?");
		chosenEdit = scnr.nextLine();
		if(chosenAttribute.equals("password")) {
			currView.setPassword(chosenEdit);
		}
		else if(chosenAttribute.equals("name")) {
			currView.setName(chosenEdit);
		}
		else if(chosenAttribute.equals("email")) {
			currView.setEmail(chosenEdit);
		}
		else if(chosenAttribute.equals("treatment notes")) {
			if(user instanceof Patient) {
			((Patient)currView).setTreatmentNotes(chosenEdit);
			}
			else {
				System.out.println("Medical staff view does not have treatment notes to edit. Please try again.");
			}
		}
		else if(chosenAttribute.equals("department")) {
			if(user instanceof MedStaff) {
			((MedStaff)currView).setDepartment(chosenEdit);
			}
			else {
				System.out.println("Patient view does not have departments to edit. Please try again.");
			}
		}
		else {
			System.out.println("You entered an invalid information type. Please try again");
		}
		
		FileWriter fw = new FileWriter("patient.csv");
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0;i < orderedPatientList.size(); ++i) {
			bw.write(orderedPatientList.get(i).toString());
			bw.newLine();
		}
		bw.close();
		fw.close();
	} 
	public void initiateReport(Scanner scnr){
		int reportVal;
		
		
		System.out.println("What type of report would you like to write?");
		System.out.println("1 - list by ID 2 - list alphebetically (by name) 3 - just emails 4 - user report");
		reportVal = scnr.nextInt();
		
		try {
			if(reportVal == 1) {
				Report.reportAscendingID(orderedPatientList);
			}
			else if(reportVal == 2) {
				Report.reportAscendingName(orderedPatientList);
			}
			else if(reportVal == 3) {
				Report.reportAscendingEmail(orderedPatientList);
			}
			else if(reportVal == 4) {
				Report.reportUser(user);
			}
		}
		catch(Exception except){
			System.out.println("Woops! Something went wrong.");
		}
	}
}
