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
                Doctor.run();
                break;
            case 2: 
                Patient.run();
                break;
            case 3:
                 Nurses.run();
                break;
            case 4:
                //Equipment.main();
                break;
            case 5:

                Medicines.run();
                break;
            default: 
                System.out.println("Invalid Choice");
        }
    }
}
