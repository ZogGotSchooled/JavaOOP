package As3_Teams;

public class As3_Player {
    String name;
    int playerID;
    int snacksDevoured;
    int eliminations;

    public As3_Player(String setName, int setId, int setSnacks, int setElims){
        name = setName;
        playerID = setId;
        snacksDevoured = setSnacks;
        eliminations = setElims;
    }

    public String toString(){
        return " Name : " + name + " Player ID: " + playerID + " Snacks Devoured (points):  " + snacksDevoured + " Eliminations: " + eliminations;
    }

    public void devourOneSnack(){
        snacksDevoured += 1;
    }

}
