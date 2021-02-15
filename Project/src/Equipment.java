package Project.src;

//Contributed By Jithin John
//AM.EN.U4AIE20135
//CSE(AI) | B - BATCH

import java.io.*;
import java.util.*;

class Equipment implements Serializable {

    int equipment_id;
    String equipment_name, equipment_technician, equipment_expiry, equipment_daily_limit;
    int equipment_room;
    int equipment_total_used = 0, equipment_success = 0, equipment_failure = 0;
    double equipment_power;

    static ArrayList<Equipment> EquipmentData = new ArrayList();
    static File f = new File("Equipment.dat");
    static ObjectOutputStream out = null;
    static Scanner sc = new Scanner(System.in);

    Equipment(int equipment_id, String equipment_name, String equipment_technician, String equipment_expiry,
            String equipment_daily_limit, int equipment_room, int equipment_total_used, int equipment_success,
            int equipment_failure, double equipment_power) {
        this.equipment_id = equipment_id;
        this.equipment_name = equipment_name;
        this.equipment_technician = equipment_technician;
        this.equipment_expiry = equipment_expiry;
        this.equipment_daily_limit = equipment_daily_limit;
        this.equipment_room = equipment_room;
        this.equipment_total_used = equipment_total_used;
        this.equipment_success = equipment_success;
        this.equipment_failure = equipment_failure;
        this.equipment_power = equipment_power;
    }

    static void add_equipment() {
        String equipment_name, equipment_technician, equipment_expiry, equipment_daily_limit;
        int equipment_room, equipment_id;
        int equipment_total_used = 0, equipment_success = 0, equipment_failure = 0;
        double equipment_power;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the ID of the Equipment:-");
        equipment_id = input.nextInt();
        System.out.print("Name of the Equipment :- ");
        equipment_name = input.nextLine();
        equipment_name = input.nextLine();
        System.out.print("Who is the technician of this Equipment? :- ");
        equipment_technician = input.nextLine();
        System.out.print("Enter the Expiry date of the Equipment(DD/MM/YYYY) :-");
        equipment_expiry = input.nextLine();
        System.out.print("Enter the daily limit of the Equipment(HH:MM) :-");
        equipment_daily_limit = input.nextLine();
        System.out.print("Enter the power of the equipment (in kWh) :-");
        equipment_power = input.nextDouble();
        System.out.print("Enter the room number where it is placed :-");
        equipment_room = input.nextInt();

        Equipment Newequipment = new Equipment(equipment_id, equipment_name, equipment_technician, equipment_expiry,
                equipment_daily_limit, equipment_room, equipment_total_used, equipment_success, equipment_failure,
                equipment_power);
        EquipmentData.add(Newequipment);
    }

    static void update_usage_equipment() {
        System.out.println("Enter ID of the equipment to be updated in usage: ");
        int id = sc.nextInt();

        for (Equipment equipment : EquipmentData) {
            if (equipment.equipment_id == id) {
                String equipment_name, equipment_technician, equipment_expiry, equipment_daily_limit;
                int equipment_id, equipment_room;
                int equipment_total_used = 0, equipment_success = 0, equipment_failure = 0;
                double equipment_power;
                Scanner input = new Scanner(System.in);
                Equipment oldequipment = equipment;
                EquipmentData.remove(oldequipment);
                equipment_id = equipment.equipment_id;
                equipment_name = equipment.equipment_name;
                equipment_technician = equipment.equipment_technician;
                equipment_expiry = equipment.equipment_expiry;
                equipment_daily_limit = equipment.equipment_daily_limit;
                equipment_power = equipment.equipment_power;
                equipment_room = equipment.equipment_room;
                System.out.println("How many times were the Equipment used since last Update?");
                int times, result;
                times = input.nextInt();
                System.out.print("How many times did it worked Successfully : ");
                result = input.nextInt();
                equipment_total_used = equipment.equipment_total_used + times;
                equipment_success = equipment.equipment_success + result;

                Equipment Newequipment = new Equipment(equipment_id, equipment_name, equipment_technician,
                        equipment_expiry, equipment_daily_limit, equipment_room, equipment_total_used,
                        equipment_success, equipment_failure, equipment_power);

                EquipmentData.add(Newequipment);
            }
        }
    }

