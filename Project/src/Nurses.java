//Contributed By Lakshmi Warrier
//AM.EN.U4AIE20143
//CSE(AI) | B - BATCH

package Project.src;

import java.io.*;
import java.util.*;

class Nurses implements Serializable {

    String name, qualification, current_dept;
    char gender;
    int id, duty_shift;
    double workexp, salary;
    boolean is_senior;

    static ArrayList<Nurses> nurseList = new ArrayList();
    static File f = new File("nurses.dat");
    static ObjectOutputStream out = null;
    static Scanner sc = new Scanner(System.in);

    Nurses(String name, char gender, String qualification, String current_dept, int id, int duty_shift, double workexp,
            double salary, boolean is_senior) {
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

        Nurses NewNurse = acceptInp();
        System.out.println("Enter ID");
        int id = sc.nextInt();
        NewNurse.id = id;
        boolean can_add = true;

        for (Nurses nurse : nurseList) {
            // no two nurse can have same ID
            if (nurse.id == id) {
                can_add = false;
                System.out.println("Nurse with id " + id + " already exists. Name: " + nurse.name);
            }

        }
        if (can_add)
            nurseList.add(NewNurse);
    }

    static void delete_nurse(int id) {
        for (Nurses nurse : nurseList) {
            if (nurse.id == id)
                nurseList.remove(nurse);
        }
    }

    static Nurses acceptInp() {
        System.out.println("Enter details:\nName:");
        String name = sc.next();
        // String name, char gender,String qualification,String current Dept.,int duty
        // shift, double work exp, double salary, boolean is_senior
        System.out.println("\nGender[M/F]: ");
        char gender = sc.next().charAt(0);
        gender = Character.toUpperCase(gender);
        while (gender != 'M' && gender != 'F') {
            System.out.println("Enter either M or F");
            gender = sc.next().charAt(0);
        }
        System.out.println("Qualification: ");
        String qualification = sc.next();
        System.out.println("Current Department: ");
        String current_dept = sc.next();
        System.out.println("Duty Shift: ");
        int duty_shift = sc.nextInt();
        System.out.println("Work Experience: ");
        double workexp = sc.nextDouble();
        System.out.println("Salary P.A: ");
        double salary = sc.nextDouble();
        System.out.println("Is the nurse senior?[true/false]: ");
        Boolean is_senior = sc.nextBoolean();

        Nurses NewNurse = new Nurses(name, gender, qualification, current_dept, 0, duty_shift, workexp, salary,
                is_senior);

        return NewNurse;
    }

    static void update_nurse() {
        System.out.println("Enter ID of the nurse to be updated");
        int id = sc.nextInt();

        for (Nurses nurse : nurseList) {
            // no two nurse can have same ID
            if (nurse.id == id) {
                System.out.println("Id: " + id + "  Name: " + nurse.name);
                Nurses oldNurse = nurse;
                System.out.println("Enter new details ");

                Nurses NewNurse = acceptInp();
                NewNurse.id = id;// id is set to 0 in the method
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

    static void use_equip(int id) {

    }

    public String toString() // overriding the toString() method of Serializable interface
    {
        String seniority  = "Junior";
        if(is_senior)  seniority = "Senior ";

        return "\n" + id + " - " + name + "(" + gender + "), "+seniority+" \n" + qualification + ",  " + current_dept + ", "
                + workexp +" years"+ "\nDuty shift: " + duty_shift + ", Salary P.A: " + salary
                + "\n";
    }

    public static void run() {
        File f = new File("nurses.dat");
        Scanner sc = new Scanner(System.in);
        try {
            ObjectInputStream read = new ObjectInputStream(new FileInputStream(f));

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
