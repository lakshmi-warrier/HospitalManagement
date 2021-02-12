//Contributed By Jithin John
//AM.EN.U4AIE20135
//CSE(AI) | B - BATCH
import java.io.*;
import java.util.*;
//import java.util.Calendar;
package Project.src;

class Equipment {
    String equipment_id, equipment_name, equipment_technician, equipment_expiry, equipment_daily_limit;
    int equipment_room, equipment_total_used, equipment_success, equipment_failure;
    double equipment_power;

    void new_equipment() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the ID of the Equipment:-");
        equipment_id = input.nextLine();
        System.out.print("Name of the Equipment :- ");
        equipment_name = input.nextLine();
        System.out.print("Who is the technician of this Equipment? :- ");
        equipment_technician = input.nextLine();
        System.out.print("Enter the Expiry date of the Equipment(DD/MM/YYYY) :-");
        equipment_expiry = input.nextLine();
        System.out.print("Enter the daily limit of the Equipment(HH:MM) :-");
        equipment_daily_limit = input.nextLine();

        System.out.print("Enter the power of the equipment (in kWh) :-");
        equipment_power = input.nextInt();
        System.out.print("Enter the room number where it is placed :-");
        equipment_room = input.nextInt();
    }

    void equipment_info() {
        System.out.println(equipment_id + "\t" + equipment_name + "\t\t\t" + equipment_technician + "     \t"
                + equipment_expiry + "    \t" + equipment_daily_limit + "       \t" + equipment_room + "       \t"
                + equipment_power + "       \t" + equipment_total_used + "       \t" + equipment_success + "    \t\t"
                + equipment_failure);
    }

    public static void main(String args[]) {
        String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        Calendar calendar = Calendar.getInstance();
        // To be used later
        System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " "
                + calendar.get(Calendar.YEAR));
        System.out.println("\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE)
                + ":" + calendar.get(Calendar.SECOND));
        int count1 = 4;

        Equipment[] d = new Equipment[25];
        int i;
        for (i = 0; i < 25; i++)
            d[i] = new Equipment();
        d[0].equipment_id = "21";
        d[0].equipment_name = "X-Ray Machine";
        d[0].equipment_technician = "Karthik";
        d[0].equipment_expiry = "05/02/2053";
        d[0].equipment_daily_limit = "09:00";
        d[0].equipment_room = 17;
        d[0].equipment_power = 3.6;
        d[0].equipment_total_used = 424;
        d[0].equipment_success = 398;
        d[0].equipment_failure = d[0].equipment_total_used - d[0].equipment_success;

        d[1].equipment_id = "32";
        d[1].equipment_name = "CT Scanner";
        d[1].equipment_technician = "Sushant";
        d[1].equipment_expiry = "31/01/2034";
        d[1].equipment_daily_limit = "06:00";
        d[1].equipment_room = 45;
        d[1].equipment_power = 3.6;
        d[1].equipment_total_used = 424;
        d[1].equipment_success = 398;
        d[1].equipment_failure = d[1].equipment_total_used - d[1].equipment_success;

        d[2].equipment_id = "17";
        d[2].equipment_name = "Anesthesia Mchn";
        d[2].equipment_technician = "Virat";
        d[2].equipment_expiry = "23/08/2024";
        d[2].equipment_daily_limit = "04:00";
        d[2].equipment_room = 8;
        d[2].equipment_power = 3.6;
        d[2].equipment_total_used = 424;
        d[2].equipment_success = 398;
        d[2].equipment_failure = d[2].equipment_total_used - d[2].equipment_success;

        d[3].equipment_id = "33";
        d[3].equipment_name = "Surgical Lights";
        d[3].equipment_technician = "Anushka";
        d[3].equipment_expiry = "12/12/2022";
        d[3].equipment_daily_limit = "14:00";
        d[3].equipment_room = 40;
        d[3].equipment_power = 3.6;
        d[3].equipment_total_used = 424;
        d[3].equipment_success = 398;
        d[3].equipment_failure = d[3].equipment_total_used - d[3].equipment_success;

        Scanner input = new Scanner(System.in);
        int choice, j, c1, status = 1, s1 = 1;
        while (status == 1) {
            System.out.println("\n                                    MAIN MENU");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("                      **EQUIPMENT SECTION**");
            System.out.println("--------------------------------------------------------------------------------");
            s1 = 1;
            while (s1 == 1) {
                System.out.println("1.Add New Equipment\n2.Existing Equipments Details");
                c1 = input.nextInt();
                switch (c1) {
                    case 1: {
                        d[count1].new_equipment();
                        count1++;
                        break;
                    }
                    case 2: {
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(
                                "id \t Name\t\t\t  equipment_technician\tExpiry\t\tWorking Limit \tRoom No.\tPower \t     Total used \tSuccess\t\tFailure");
                        System.out.println(
                                "-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        for (j = 0; j < count1; j++) {
                            d[j].equipment_info();
                        }
                        break;
                    }
                }
                System.out.println("\nReturn to MAIN MENU Press 1");
                status = input.nextInt();
            }
        }
    }
}
