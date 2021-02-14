//Contributed By GURRAM KUMAR SAI 
//AM.EN.U4AIE20131
//CSE(AI) | B - BATCH

package Project.src;

import java.io.*;
import java.util.*;

public class receptionist implements Serializable {
	String name, gender, qualification, mobilenumber;
	int id, age;
	double salary, working_hours;
	static ArrayList<receptionist> receptionistList = new ArrayList();
	static File f = new File("receptionist.dat");
	static ObjectOutputStream out = null;
	static Scanner scan = new Scanner(System.in);

	receptionist(String name, String gender, int age, String qualification, String mobilenumber, int Age, int id,
			double salary, double working_hours) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.qualification = qualification;
		this.mobilenumber = mobilenumber;
		this.id = id;
		this.salary = salary;
		this.working_hours = working_hours;
	}

	static void add_receptionist() {
		System.out.println(
				"Enter the String name:" + ",String gender:" + ",String qualification:,String mobilenumber\r\n:"
						+ "int age:,int id:,double salary:,double working_hours:");
		String name = scan.next();
		String gender = scan.next();
		String qualification = scan.next();
		String mobilenumber = scan.next();
		int age = scan.nextInt();
		int id = scan.nextInt();
		double salary = scan.nextDouble();
		double working_hours = scan.nextDouble();
		for (receptionist receptionist : receptionistList) {
			if (receptionist.id == id)
				System.out.println("receptionist with the id " + id + " already exists. Name: " + receptionist.name);
		}
		receptionist Newreceptionist = new receptionist(name, gender, age, qualification, mobilenumber, id, id, salary,
				working_hours);
		receptionistList.add(Newreceptionist);

	}

	static void delete_receptionist(int id) {
		for (receptionist receptionist : receptionistList) {
			if (receptionist.id == id)
				receptionistList.remove(receptionist);
		}
	}

	static void edit_receptionist() {
		System.out.println("Enter ID of the receptionist to be updated");
		int id = scan.nextInt();
		for (receptionist receptionist : receptionistList) {
			if (receptionist.id == id) {
				System.out.println("receptionist with id " + id + " already exists. Name: " + receptionist.name);

				receptionist oldreceptionist = receptionist;
				System.out.println("Enter new details of the receptionist ");
				System.out.println("String name,String gender,String qualification,String mobilenumber,"
						+ "int age,int id,double salary,double working_hours");
				String name = scan.next();
				String gender = scan.next();
				String qualification = scan.next();
				String mobilenumber = scan.next();
				int age = scan.nextInt();
				double salary = scan.nextDouble();
				double working_hours = scan.nextDouble();
				receptionist Newreceptionist = new receptionist(name, gender, age, qualification, mobilenumber, id, age,
						salary, working_hours);
				receptionistList.remove(oldreceptionist);
				receptionistList.add(Newreceptionist);
			}
		}
	}

	static void writeData() {
		try {
			out = new ObjectOutputStream(new FileOutputStream(f));
			for (receptionist i : receptionistList)
				out.writeObject(i);

			out.close();

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void greet_user() {
		System.out.println(
				"Welcome to this hospital, what section do you wish to choose?\n1. Reception admin\n2. Others");

	}

	public String toString() // overriding the toString() method of Serializable interface
	{
		return "\n{id: " + id + ", name:" + name + ",gender: " + gender + ",age:" + age + ", qualification: "
				+ qualification

				+ ",mobilenumber:" + mobilenumber + ",working_hours:" + working_hours + ", salary: " + salary + "}";
	}

	public static void main(String[] args) {
		greet_user();
		int user_choice = scan.nextInt();
		if (user_choice != 1)
		//Hospital.main handles navigating to other class methods	
			Hospital.main();
		else {

			File f = new File("receptionist.dat");
			try {
				ObjectInputStream read = new ObjectInputStream(new FileInputStream(f));
				receptionistList.clear();
				while (true) {
					receptionistList.add((receptionist) read.readObject());
				}
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found");
			} catch (IOException e) {
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println(
					"Enter choice: \n1.View receptionist\n2.Add receptionist\n3.Delete receptionist\n4.edit receptionist");
			int choice = scan.nextInt();
			switch (choice) {
				case 1:
					System.out.println(receptionistList);
					break;
				case 2:
					add_receptionist();
					break;
				case 3:
					System.out.print("Enter ID of the receptionist to be deleted");
					delete_receptionist(scan.nextInt());
					break;
				case 4:
					edit_receptionist();
					break;
				default:
					System.out.println("Invalid choice");
			}
			writeData();
		}

	}
}