    static void discard_equipment() {
        System.out.println("Enter ID of the equipment to be discarded");
        int id = sc.nextInt();

        for (Equipment equipment : EquipmentData) {
            if (equipment.equipment_id == id) {
                String equipment_name, equipment_technician, equipment_expiry, equipment_daily_limit;
                int equipment_id, equipment_room;
                int equipment_total_used = 0, equipment_success = 0, equipment_failure = 0;
                double equipment_power;
                Scanner input = new Scanner(System.in);
                Equipment oldequipment = equipment;
                EquipmentData.remove(oldequipment);
                equipment_id = equipment.equipment_id;
                equipment_name = equipment.equipment_name;
                equipment_technician = "Discarded";
                equipment_expiry = "Discarded";
                equipment_daily_limit = "Discarded";
                equipment_power = 0.0;
                equipment_room = 0;
                equipment_total_used = 0;
                equipment_success = 0;

            }
        }
    }

    static void update_equipment() {
        System.out.println("Enter ID of the equipment to be updated");
        int id = sc.nextInt();

        for (Equipment equipment : EquipmentData) {
            if (equipment.equipment_id == id) {
                String equipment_name, equipment_technician, equipment_expiry, equipment_daily_limit;
                int equipment_id, equipment_room;
                int equipment_total_used = 0, equipment_success = 0, equipment_failure = 0;
                double equipment_power;
                Scanner input = new Scanner(System.in);
                Equipment oldequipment = equipment;
                EquipmentData.remove(oldequipment);
                System.out.println("Enter new details ");
                System.out.print("Enter the ID of the Equipment:-");
                equipment_id = input.nextInt();
                System.out.print("Name of the Equipment :- ");
                equipment_name = input.nextLine();
                equipment_name = input.nextLine();
                System.out.print("Who is the technician of this Equipment? :- ");
                equipment_technician = input.nextLine();
                System.out.print("Enter the Expiry date of the Equipment(DD/MM/YYYY) :-");
                equipment_expiry = input.nextLine();
                System.out.print("Enter the daily limit of the Equipment(HH:MM) :-");
                equipment_daily_limit = input.nextLine();
                System.out.print("Enter the power of the equipment (in kWh) :-");
                equipment_power = input.nextDouble();
                System.out.print("Enter the room number where it is placed :-");
                equipment_room = input.nextInt();
                equipment_success = equipment.equipment_success;
                equipment_total_used = equipment.equipment_total_used;
                Equipment Newequipment = new Equipment(equipment_id, equipment_name, equipment_technician,
                        equipment_expiry, equipment_daily_limit, equipment_room, equipment_total_used,
                        equipment_success, equipment_failure, equipment_power);

                EquipmentData.add(Newequipment);
            }
        }
    }

    static ArrayList<Equipment> getEquipmentData() {
        return EquipmentData;
    }

    static void writeData() {
        try {
            out = new ObjectOutputStream(new FileOutputStream(f));
            for (Equipment i : EquipmentData)
                out.writeObject(i);

            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return ("\n" + equipment_id + "\t" + equipment_name + "\t\t" + equipment_technician + "\t\t\t"
                + equipment_expiry + "\t\t" + equipment_daily_limit + "  \t\t" + equipment_power + "\t\t"
                + equipment_room + "\t\t" + equipment_total_used + "\t\t" + equipment_success);
    }

    public static void run() {
        int c = 1;
        File f = new File("Equipment.dat");
        Scanner sc = new Scanner(System.in);
        try {
            ObjectInputStream read = new ObjectInputStream(new FileInputStream(f));
            while (true) {

                Equipment.EquipmentData.add((Equipment) read.readObject());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        do {
            System.out.println(
                    "Enter choice: \n1.Detailed list of all Equipments\n2.Add a new equipment to the Hospital\n3.Update Usage Information of an equipment\n4.Update Equipment Details\n5.Discard Equipment from the Hospital\n");
            System.out.println("Press 0 to exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println(
                            "id \t Name\t\t\tTechnician\t\tExpiry\t\tWorking Limit \t\tPower\t   Room No: \t     Total used \tSuccess");
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println(Equipment.EquipmentData);
                    break;
                case 2:
                    Equipment.add_equipment();
                    break;

                case 3:
                    Equipment.update_usage_equipment();
                    break;

                case 4:
                    Equipment.update_equipment();
                    break;

                case 5:
                    Equipment.discard_equipment();
                    break;

                default:
                    System.out.println("Invalid choice");
            }

            Equipment.writeData();
            System.out.println("\n");
        } while (c == 1);
    }

}
