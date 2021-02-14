//Contributed By PAPPALA KUMAR ADITYA 
//AM.EN.U4AIE20155
//CSE(AI) | B - BATCH

package Project.src;

import java.util.*;
import java.io.*;

public class Patient implements Serializable {
	String name;
	static String mobile;
	String email;
	String username;
	String password;
	String address;
	int id, bed;
	String bloodgroup;
	double  bloodpressure, temperature, pulserate, respirationrate;
	static ArrayList<Patient> patientList = new ArrayList();
	static File f = new File("patient.dat");
	static ObjectOutputStream out = null;
	static Scanner sc = new Scanner(System.in);

	Patient(String name, String mobile, String email, String username, String password, String address, int id, int bed,
			String bloodgroup, double bloodpressure, double temperature, double pulserate, double respirationrate) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.id = id;
		this.bed = bed;
		this.bloodgroup = bloodgroup;
		this.bloodpressure = bloodpressure;
		this.temperature = temperature;
		this.pulserate = pulserate;
		this.respirationrate = respirationrate;

	}

	public Patient(String name2, String mobile2, String email2, String username2, String password2, String address2) {
		// TODO Auto-generated constructor stub
	}

	public Patient(String name2, String mobile2, String email2, String username2, String password2, String address2,
			int id2, int bed2) {
		// TODO Auto-generated constructor stub
	}

	static void add_patient() {
		System.out.println(
				"please check your temperature,bloodpressure,bloodgroup,pulserate,respirationrate near the checking counter");
		System.out.println(
				"enter String name,String mobile,String email,String username,String password,String address,int id,int bed,String bloodgroup,double bloodpressure,double temperature,double pulserate,double respirationrate");
		String name = sc.next();
		String email = sc.next();
		String username = sc.next();
		String password = sc.next();
		String mobilenumber = sc.next();
		String address = sc.next();
		int id = sc.nextInt();
		int bed = sc.nextInt();
		String bloodgroup = sc.next();
		double bloodpressure = sc.nextDouble();
		double temperature = sc.nextDouble();
		double pulserate = sc.nextDouble();
		double respirationrate = sc.nextDouble();
		for (Patient patient : patientList) {
			if (patient.id == id)
				System.out.println("patient with id " + id + " already exists. Name: " + patient.name);
		}
		Patient Newpatient = new Patient(name, mobile, email, username, password, address, id, bed, bloodgroup,
				bloodpressure, temperature, pulserate, respirationrate);
		patientList.add(Newpatient);
	}

	static void delete_patient(int id) {
		for (Patient patient : patientList) {
			if (patient.id == id)
				patientList.remove(patient);
		}
	}

	static void edit_patient() {
		System.out.println("enter the id of patient which to be updated");
		int id = sc.nextInt();
		for (Patient patient : patientList) {
			if (patient.id == id) {
				System.out.println("patient with id " + id + " already exists. Name: " + patient.name);
				Patient oldpatient = patient;
				System.out.println("enter the new details of the patient");
				System.out.println("enter String name,String mobile,String email,String username,String password"
						+ "String address,int id,int bed,String bloodgroup,double bloodpressure,double temperature,double pulserate,double respirationrate");
				String name = sc.next();
				String email = sc.next();
				String username = sc.next();
				String password = sc.next();
				String mobilenumber = sc.next();
				String address = sc.next();
				int bed = sc.nextInt();
				String bloodgroup = sc.next();
				double bloodpressure = sc.nextDouble();
				double temperature = sc.nextDouble();
				double pulserate = sc.nextDouble();
				double respirationrate = sc.nextDouble();

				Patient Newpatient = new Patient(name, mobile, email, username, password, address, id, bed, bloodgroup,
						bloodpressure, temperature, pulserate, respirationrate);
				patientList.remove(oldpatient);
				patientList.add(Newpatient);
			}
		}
	}

	static void writeData() {
		try {
			out = new ObjectOutputStream(new FileOutputStream(f));
			for (Patient i : patientList)
				out.writeObject(i);
			out.close();

		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String toString() // overriding the toString() method of Serializable interface
	{
		return "\n{id: " + id + ", name:" + name + ",email: " + email + ",username:" + username + ",password:"
				+ password + ",mobile:" + mobile + ",address:" + address + ",bed:" + bed + ",bloodgroup:" + bloodgroup
				+ ",bloodpressure:" + bloodpressure + ",temperature:" + temperature + ",pulserate:" + pulserate
				+ ",respirationrate:" + respirationrate + " }";

	}

	public static void run() {
		File f = new File("patient.dat");
		try {
			ObjectInputStream read = new ObjectInputStream(new FileInputStream(f));
			patientList.clear();
			while (true) {
				patientList.add((Patient) read.readObject());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Enter choice: \n1.View patient\n2.Add patient\n3.Delete patient\n4.edit patient");
		int choice = sc.nextInt();
		switch (choice) {
			case 1:
				System.out.println(patientList);
				break;
			case 2:
				add_patient();
				break;
			case 3:
				System.out.println("enter the id of the patient to be deleted");
				delete_patient(sc.nextInt());
				break;
			case 4:
				edit_patient();
				break;
			default:
				System.out.println("Invalid choice");
		}
		writeData();
	}
}
