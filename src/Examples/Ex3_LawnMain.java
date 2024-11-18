package Examples;
import java.util.ArrayList;

public class Ex3_LawnMain {
    public static void run(){
        ArrayList<Ex3_Client> allClients = new ArrayList<>();

        allClients.add(new Ex3_Client("McDavid", "100 maple Dr", 1000, false));
        allClients.add(new Ex3_Client("Draisaitl", "102 maple Dr", 800, true));
        allClients.add(new Ex3_Client("Nugent-Hopkins", "50 main st", 530, false));
        allClients.add(new Ex3_Client("Walter White", "308 Negra Arroyo Lane", 240, false));
        allClients.add(new Ex3_Client("Podkolzin", "5 putin lane", 180, true));



        for(Ex3_Client client : allClients){
            client.mowLawn();
            client.mowLawn();
            client.mowLawn();

            System.out.println(client);
        }
    }//run
}//LawnMain
