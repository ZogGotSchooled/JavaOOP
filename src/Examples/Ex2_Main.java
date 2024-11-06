package Examples;
import java.util.ArrayList;

public class Ex2_Main {

    public static void run(){
        ArrayList<Ex2_Actor> allActors = new ArrayList<>();
        allActors.add(new Ex2_Actor("Mr. Hemple", "Othello"));
        allActors.add(new Ex2_Actor("Ms. Bone", "Iago"));
        allActors.add(new Ex2_Actor("Ms. Smith", "Desdemona", true));
        allActors.add(new Ex2_Actor("Mr. Vetch", "Cassio", true));
        allActors.add(new Ex2_Actor("Mr. Van GinHoven", "Emilia", false));

//        allActors.get(1).getSales() = 125;
        allActors.get(1).sellTix(125);

        String seller = "Mr. Vetch";
        int sold = 75;

        int foundIndex = searchByName(allActors, seller);
        allActors.get(foundIndex).sellTix(sold);

        for(int i = 0; i < allActors.size(); i++){
            System.out.println(allActors.get(i));
//            allActors.get(i).printMe();
//            System.out.println(allActors.get(i).name);
        }

        //Calculate revenue at $15 per ticket
        int total = 0;
        for (int i = 0; i < allActors.size(); i++) {
            total += allActors.get(i).getSales();
        }

        System.out.println("We sold "+total+" tickets for a total revenue of "+(sold*15));


    }

    public static int searchByName(ArrayList list, String searchTerm){
        for(int i = 0; i < list.size(); i++){
            if(searchTerm.equalsIgnoreCase(((Ex2_Actor)list.get(i)).getName())){
                return i;
            }
        }
        return -1;
    }
}
