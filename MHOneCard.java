public class MHOneCard extends OneCard {
    double accountBalance;

    public MHOneCard(Student owner) {
        super(owner);
        this.accountBalance = 0.0;
    }

    public void chargeAccount(double amount, String location) {
        if (!location.equals("Odyssey Bookshop")) {
            //throw exception
        }
        this.accountBalance -= amount;
    }

    public String toString() {
        return "----------\nOwner: " + this.getOwner().getName() + "\nCampus Cash Balance: $" + this.getOwner().balance + "\nAccount Balance: $" + this.accountBalance + "\n----------";
    }

    public static void main(String[] args) {
        Student myFriend = new Student("MyFriendo", 20.0);
        MHOneCard mohoCard = new MHOneCard(myFriend);
        System.out.println(mohoCard);
        mohoCard.chargeAccount(10, "Odyssey Bookshop");
        System.out.println(mohoCard);
    }
}
