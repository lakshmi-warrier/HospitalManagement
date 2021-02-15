package Project.src;

//Contributed by MONEESH NAGIREDDY
//CSE(AI) | B - BATCH
// AMRITA VISWA VIDYAPEETHAM
import java.io.*;

class ParkingLot {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public void addVehicle() throws IOException {

    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("parking.txt", true)));
    String name, v_number, pat_number, address;
    String s, left;
    boolean addMore = false, lot_status;

    do {
      System.out.print("\nEnter the Patient name: ");
      name = br.readLine();

      System.out.print("Enter Vehicle Number: ");
      v_number = br.readLine();

      System.out.print("Enter the Patient Telephone Number: ");
      pat_number = br.readLine();

      System.out.print("Address: ");
      address = br.readLine();

      System.out.print(
          "Entering/Leaving the Parking lot. Enter Y for Entering the lot and N for Leaving the Parking facility: ");
      s = br.readLine();
      if (s.equalsIgnoreCase("y")) {
        lot_status = true;
        System.out.println();
      } else
        lot_status = false;

      pw.println(name);
      pw.println(v_number);
      pw.println(pat_number);
      pw.println(address);
      pw.println(lot_status);

      System.out.print("\nParking Logs updated successfully !\n\nDo you want to add more Logs ? (y/n) : ");
      s = br.readLine();
      if (s.equalsIgnoreCase("y")) {
        addMore = true;
        System.out.println();
      } else
        addMore = false;
    } while (addMore);
    pw.close();
    showMenu();
  }

  public void view_vehicles() throws IOException {
    try {
      BufferedReader file = new BufferedReader(new FileReader("parking.txt"));
      String name;
      int i = 1;
      while ((name = file.readLine()) != null) {
        System.out.println("S.No. : " + (i++));
        System.out.println("-------------");
        System.out.println("\nName: " + name);
        System.out.println("Vehicle Number : " + file.readLine());
        System.out.println("Phone Number : " + file.readLine());
        System.out.println("Address: " + file.readLine());
        System.out.println("Car is in the Parking Lot : " + file.readLine());
        System.out.println();
      }
      file.close();
      showMenu();
    } catch (FileNotFoundException e) {
      System.out.println("\nERROR : File not Found !!!");
    }
  }

  public void clear() throws IOException {
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("parking.txt")));
    pw.close();
    System.out.println("\nAll Logs cleared successfully !");
    showMenu();
  }

  public void showMenu() throws IOException {
    System.out.print("1 : Add Logs\n2 : Display Logs\n3 : Clear All Logs\n4 : Exit\n\nYour Choice : ");
    int choice = Integer.parseInt(br.readLine());
    switch (choice) {
      case 1:
        addVehicle();
        break;
      case 2:
        view_vehicles();
        break;
      case 3:
        clear();
        break;
      case 4:
        System.exit(1);
        break;
      default:
        System.out.println("\nInvalid Choice !");
        break;
    }
  }

  public static void run() throws IOException {
    ParkingLot call = new ParkingLot();
    call.showMenu();
  }
}
