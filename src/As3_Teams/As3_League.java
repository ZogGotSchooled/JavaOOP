package As3_Teams;

import Examples.Ex3_Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class As3_League {
    static ArrayList<As3_Team> allTeams;
    public static void run(){
        allTeams = new ArrayList<As3_Team>();
        loadFile("data/BattleSnacksLeague.csv", allTeams);

        printAllTeams();

    }

    public static void printAllTeams(){
        for(As3_Team team : allTeams){
            System.out.println(team);
        }
    }

    public static void loadFile(String filename, ArrayList<As3_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");

                list.add( new As3_Team(  tempArray[0],tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), Double.parseDouble(tempArray[5])   ));
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile
}
