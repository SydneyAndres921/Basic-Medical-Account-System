package medicalSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;

public class Report {
	public static void reportAscendingID(ArrayList<Patient> patientList) throws IOException {
		File f = new File("reportAscendingID.csv");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0;i < patientList.size(); ++i) {
			bw.write(patientList.get(i).formalString());
			bw.newLine();
		}
		bw.close();
		fw.close();
	}
	
	public static void reportAscendingName(ArrayList<Patient> patientList) throws IOException {
		File f = new File("reportAscendingName.csv");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		int i;
		int k = 0;
		
		for(i = 0;i < patientList.size() - 1; ++i) {
			for(int j = 0;j < patientList.size() - 1; ++j) {
				if(patientList.get(j).getName().charAt(0) > patientList.get(j + 1).getName().charAt(0)) {
					Collections.swap(patientList, j , j + 1);
				}
				else if(patientList.get(j).getName().charAt(0) == patientList.get(j + 1).getName().charAt(0)) {
					while (patientList.get(j).getName().charAt(k) == patientList.get(j + 1).getName().charAt(k)) {
						if(patientList.get(j).getName().charAt(k + 1) > patientList.get(j + 1).getName().charAt(k + 1)) {
							Collections.swap(patientList, j , j + 1);
						}
						++k;
					}
				}
				k = 0;
			}
		}
		
		for(i = 0;i < patientList.size(); ++i) {
			bw.write(patientList.get(i).formalString());
			bw.newLine();
		}
		bw.close();
		fw.close();
	}
	
	public static void reportAscendingEmail(ArrayList<Patient> patientList) throws IOException { 
		File f = new File("reportAscendingEmail.csv");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		int i;
		int k = 0;
		
		for(i = 0;i < patientList.size() - 1; ++i) {
			for(int j = 0;j < patientList.size() - 1; ++j) {
				if(patientList.get(j).getEmail().charAt(0) > patientList.get(j + 1).getEmail().charAt(0)) {
					Collections.swap(patientList, j , j + 1);
				}
				else if(patientList.get(j).getEmail().charAt(0) == patientList.get(j + 1).getEmail().charAt(0)) {
					while (patientList.get(j).getEmail().charAt(k) == patientList.get(j + 1).getEmail().charAt(k)) {
						if(patientList.get(j).getEmail().charAt(k + 1) > patientList.get(j + 1).getEmail().charAt(k + 1)) {
							Collections.swap(patientList, j , j + 1);
						}
						++k;
					}
				}
				k = 0;
			}
		}
		
		for(i = 0;i < patientList.size(); ++i) {
			bw.write(patientList.get(i).getEmail());
			bw.newLine();
		}
		bw.close();
		fw.close();
	}
	
	public static void reportUser(User user) throws IOException { 
		File f = new File("reportUser.csv");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		if (user instanceof Patient) {
			bw.write("patient," +  user.toString());
		}
		else {
			bw.write("medical staff," +  user.toString());
		}
		bw.close();
		fw.close();
	}

}
