//Contributed By VUNDELA DEEPTHI SRI REDDY 
//AM.EN.U4AIE20174
//CSE(AI) | B - BATCH

package Project.src;

import java.io.*;
import java.util.*;

public class Doctor implements Serializable {
	String name, email, username, password, qualification, specialist, mobilenumber, address;
	int id;
	double salary;

	static ArrayList<Doctor> doctorList = new ArrayList();
	static File f = new File("doctor.dat");
	static ObjectOutputStream out = null;
	static Scanner sc = new Scanner(System.in);

	Doctor(String name, String email, String username, String password, String qualification, String specialist,
			String mobilenumber, String address, int id, double salary) {
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.qualification = qualification;
		this.specialist = specialist;
		this.mobilenumber = mobilenumber;
		this.address = address;
		this.id = id;
		this.salary = salary;
	}

	static void add_doctor() {
		System.out.println("Enter String name,String email,String username,String password,String qualification,\r\n"
				+ "	    		String specialist,String mobilenumber,String address,int id,double salary");
		// for getting inputs
		String name = sc.next();
		String email = sc.next();
		String username = sc.next();
		String password = sc.next();
		String qualification = sc.next();
		String specialist = sc.next();
		String mobilenumber = sc.next();
		String address = sc.next();
		int id = sc.nextInt();
		double salary = sc.nextDouble();
		for (Doctor doctor : doctorList) {
			// no two doctor can have same ID
			if (doctor.id == id)
				System.out.println("doctor with id " + id + " already exists. Name: " + doctor.name);
		}
		Doctor Newdoctor = new Doctor(name, email, username, password, qualification, specialist, mobilenumber, address,
				id, salary);
		doctorList.add(Newdoctor);

		System.out.println(doctorList);
	}

	static void delete_doctor(int id) {
		for (Doctor doctor : doctorList) {
			if (doctor.id == id)
				doctorList.remove(doctor);
		}
	}

	static void edit_doctor() {
		System.out.println("Enter ID of the doctor to be updated");
		// get inputs
		int id = sc.nextInt();
		for (Doctor doctor : doctorList) {
			// no two doctor can have same ID
			if (doctor.id == id) {
				System.out.println("doctor with id " + id + " already exists. Name: " + doctor.name);
				Doctor olddoctor = doctor;
				System.out.println("Enter new details ");
				System.out.println(
						"String name,String email,String username,String password,String qualification,String specialist,"
								+ "String address,int id,double salary");
				String name = sc.next();
				String email = sc.next();
				String username = sc.next();
				String password = sc.next();
				String qualification = sc.next();
				String specialist = sc.next();
				String mobilenumber = sc.next();
				String address = sc.next();

				double salary = sc.nextDouble();
				Doctor Newdoctor = new Doctor(name, email, username, password, qualification, specialist, mobilenumber,
						address, id, salary);
				doctorList.remove(olddoctor);
				doctorList.add(Newdoctor);
			}
		}
	}

	static void writeData() {
		try {
			out = new ObjectOutputStream(new FileOutputStream(f));
			for (Doctor i : doctorList)
				out.writeObject(i);

			out.close();

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String toString() // overriding the toString() method of Serializable interface
	{
		return "\n{id: " + id + ", name:" + name + ",email: " + email + ",username:" + username + ",password:"
				+ password + ", qualification: " + qualification

				+ ",specialist:" + specialist + ",mobilenumber:" + mobilenumber + ",address:" + address + ", salary: "
				+ salary + "}";
	}

	public static void run() {
		File f = new File("doctor.dat");
		try {
			ObjectInputStream read = new ObjectInputStream(new FileInputStream(f));

			while (true) {
				doctorList.add((Doctor) read.readObject());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Enter choice: \n1.View doctor\n2.Add doctor\n3.Delete doctor\n4.edit doctor");

		int choice = sc.nextInt();
		switch (choice) {
			case 1:
				System.out.println(doctorList);
				break;
			case 2:
				add_doctor();
				break;
			case 3:
				System.out.print("Enter ID of the doctor to be deleted");
				delete_doctor(sc.nextInt());
				break;
			case 4:
				edit_doctor();
				break;
			default:
				System.out.println("Invalid choice");
		}
		writeData();
	}
}
