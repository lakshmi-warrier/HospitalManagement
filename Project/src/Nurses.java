//Contributed By Lakshmi Warrier
//AM.EN.U4AIE20143
//CSE(AI) | B - BATCH

package Project.src;

import java.io.*;
import java.util.*;

class Nurses implements Serializable {

    String name, gender, qualification, current_dept;
    int id, duty_shift;
    double workexp, salary;
    boolean is_senior;

    static ArrayList<Nurses> nurseList = new ArrayList();
    static File f = new File("nurses.dat");
    static ObjectOutputStream out = null;
    static Scanner sc = new Scanner(System.in);

    Nurses(String name, String gender, String qualification, String current_dept, int id, int duty_shift,
            double workexp, double salary, boolean is_senior) {
        this.name = name;
        this.gender = gender;
        this.qualification = qualification;
        this.current_dept = current_dept;
        this.id = id;
        this.duty_shift = duty_shift;
        this.workexp = workexp;
        this.salary = salary;
        this.is_senior = is_senior;
    }

    static void create_patient_record() {
        PatientRecord.create_record(sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
    }

    static void view_patient_record() {
        // creates patient record object and use show_record() function or prints the
        // object that I will get from there
    }

    static void add_nurse() {
        System.out.println(
                "Enter String name, String gender,String qualification,String current_dept, int id,int duty_shift, double workexp, double salary, boolean is_senior");

        // get inputs

        String name = sc.next();
        String gender = sc.next();
        String qualification = sc.next();
        String current_dept = sc.next();
        int id = sc.nextInt();
        int duty_shift = sc.nextInt();
        double workexp = sc.nextDouble();
        double salary = sc.nextDouble();
        Boolean is_senior = sc.nextBoolean();

        for (Nurses nurse : nurseList) {
            // no two nurse can have same ID
            if (nurse.id == id)
                System.out.println("Nurse with id " + id + " already exists. Name: " + nurse.name);

        }
        Nurses NewNurse = new Nurses(name, gender, qualification, current_dept, id, duty_shift, workexp, salary,
                is_senior);
        nurseList.add(NewNurse);
    }

    static void delete_nurse(int id) {
        for (Nurses nurse : nurseList) {
            if (nurse.id == id)
                nurseList.remove(nurse);
        }
    }

    static void update_nurse() {
        System.out.println("Enter ID of the nurse to be updated");
        // get inputs
        int id = sc.nextInt();

        for (Nurses nurse : nurseList) {
            // no two nurse can have same ID
            if (nurse.id == id) {
                System.out.println("Nurse with id " + id + " already exists. Name: " + nurse.name);
                Nurses oldNurse = nurse;
                System.out.println("Enter new details ");
                System.out.println(
                        "String name, String gender,String qualification,String current Dept.,int duty shift, double work exp, double salary, boolean is_senior");
                String name = sc.next();
                String gender = sc.next();
                String qualification = sc.next();
                String current_dept = sc.next();
                int duty_shift = sc.nextInt();
                double workexp = sc.nextDouble();
                double salary = sc.nextDouble();
                Boolean is_senior = sc.nextBoolean();

                Nurses NewNurse = new Nurses(name, gender, qualification, current_dept, id, duty_shift, workexp, salary,
                        is_senior);
                nurseList.remove(oldNurse);
                nurseList.add(NewNurse);
            }
        }
    }

    void get_vitals() {
        // patient.temp, patient.bp, patient.pulserate, patient.resprate
    }

    void set_vitals() {

        // patient.temp, patient.bp, patient.pulserate, patient.resprate
    }

    void change_bed() {
        // patient.bed = "new bed"
    }

    static ArrayList<Nurses> getNurseList() {
        return nurseList;
    }

    static void writeData() {
        try {
            out = new ObjectOutputStream(new FileOutputStream(f));
            for (Nurses i : nurseList)
                out.writeObject(i);

            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void use_equip(int id)
    {
        
    }

    public String toString() // overriding the toString() method of Serializable interface
    {
        return "\n{id: " + id + ", name:" + name + ", Gender: " + gender + ", qualification: " + qualification
                + ", current_dept: " + current_dept + ", duty_shift: " + duty_shift + ", workexp: " + workexp
                + ", salary: " + salary + ", is_senior: " + is_senior + "}";
    }

    public static void main() {
        File f = new File("nurses.dat");
        Scanner sc = new Scanner(System.in);
        try {
            ObjectInputStream read = new ObjectInputStream(new FileInputStream(f));

            // Nurses.nurseList.clear();
            while (true) {

                Nurses.nurseList.add((Nurses) read.readObject());// automatically breaks when it reaches EOF as the
                                                                 // exception is caught
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(
                "Enter choice: \n1.View Nurse\n2.Add Nurse\n3.Delete Nurse\n4.Update Nurse\n5.View Patient Record\n6.Create Patient Record\n7.Edit Patient Record\n8. Use equipment");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println(Nurses.nurseList);

                break;
            case 2:
                Nurses.add_nurse();
                break;

            case 3:
                System.out.print("Enter ID of the nurse to be deleted");
                Nurses.delete_nurse(sc.nextInt());
                break;

            case 4:
                Nurses.update_nurse();
                break;
            case 5, 6, 7:
                break; // will add later
            
            case 8:
                int equip_id = sc.nextInt();
                use_equip(equip_id);
                break;

            default:
                System.out.println("Invalid choice");
        }
        Nurses.writeData();
    }

}
