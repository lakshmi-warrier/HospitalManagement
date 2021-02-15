package Project.src;

import java.util.*;

public class Hospital {
    public static void main() 
    {
        System.out.println("Which category do you want to choose?\n1. Doctor\n2. Patient\n3. Nurse\n4. Equipment\n5. Medicine\n6. Patient Records\n7. Parking Lot");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        
        switch(choice)
        {
            case 1:
                System.out.println("Class by VUNDELA DEEPTHI SRI REDDY");
                Doctor.run();
                break;
            case 2: 
                System.out.println("Class by PAPPALA KUMAR ADITYA");
                Patient.run();
                break;
            case 3:
                 System.out.println("Class by LAKSHMI WARRIER");
                 Nurses.run();
                break;
            case 4:
                System.out.println("Class by JITHIN JOHN");
                Equipment.run();
                break;
            case 5:
                System.out.println("Class by ANVITA REDDY INTURE");
                Medicines.run();
                break;
                
            case 6:
                System.out.println("Class by N ABHINAY REDDY");
                PatientRecord.run();
                break;
                
            case 7:
                System.out.println("Class by N MONEESH");
                try {
                    ParkingLot.run();
                } catch (Exception e) {
                }
                break;
            default: 
                System.out.println("Invalid Choice");
        }
    }
}
