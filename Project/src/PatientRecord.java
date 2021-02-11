package Project.src;

import java.util.*;

public class PatientRecord {
    int Patient_id;
    String Patient_name;
    double Patient_bed_charges;
    String Patient_blood_group;
    double Patient_food_charges;
    int Patient_number_of_visitors;
    double Patient_duration_in_hospital;
    static ArrayList<PatientRecord> Patient_Record = new ArrayList();
    
    PatientRecord(int Patient_id,String Patient_name,String Patient_blood_group,int Patient_number_of_visitors,double Patient_duration_in_hospital)
    {
        this.Patient_id=Patient_id;
        this.Patient_name=Patient_name;
        this.Patient_blood_group=Patient_blood_group;
        this.Patient_number_of_visitors=Patient_number_of_visitors;
        this.Patient_duration_in_hospital=Patient_duration_in_hospital;
        this.Patient_bed_charges=Patient_duration_in_hospital*500;
        this.Patient_food_charges=Patient_duration_in_hospital*200;
    }
    public static PatientRecord PatientRecord[]=new PatientRecord[100];
    static int index=0;
    static void create_record(int Patient_id,String Patient_name,String Patient_blood_group,int Patient_number_of_visitors,double Patient_duration_in_hospital)
    {
        PatientRecord new_record=new PatientRecord(Patient_id,Patient_name,Patient_blood_group,Patient_number_of_visitors, Patient_duration_in_hospital);
        PatientRecord[index]=new_record;
        index++;
    }
    static void delete_record(int patient_id)
    {
        int i;
        for(i=0;i<PatientRecord.length;i++)
        {
            if(patient_id==PatientRecord[i].Patient_id)
            {
                break;
            }
        }
        if(PatientRecord.length==i)
            System.out.println("cannot find record with id "+patient_id);
        
        else
            {
                for(;i<PatientRecord.length-1;i++)
                    PatientRecord[i]=PatientRecord[i+1];
                PatientRecord[i]=null;
                index--;
            }
    }
    static void update_record(int patient_id)
    {
        int i;
        for(i=0;i<PatientRecord.length;i++)
        {
            if(patient_id==PatientRecord[i].Patient_id)
            {
                break;
            }
        }
        if(PatientRecord.length==i)
            System.out.println("cannot find record with id "+patient_id);
        else
        {
            Scanner scan=new Scanner(System.in);
            System.out.println("enter 1 to update Patient name, any number to continue");
            int choice=scan.nextInt();
            if(choice==1)
            {
                System.out.println("enter patient name");
                scan.nextLine();
                PatientRecord[i].Patient_name=scan.nextLine();
            }
            System.out.println("enter 1 to update Patient blood group, any number to continue");
            choice=scan.nextInt();
            if(choice==1)
            {
                System.out.println("enter patient blood group");
                scan.nextLine();
                PatientRecord[i].Patient_blood_group=scan.nextLine();
            }
            System.out.println("enter 1 to update Patient number of visitors,any number to continue");
            choice=scan.nextInt();
            if(choice==1)
            {
                System.out.println("enter patient number of visitors");
                PatientRecord[i].Patient_number_of_visitors=scan.nextInt();
            }
            System.out.println("enter 1 to update Patient duration in hospital, any number to continue");
            choice=scan.nextInt();
            if(choice==1)
            {
                System.out.println("enter patient duration in hospital");
                PatientRecord[i].Patient_duration_in_hospital=scan.nextDouble();
            }
            
            PatientRecord[i].Patient_bed_charges=PatientRecord[i].Patient_duration_in_hospital*500;
            PatientRecord[i].Patient_food_charges=PatientRecord[i].Patient_duration_in_hospital*200;
        }
    }
    static void view_all_records()
    {
        for(int j=0;j<index;j++)
            System.out.println(PatientRecord[j].Patient_id+" "+PatientRecord[j].Patient_name+" "+PatientRecord[j].Patient_blood_group+" "+PatientRecord[j].Patient_duration_in_hospital+" "+PatientRecord[j].Patient_bed_charges+" "+PatientRecord[j].Patient_food_charges);
        
    }
    
    static ArrayList<PatientRecord> getPatients()
    {
        return Patient_Record;
    }    /*public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(true)
        {
            System.out.println("enter 1 to create record\n2 to delete record\n3 to update record\n4 to view all records");
            int choice=scan.nextInt();
            switch(choice)
            {
            case 1: 
                System.out.println("enter id");
                int id=scan.nextInt();
                scan.nextLine();
                System.out.println("enter name");
                String name=scan.nextLine();
                System.out.println("enter blood group");
                String bloodGroup=scan.nextLine();
                System.out.println("enter number of visitors");
                int numberOfVisitors=scan.nextInt();
                System.out.println("enter duration");
                double PatientDurationInHospital=scan.nextDouble();
                create_record(id,name,bloodGroup, numberOfVisitors,PatientDurationInHospital);
                break;
            case 2:
                System.out.println("enter id");
                id=scan.nextInt();
                delete_record(id);
                break;
            case 3:
                System.out.println("enter id");
                id=scan.nextInt();
                update_record(id);
                break;
            case 4:
                view_all_records();
            }
        }
    }*/

 

}