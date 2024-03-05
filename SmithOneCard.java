public class SmithOneCard extends OneCard {
    double diningDollars;

    public SmithOneCard(Student name) {
        super(name);
        this.diningDollars = 100.0;
    }

    public void spendDD(double amount, String location){
        if (this.diningDollars < amount) {
            // throw exception
        } else if (!location.equals("Compass Cafe") && !location.equals("CC Cafe")) {
            //throw exception
        }
        this.diningDollars -= amount;
        System.out.println("Successfully spent dining dollars.");
    }

    public String toString() {
        return "----------\nOwner: " + this.getOwner().getName() + "\nCampus Cash Balance: $" + this.getOwner().balance + "\nDD Balance: $" + this.diningDollars + "\n----------";
    }
    public static void main(String[] args) {
        SmithOneCard mySmithOneCard = new SmithOneCard(new Student("Jordan", 3.0));
        System.out.println(mySmithOneCard);
        mySmithOneCard.spendDD(11.11, "CC Cafe");
        System.out.println(mySmithOneCard);
        mySmithOneCard.spend(1.0);
        System.out.println(mySmithOneCard);
    }
}
