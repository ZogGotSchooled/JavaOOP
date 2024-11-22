package Examples;
import java.util.ArrayList;
import java.io.*;

public class Ex3_LawnMain {
    public static void run(){
        ArrayList<Ex3_Client> allClients = new ArrayList<>();

        loadFile("data/Lawn-ClientData.csv", allClients);
        System.out.println(allClients);
//        allClients.add(new Ex3_Client("McDavid", "100 maple Dr", 1000, false));
//        allClients.add(new Ex3_Client("Draisaitl", "102 maple Dr", 800, true));
//        allClients.add(new Ex3_Client("Nugent-Hopkins", "50 main st", 530, false));
//        allClients.add(new Ex3_Client("Walter White", "308 Negra Arroyo Lane", 240, false));
//        allClients.add(new Ex3_Client("Podkolzin", "5 putin lane", 180, true));

        System.out.println("Welcome to Moe's Mowing");
        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1.  Print all Clients");
            System.out.println("2.  Mow all lawns");
            System.out.println("3.  Receive Payment");
            System.out.println("4.  Add new client");
            System.out.println("5.  Delinquent Payments");
            System.out.println("6.  Save and Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();
            if (choice == 1) {

                for (int i = 0; i < allClients.size(); i++) {
                    System.out.println(allClients.get(i));
                }

            } else if (choice == 2) {
                for (int i = 0; i < allClients.size(); i++) {
                    allClients.get(i).mowLawn();

                }
            } else if (choice == 3) {
                System.out.println("Who is paying?");
                String name = Library.input.nextLine();
                System.out.println("How much?");
                double amount = Library.input.nextDouble();
                Library.input.nextLine();

                int foundClient = searchByName(allClients, name);
                allClients.get(foundClient).processPayment(amount);


            } else if (choice == 4) {

            } else if (choice == 5) {
                for(Ex3_Client clientTemp: allClients){
                    clientTemp.delinquent();
                }
            } else {

                break;
            }
        } // while
        System.out.println("There is no use moanin as there is no mow like Moe's mowin.  \nGood bye.");
//
//        for(Ex3_Client client : allClients){
//            client.mowLawn();
//            client.mowLawn();
//            client.mowLawn();
//
//            System.out.println(client);
//        }
    }//run


    public static int searchByName(ArrayList list, String searchTerm){
        for(int i = 0; i < list.size(); i++){
            if(searchTerm.equalsIgnoreCase(((Ex3_Client)list.get(i)).getName())){
                return i;
            }
        }
        return -1;
    }

    public static void loadFile(String filename, ArrayList<Ex3_Client> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");
                //the next line is customized for whatever class you are creating.
                //Here we create a new STUDENT so there are 5 variables
                //Unfortunately, you need to Parse any variable that is not a String.  Integers, doubles and booleans are all demonstrated below.

                list.add( new Ex3_Client(  tempArray[0],tempArray[1], Integer.parseInt(tempArray[4]),Boolean.parseBoolean(tempArray[5]), Double.parseDouble(tempArray[2])   ));

            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile



}//LawnMain