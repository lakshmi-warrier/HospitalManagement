package Project.src;

import java.io.*;
import java.util.*;

public class PatientRecord implements Serializable {
    String name, bloodGroup;
    int id, bedNumber, visitorsVisited;
    double bedCharges, foodCharges, duration;
    static ArrayList<PatientRecord> PatientRecordList = new ArrayList();
    static File f = new File("PatientRecord.dat");
    static ObjectOutputStream out = null;
    static Scanner scan = new Scanner(System.in);

    PatientRecord(String name, String bloodGroup, int bedNumber, int visitorsVisited, int id, double bedCharges,
            double foodCharges, double duration) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.bedNumber = bedNumber;
        this.visitorsVisited = visitorsVisited;

        this.id = id;
        this.bedCharges = bedCharges;
        this.foodCharges = foodCharges;
        this.duration = duration;
    }

    static void add_PatientRecord() {
        System.out.println("Enter the String name:" + ",String bloodGroup:" + ",double visitorsVisited:, \r\n:"
                + "int bedNumber:,int id:,double bedCharges:,double foodCharges:,  double duration");
        String name = scan.next();
        String bloodGroup = scan.next();
        int visitorsVisited = Integer.parseInt(scan.next());
        int bedNumber = Integer.parseInt(scan.next());
        int id = Integer.parseInt(scan.next());
        double bedCharges = Double.parseDouble(scan.next());
        double foodCharges = Double.parseDouble(scan.next());
        double duration = Double.parseDouble(scan.next());
        boolean present = false;
        for (PatientRecord PatientRecord : PatientRecordList) {
            if (PatientRecord.id == id) {
                System.out.println("PatientRecord with the id " + id + " already exists. Name: " + PatientRecord.name);
                present = true;
                break;
            }
        }
        if (present == false) {
            PatientRecord NewPatientRecord = new PatientRecord(name, bloodGroup, bedNumber, visitorsVisited, id,
                    bedCharges, foodCharges, duration);
            PatientRecordList.add(NewPatientRecord);
        }
    }

    static void delete_PatientRecord(int id) {
        for (PatientRecord PatientRecord : PatientRecordList) {
            if (PatientRecord.id == id)
                PatientRecordList.remove(PatientRecord);
        }
    }

    static void edit_PatientRecord() {
        System.out.println("Enter ID of the PatientRecord to be updated");
        int id = Integer.parseInt(scan.next());
        for (PatientRecord PatientRecord : PatientRecordList) {
            if (PatientRecord.id == id) {
                System.out.println("PatientRecord with id " + id + " xists. Name: " + PatientRecord.name);
                PatientRecord oldPatientRecord = PatientRecord;
                System.out.println("Enter new details of the PatientRecord ");
                System.out.println("String name,String bloodGroup,String visitorsVisited,"
                        + "int bedNumber,int id,double bedCharges,double foodCharges,double duration");
                String name = scan.next();
                String bloodGroup = scan.next();
                int visitorsVisited = Integer.parseInt(scan.next());
                int bedNumber = Integer.parseInt(scan.next());

                double bedCharges = Double.parseDouble(scan.next());
                double foodCharges = Double.parseDouble(scan.next());
                double duration = Double.parseDouble(scan.next());
                PatientRecord NewPatientRecord = new PatientRecord(name, bloodGroup, bedNumber, visitorsVisited, id,
                        bedCharges, foodCharges, duration);
                PatientRecordList.remove(oldPatientRecord);
                PatientRecordList.add(NewPatientRecord);
            }
        }
    }

    static void writeData() {
        try {
            out = new ObjectOutputStream(new FileOutputStream(f));
            for (PatientRecord i : PatientRecordList)
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
        return "\n{id: " + id + ", name:" + name + ",bloodGroup: " + bloodGroup + ",bedNumber:" + bedNumber
                + ", visitorsVisited: " + visitorsVisited

                + ", foodCharges:" + foodCharges + ",duration: " + duration + ", bedCharges: " + bedCharges + "}";
    }

    public static void run() {
        // TODO Auto-generated method stub
        File f = new File("PatientRecord.dat");
        try {
            ObjectInputStream read = new ObjectInputStream(new FileInputStream(f));
            PatientRecordList.clear();
            while (true) {
                PatientRecordList.add((PatientRecord) read.readObject());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(
                "Enter choice: \n1.View PatientRecord\n2.Add PatientRecord\n3.Delete PatientRecord\n4.edit PatientRecord");

        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println(PatientRecordList);
                break;
            case 2:
                add_PatientRecord();
                break;
            case 3:
                System.out.print("Enter ID of the PatientRecord to be deleted");
                delete_PatientRecord(scan.nextInt());
                break;
            case 4:
                edit_PatientRecord();
                break;
            default:
                System.out.println("Invalid choice");
        }
        writeData();
    }

}