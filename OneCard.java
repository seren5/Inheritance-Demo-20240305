public class OneCard {
    
  private Student owner;

  public OneCard(Student s) {
      this.owner = s;
  } 

  /**
   * Getter for owner
   * @return the owner
   */
  public Student getOwner() {
      return this.owner;
  }

  /**
   * Getter for balance
   * @return the balance
   */
  public double getBalance() {
      return this.owner.balance;
  }
  
  /**
   * Increase the balance on a OneCard
   * @param amt amount to add
   */
  public void deposit(double amt) {
      this.owner.balance += amt;
  }

  /**
   * Compares balance to a proposed debit to ensure sufficient funds
   * @param amt Proposed charge
   * @return T/F: does account have sufficient balance to cover amt
   */
  public boolean canAfford(double amt) {
      return this.owner.balance >= amt;
  }

  public void spend(double amt) {
      if (this.canAfford(amt)) {
          this.owner.balance -= amt;
      } else {
          throw new RuntimeException("Sorry, you don't have enough $ on your card.");
      }
  }

  public String toString() {
      return this.owner.getName() + "'s OneCard has a balance of $" + this.owner.balance;
  }

  public static void main(String[] args) {
      OneCard myCard = new OneCard(new Student("Johanna", 12.0));
      System.out.println(myCard);
      myCard.getOwner().setName("Jordan");
      double amt = 19.0;
      System.out.println(myCard);
      try{
          myCard.spend(amt);
      } catch (RuntimeException e) {
          System.out.println(e.getMessage());
          System.out.println("Hint: you need to deposit at least $" + (amt - myCard.owner.balance));
      }
      System.out.println(myCard); // Reachable
  }
}