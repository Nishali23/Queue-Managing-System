import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Displaying the menu options
        System.out.println("\t\t *  MENU  * \t\t");
        System.out.println();
        System.out.println("100 or VEQ: View all Queues");
        System.out.println("101 or VEQ: View all Empty Queues");
        System.out.println("102 or ACQ: Add customer to a Queue");
        System.out.println("103 or RCQ: Remove a customer from a Queue");
        System.out.println("104 or PCQ: Remove a served customer");
        System.out.println("105 or VCS: View Customers Sorted in alphabetical order");
        System.out.println("106 or SPD: Store Program Data into file");
        System.out.println("107 or LPD: Load Program Data from file");
        System.out.println("108 or STK: View Remaining burgers Stock");
        System.out.println("109 or AFS: Add burgers to Stock");
        System.out.println("999 or EXT: Exit the Program");

        // Initialize burger stock and quit
        int stock = 50;
        boolean quit = false;

        // Create arrays to represent cashier queues and all customers
        String[] cashier1 = new String[2];
        String[] cashier2 = new String[3];
        String[] cashier3 = new String[5];
        String[] allCustomers = new String[10];

        // Main program loop
        while (!quit) {

            // Prompt the user to choose an option
            System.out.println();
            System.out.println("Choose an option: ");
            Scanner input = new Scanner(System.in);
            String option = input.nextLine();

            // Process user's choice using a switch statement
            switch (option) {
                case "100":
                case "VFQ":
                    // View all queues
                    System.out.println("******************");
                    System.out.println("     cashiers     ");
                    System.out.println("******************");

                    // Display the status of each cashier queue (O: occupied, X: empty)
                    for (int i = 0; i < cashier3.length; i++) {
                        // Display Cashier 1 status
                        if (i < 2) {
                            if (cashier1[i] == null) {
                                System.out.print("X" + "\t\t");
                            } else {
                                System.out.print("O" + "\t\t");
                            }

                            // Display Cashier 2 status
                            if (cashier2[i] == null) {
                                System.out.print("X" + "\t\t");
                            } else {
                                System.out.print("O" + "\t\t");
                            }

                            // Display Cashier 3 status
                            if (cashier3[i] == null) {
                                System.out.print("X");
                            } else {
                                System.out.print("O");
                            }
                            System.out.println();
                        } else if (i < 3) {
                            // Display Cashier 2 status for the third row
                            if (cashier2[i] == null) {
                                System.out.print("\t\t" + "X" + "\t\t");
                            } else {
                                System.out.print("\t\t" + "O" + "\t\t");
                            }

                            // Display Cashier 3 status for the third row
                            if (cashier3[i] == null) {
                                System.out.print("X");
                            } else {
                                System.out.print("O");
                            }
                            System.out.println();
                        } else {
                            // Display Cashier 3 status for the fourth row
                            if (cashier3[i] == null) {
                                System.out.print("\t\t\t\t" + "X");
                            } else {
                                System.out.print("\t\t\t\t" + "O");
                            }
                            System.out.println();
                        }
                    }
                    break;

                case "101":
                case "VEQ":
                    // View all empty queues
                    int cashier1empty = 0;
                    int cashier2empty = 0;
                    int cashier3empty = 0;

                    // Check if Cashier 1 is empty
                    for (int i = 0; i < 2; i++) {
                        if (cashier1[i] == null) {
                            cashier1empty = 1;
                            break;
                        }
                    }

                    // Check if Cashier 2 is empty
                    for (int i = 0; i < 3; i++) {
                        if (cashier2[i] == null) {
                            cashier2empty = 1;
                            break;
                        }
                    }

                    // Check if Cashier 3 is empty
                    for (int i = 0; i < 5; i++) {
                        if (cashier3[i] == null) {
                            cashier3empty = 1;
                            break;
                        }
                    }

                    // Display empty cashiers, if any
                    if (cashier1empty == 0 && cashier2empty == 0 && cashier3empty == 0) {
                        System.out.println("All cashiers are full.");
                    } else {
                        System.out.println("Empty Cashiers:");
                        if (cashier1empty == 1) {
                            System.out.println("Cashier 1");
                        }
                        if (cashier2empty == 1) {
                            System.out.println("Cashier 2");
                        }
                        if (cashier3empty == 1) {
                            System.out.println("Cashier 3");
                        }
                    }
                    break;

                case "102":
                case "ACQ":
                    // Add customer to a queue
                    System.out.println("Choose your Cashier 1 or 2 or 3: ");
                    Scanner que = new Scanner(System.in);
                    int addcust = que.nextInt();

                    System.out.println("Enter your customer name: ");
                    Scanner cash = new Scanner(System.in);
                    String custnam = cash.nextLine();

                    // Add customer to the selected queue
                    if (addcust == 1) {
                        for (int i = 0; i < cashier1.length; i++) {
                            if (cashier1[i] == null) {
                                cashier1[i] = custnam;
                                System.out.println("Added to Cashier 1.");
                                break;
                            }
                            if (i == 1) {
                                System.out.println("Cashier 1 is full, cannot add more.");
                            }
                        }
                    } else if (addcust == 2) {
                        for (int i = 0; i < cashier2.length; i++) {
                            if (cashier2[i] == null) {
                                cashier2[i] = custnam;
                                System.out.println("Added to Cashier 2.");
                                break;
                            }
                            if (i == 2) {
                                System.out.println("Cashier 2 is full, cannot add more.");
                            }
                        }
                    } else if (addcust == 3) {
                        for (int i = 0; i < cashier3.length; i++) {
                            if (cashier3[i] == null) {
                                cashier3[i] = custnam;
                                System.out.println("Added to Cashier 3.");
                                break;
                            }
                            if (i == 4) {
                                System.out.println("Cashier 3 is full, cannot add more.");
                            }
                        }
                    } else {
                        System.out.println("Enter a valid Cashier number.");
                    }
                    break;

                case "103":
                case "RCQ":
                    // Remove a customer from a queue
                    System.out.println("Select Cashier number 1 or 2 or 3: ");
                    Scanner remo = new Scanner(System.in);
                    int remoque = remo.nextInt();

                    System.out.println("Select customer number: ");
                    Scanner remonum = new Scanner(System.in);
                    int custnum = remonum.nextInt();

                    // Remove the customer from the selected queue
                    if (remoque == 1) {
                        if (custnum == 1) {
                            cashier1[0] = cashier1[1];
                            cashier1[1] = null;
                            break;
                        }
                        if (custnum == 2) {
                            cashier1[1] = null;
                            break;
                        }

                        System.out.println("Customer removed from Cashier 1.");
                    } else if (remoque == 2) {
                        if (custnum == 1) {
                            cashier2[0] = cashier2[1];
                            cashier2[1] = cashier2[2];
                            cashier2[2] = null;
                            break;
                        }
                        if (custnum == 2) {
                            cashier2[1] = cashier2[2];
                            cashier2[2] = null;
                            break;
                        }
                        if (custnum == 3) {
                            cashier2[2] = null;
                            break;
                        }

                        System.out.println("Customer removed from Cashier 2.");
                    } else if (remoque == 3) {
                        if (custnum == 1) {
                            cashier3[0] = cashier3[1];
                            cashier3[1] = cashier3[2];
                            cashier3[2] = cashier3[3];
                            cashier3[3] = cashier3[4];
                            cashier3[4] = null;
                            break;
                        }
                        if (custnum == 2) {
                            cashier3[1] = cashier3[2];
                            cashier3[2] = cashier3[3];
                            cashier3[3] = cashier3[4];
                            cashier3[4] = null;
                            break;
                        }
                        if (custnum == 3) {
                            cashier3[2] = cashier3[3];
                            cashier3[3] = cashier3[4];
                            cashier3[4] = null;
                            break;
                        }
                        if (custnum == 4) {
                            cashier3[3] = cashier3[4];
                            cashier3[4] = null;
                            break;
                        }
                        if (custnum == 5) {
                            cashier3[4] = null;
                            break;
                        }

                        System.out.println("Customer removed from Cashier 3.");
                    } else {
                        System.out.println("Enter a valid Queue number.");
                    }
                    break;

                case "104" :
                case "PCQ" :
                    // Remove a served customer
                    System.out.println("Select served customer que number 1 or 2 or 3: ");
                    Scanner serve = new Scanner(System.in);
                    int serveque = serve.nextInt();

                    // Remove the first customer from the selected queue and update stock
                    if (stock > 10) {

                        if (serveque == 1) {

                            if (cashier1[0]!=null){
                                cashier1[0] = cashier1[1];
                                cashier1[1] = null;
                                stock = stock - 5;
                                System.out.println("Served Customer removed from Cashier 1.");
                            }
                            else {
                                System.out.println("This Cashier 1 is already empty!");
                            }


                        } else if (serveque == 2) {
                            if (cashier2[0]!=null){

                                cashier2[0] = cashier2[1];
                                cashier2[1] = cashier2[2];
                                cashier2[2] = null;
                                stock = stock - 5;
                                System.out.println("Served Customer removed from Cashier 2.");
                            }

                            else {
                                System.out.println("Cashier 2 is already empty!");

                            }


                        } else if (serveque == 3) {

                            if (cashier3[0]!=null){
                                cashier3[0] = cashier3[1];
                                cashier3[1] = cashier3[2];
                                cashier3[2] = cashier3[3];
                                cashier3[3] = cashier3[4];
                                cashier3[4] = null;
                                stock = stock - 5;
                                System.out.println("Served Customer removed from Cashier 3.");

                            }

                            else {
                                System.out.println("Cashier 3 is already empty!");
                            }
                        }

                    } else {
                        System.out.println("Warning! Burger stock should be updated.");
                    }
                    break;

                case "105":
                case "VCS":
                    // View Customers Sorted in alphabetical order
                    // Merge all cashier queues into a single array
                    int index = 0;
                    for (int i = 0; i < cashier1.length; i++) {
                        allCustomers[index++] = cashier1[i];
                    }
                    for (int i = 0; i < cashier2.length; i++) {
                        allCustomers[index++] = cashier2[i];
                    }
                    for (int i = 0; i < cashier3.length; i++) {
                        allCustomers[index++] = cashier3[i];
                    }

                    // Remove null elements and sort the array
                    String[] nonNullArray = Arrays.stream(allCustomers).filter(Objects::nonNull).toArray(String[]::new);
                    Arrays.sort(nonNullArray);

                    // Display customers sorted in alphabetical order
                    System.out.println("Customer names sorted in alphabetical order:");
                    for (String customer : nonNullArray) {
                        System.out.println(customer);
                    }
                    break;

                case "106":
                case "SPD":
                    // Store Program Data into file
                    try {
                        // Create a PrintWriter to write data to the file
                        PrintWriter data = new PrintWriter("file.txt");

                        // Write cashier queue status and burger stock into the file
                        data.println("******************");
                        data.println("     cashiers     ");
                        data.println("******************");


                        for(int i=0; i<cashier3.length; i++) {

                            if (i<2){
                                if(cashier1[i]==null) {
                                    data.print("X" + "\t");
                                }
                                else{
                                    data.print("O" + "\t");
                                }
                                if(cashier2[i]==null){
                                    data.print("X" + "\t");
                                }
                                else{
                                    data.print("O" + "\t");
                                }
                                if(cashier3[i]==null){
                                    data.print("X");
                                }
                                else{
                                    data.print("O");
                                }
                                data.println();
                            }

                            else if(i<3){
                                if(cashier2[i]==null){
                                    data.print("\t" + "X" + "\t");
                                }
                                else{
                                    data.print("\t" + "O" + "\t");
                                }
                                if(cashier3[i]==null){
                                    data.print("X");
                                }
                                else{
                                    data.print("O");
                                }
                                data.println();
                            }

                            else{
                                if(cashier3[i]==null){
                                    data.print("\t\t" + "X");
                                }
                                else{
                                    data.print("\t\t" + "O");
                                }
                                data.println();
                            }
                        }
                        data.println("Burger Stock : "+stock);
                        data.println();
                        data.println("All Customers :");
                        data.println();

                        for (int i=0 ; i<cashier1.length ; i++){
                            if (cashier1[i]!=null){
                                data.println(cashier1[i]);
                            }
                        }

                        for (int i=0 ; i<cashier2.length ; i++){
                            if (cashier2[i]!=null){
                                data.println(cashier2[i]);
                            }
                        }

                        for (int i=0 ; i<cashier3.length ; i++){
                            if (cashier3[i]!=null){
                                data.println(cashier3[i]);
                            }
                        }


                        data.close();

                        System.out.println("Data saved to a file!");

                    }
                    catch (FileNotFoundException exception) {

                        System.out.println("Error while saving data: " + exception.getMessage());
                    }
                    break;

                case "107":
                case "LPD":
                    // Load Program Data from file
                    // Initialize variables to store loaded data
                    String[] loadedData;
                    int items = 0;

                    try {
                        // Read the file to count the number of lines (items)
                        File file = new File("data.txt");
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            items++;
                            scanner.nextLine();
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + e.getMessage());
                    }

                    // Create an array to store the loaded data
                    loadedData = new String[items];

                    try {
                        // Read the file again to load data into the array
                        File file = new File("datatoload.txt");
                        Scanner scanner = new Scanner(file);
                        int index1 = 0;
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            loadedData[index1] = line;
                            index1++;
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + e.getMessage());
                    }

                    // Display the loaded customer names
                    System.out.println("Loaded Customer Names From File:");
                    for (String name : loadedData) {
                        System.out.println(name);
                    }

                    // Add the loaded customer names to the queues
                    int j = 0;
                    for (int i = 0; i < cashier3.length; i++) {
                        if (i < cashier1.length) {
                            if (j == loadedData.length) {
                                break;
                            } else {
                                cashier1[i] = loadedData[j];
                                j++;
                            }
                        }
                        if (i < cashier2.length) {
                            if (j == loadedData.length) {
                                break;
                            } else {
                                cashier2[i] = loadedData[j];
                                j++;
                            }
                        }
                        if (i < cashier3.length) {
                            if (j == loadedData.length) {
                                break;
                            } else {
                                cashier3[i] = loadedData[j];
                                j++;
                            }
                        }
                    }
                    break;

                case "108":
                case "STK":
                    // View Remaining Burgers Stock
                    System.out.println("Remaining Burgers Stock: " + stock);
                    break;

                case "109":
                case "AFS":
                    // Add burgers to Stock
                    System.out.println("How many burgers do you want to add?");
                    Scanner addburg = new Scanner(System.in);
                    int add = addburg.nextInt();

                    if (stock + add <= 50) {
                        stock = stock + add;
                        System.out.println(add + " burgers added.");
                    } else {
                        System.out.println("Cannot add more burgers, max stock is 50 burgers.");
                    }
                    break;

                case "999":
                case "EXT":
                    // Exit the Program
                    quit = true;
                    break;

                default:
                    System.out.println("Incorrect option.");
            }
        }
    }
}
