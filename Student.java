import java.util.ArrayList;

public class Student {

    private String name;
    double balance;
    private OneCard oneCard;
    School currentSchool;
    ArrayList<Course> schedule;

    public Student(String n, double b) {
        this.name = n;
        this.balance = b;
        this.schedule = new ArrayList<Course>();
    }

    /**
     * Getter for name
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for name
     * @param newName updated name
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Getter for oneCard
     * @return the oneCard
     */
    public OneCard getOneCard() {
        return this.oneCard;
    }

    /**
     * Setter for oneCard
     * @param c updated card
     */
    public void setOneCard(OneCard c) {
        this.oneCard = c;
    }

    /**
     * Getter for currentSchool
     * @return the current school
     */
    public School getSchool() {
        return this.currentSchool;
    }

    /**
     * Setter for oneCard
     * @param c updated card
     */
    public void setSchool(School s) {
        this.currentSchool = s;
    }

    public String toString() {
        if (this.currentSchool == null) {
            return this.name + " is currently a student at the School of Life";
        }
        return this.name + " is currently a student at " + this.currentSchool.name;
    }

    public void enrollAt(School s) {
        try {
            s.enrollStudent(this);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Hint: you don't need to re-enroll!");
        }
    }

    public void dropOutOf(School s) {
        try {
            s.removeStudent(this);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Hint: you can't drop out of a school you're not enrolled at!");
        }
    }

    public void add(Course c) {
        try {
            c.enrollStudent(this);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Hint: you don't need to re-register!");
        }
    }

    public void drop(Course c) {
        try {
            c.removeStudent(this);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Hint: you can't drop a course you're not registered for!");
        }
    }

    public void printSchedule() {
        System.out.println("CURRENT SCHEDULE FOR " + this.name + ":");
        for (Course c : this.schedule) {
            System.out.println(" - " + c);
        }
    }

    public static void main(String[] args) {
        Student s = new Student("Jordan", 3.27);
        System.out.println(s);
        School smith = new School("Smith College");
        s.enrollAt(smith);
        Course c1 = new Course("CSC120: OOP", "Jordan + Johanna", 30);
        Course c2 = new Course("CSC231: Assembly and Microprocessors", "Nick | Michael", 30);
        s.add(c1);
        s.add(c2);
        s.printSchedule();
    }

}
