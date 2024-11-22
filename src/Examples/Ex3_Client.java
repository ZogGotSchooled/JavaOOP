package Examples;

public class Ex3_Client {
    private String name;
    private String address = "308 Negra Arroyo Lane";
    private int schlongSize;
    private boolean hasDog;
    private double doubloonsDebt;

    //birth time!
    public Ex3_Client(String setName, String add, int lawnSize, boolean dog, double debt){
        name = setName;
        address = add;
        schlongSize = lawnSize;
        hasDog = dog;
        doubloonsDebt = debt;
    }

    public String toString(){
//        System.out.println("help me!");
        return name + " " + address + " " + schlongSize + " " + hasDog + " " + doubloonsDebt;
    }

    public void printMe(){
        System.out.println();
    }

    public void mowLawn(){
        double baseFee = 30;


        if(schlongSize > 200){
            baseFee += 0.1*schlongSize;
        }

        if(hasDog){
            baseFee += 50;
        }

        doubloonsDebt += baseFee;

        System.out.println(name+", your lawn was mowed today today for a charge of $"+baseFee);
        System.out.println("and your outstanding fees are $"+doubloonsDebt+"\n");
    }

    public void setHasDog(boolean hasDog) {
        this.hasDog = hasDog;
    }

    public String getName() {
        return name;
    }

    public void processPayment(double dollars){
        doubloonsDebt -= dollars;
        System.out.println(name + " You currently owe $"+doubloonsDebt);
    }

    public void delinquent(){
        double interest = 5 + doubloonsDebt * 0.1;
        System.out.println(name + " your payment is overdue, you have been charged interest of "+interest);
        doubloonsDebt += interest;

        if(doubloonsDebt > 500 && hasDog){
            hasDog = false;
        }
    }

    public String getAddress() {
        return address;
    }

    public int getSchlongSize() {
        return schlongSize;
    }

    public boolean isHasDog() {
        return hasDog;
    }

    public double getDoubloonsDebt() {
        return doubloonsDebt;
    }
}
