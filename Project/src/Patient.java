package Project.src;

import java.util.*;

public class Patient {
    static ArrayList<Patient> patientList = new ArrayList();
    int id, age;
    String name, occ;

    static void brr() {
        patientList.add(new Patient("Me", "duh", 12, 34));
    }

    Patient(String name, String occ, int id, int age) {
        this.age = age;
        this.name = name;
        this.occ = occ;
        this.id = id;
    }

    public static void main(String[] args) {
        brr();
        brr();
        System.out.println(patientList);
    }

    public String toString() {
        return "\nname:" + name + ", Occupation: " + occ + ", id: " + id + ", age: " + age;
    }

    static ArrayList<Patient> getPatients() {
        return patientList;
    }
}
