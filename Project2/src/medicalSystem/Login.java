package medicalSystem;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;






public class Login {
	private static ArrayList<Patient> patientList;
	private static ArrayList<MedStaff> medStaffList;
	
	public static void readPatientFile() throws IOException {
		patientList = new ArrayList<Patient>(); 
		FileReader fReader = new FileReader("patient.csv");
		BufferedReader buffer = new BufferedReader(fReader);
		String line = "";
		Patient newP;
		
		while ((line = buffer.readLine()) != null) { 
			String[] stringArr = line.split(",");
			newP = new Patient(Integer.parseInt(stringArr[0]), stringArr[1], stringArr[2], stringArr[3], stringArr[4], stringArr[5]);
			patientList.add(newP);
		}
		fReader.close();
		buffer.close();
	}
	
	
	
	public static void readMedStafftFile() throws IOException {
		medStaffList = new ArrayList<MedStaff>(); 
		FileReader fReader = new FileReader("medicalstaff.csv");
		BufferedReader buffer = new BufferedReader(fReader);
		String line = "";
		MedStaff newMS;
		
		
		while ((line = buffer.readLine()) != null) { 
			String[] stringArr = line.split(",");
			newMS = new MedStaff(Integer.parseInt(stringArr[0]), stringArr[1], stringArr[2], stringArr[3], stringArr[4], stringArr[5]);
			medStaffList.add(newMS);
		}
	}
	
	
	public static PatientManager isMedStaffAccepted(String username, String password) throws Exception { 
		int i;
		MedStaff currMedStaff = null;
		PatientManager PM;
		
		for(i = 0;i < medStaffList.size(); i++) {
			if(username.equals(medStaffList.get(i).getUsername())) {
				if(password.equals(medStaffList.get(i).getPassword())) {
					currMedStaff = medStaffList.get(i);
					return PM = new PatientManager(currMedStaff, patientList);
				}
			}
		}
		
		
		return null;
	}
	
	public static PatientManager isPatientAccepted(String username, String password){ 
		int i;
		Patient currPatient = null;
		PatientManager PM;
		
		for(i = 0;i < patientList.size(); i++) {
			if(username.equals(patientList.get(i).getUsername())) {
				if(password.equals(patientList.get(i).getPassword())) {
					currPatient = patientList.get(i);
					PM = new PatientManager(currPatient, patientList);
					return PM;
				}
			}
		}
		
		return null;
	}
	
}
