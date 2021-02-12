package Project.src;

import java.io.*;
import java.util.*;

public class Medicines implements Serializable {
	String name, brand, type, composition,  description,dose;
	int id; 
	double cost;
	
	static ArrayList<Medicines> medicineList=new ArrayList<Medicines>();
	static File f=new File("medicines.dat");
	static ObjectOutputStream out=null;
	static Scanner ob=new Scanner(System.in);
	
	Medicines(String name,String brand,String type,String composition,String description,String dose,
			int id, double cost){
		this.name=name;
		this.brand=brand;
		this.composition=composition;
		this.type=type;
		this.description=description;
		this.id=id;
		this.dose=dose;
		this.cost=cost;
	}
	static void addMedicines() {
		System.out.println("Enter Medicine Name:");
		String name=ob.nextLine();
		System.out.println("Enter Medicine ID:");
		int ID=ob.nextInt();
		ob.nextLine();
		System.out.println("Enter Brand:");
		String brand=ob.nextLine();
		System.out.println("Enter Type:");
		String type=ob.nextLine();
		System.out.println("Enter Composition:");
		String composition=ob.nextLine();
		System.out.println("Enter Description:");
		String description=ob.nextLine();
		System.out.println("Enter Dose:");
		String dose=ob.nextLine();
		System.out.println("Enter cost:");
		double cost=ob.nextDouble();
		boolean flag=true;
		for(Medicines i : medicineList) {
			if(i.id == ID) {
				flag=false;
				break;	
			}
		}
		if(flag==true) {
			Medicines newMedicine=new Medicines(name,brand,type,composition,description,dose,ID,cost);
			medicineList.add(newMedicine);
		}
		else
			System.out.println("Medicine with id "+ID+" already exists.");
	}
	static void editMedicines() {
		System.out.println("Enter Medicine ID to edit:");
		int ID=ob.nextInt();
		for(Medicines i : medicineList) {
			if(i.id == ID) {
				System.out.println("Enter new details...");
				System.out.println("Enter Medicine Name:");
				ob.nextLine();
				i.name=ob.nextLine();
				System.out.println("Enter Medicine ID:");
				i.id=ob.nextInt();
				ob.nextLine();
				System.out.println("Enter Brand:");
				i.brand=ob.nextLine();
				System.out.println("Enter Type:");
				i.type=ob.nextLine();
				System.out.println("Enter Composition:");
				i.composition=ob.nextLine();
				System.out.println("Enter Description:");
				i.description=ob.nextLine();
				System.out.println("Enter Dose:");
				i.dose=ob.nextLine();
				System.out.println("Enter cost:");
				i.cost=ob.nextDouble();
			}
			else System.out.println("Medicine not found");
		}
	}
	static void deleteMedicines(int ID) {
		ArrayList<Medicines> toRemove=new ArrayList<Medicines>();
		boolean flag=false;
		for(Medicines i : medicineList) {
			if(i.id == ID) {
				toRemove.add(i);
				flag=true;
				System.out.println("Medicine deleted.");
				break;
			}
		}
		if(flag==true)
			medicineList.removeAll(toRemove);
		else System.out.println("Medicine not found.");
	}
	static void updateMedicines() {
		Medicines.editMedicines();
	}
	static void searchMedicines() {
		System.out.println("Enter Medicine ID to search:");
		int ID=ob.nextInt();
		for(Medicines i : medicineList) {
			if(i.id == ID) {
				System.out.println(i.toString());
				break;
			}
			else System.out.println("Medicine not found");
		}
		
	}
	static ArrayList<Medicines> getMedicineList() {
		return medicineList;
	}
	static void writeData() {
		try {
			out=new ObjectOutputStream(new FileOutputStream(f));
			out.flush();
			for(Medicines i : medicineList) {
				out.writeObject(i);
				}
			out.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File does not exist.");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public String toString() {
		return "\nName: "+name+"\nID: "+id+"\nBrand: "+brand+", Type: "+type+
				",\nComposition: "+composition+"\nDescription: "+description+
				"\nDose: "+dose+"\nCost: Rs."+cost+" per unit\n";
	}
	public static void main(String args[]) {
		File f=new File("medicines.dat");
		Scanner ob=new Scanner(System.in);
		try {
			ObjectInputStream read=new ObjectInputStream(new FileInputStream(f));
			while(true) {
				Medicines.medicineList.add((Medicines)read.readObject());
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File does not exist. It is now created.");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {}
		
		System.out.println("Enter your choice: ");
		System.out.println("1. Display Medicines\n2. Add Medicines\n3. Edit Medicines\n4. Delete Medicines\n5. Search Medicine");
		int ch=ob.nextInt();
		switch(ch) {
		case 1:
			//System.out.println(Medicines.medicineList);
			for(Medicines i: medicineList) {
				System.out.println(i.toString());
			}
			break;
		case 2:
			Medicines.addMedicines();
			break;
		case 3:
			Medicines.updateMedicines();
			break;
		case 4:
			System.out.println("Enter Medicine ID:");
			Medicines.deleteMedicines(ob.nextInt());
			break;
		case 5:
			Medicines.searchMedicines();
			break;
		default: System.out.println("Invalid Choice");
		}
		Medicines.writeData();
		ob.close();
	}
}