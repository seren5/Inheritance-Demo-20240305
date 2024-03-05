import java.util.ArrayList;

public class School {

    String name;
    ArrayList<Student> studentBody;

    public School(String name) {
        this.name = name;
        this.studentBody = new ArrayList<Student>();
    }

    public void enrollStudent(Student s) {
        // Check if already enrolled
        if (this.studentBody.contains(s)) {
            throw new RuntimeException(s.getName() + " is already enrolled at " + this.name);
        }
        // All good, proceed
        this.studentBody.add(s);
        s.setSchool(this);
        System.out.print("Assigning OneCard...");
        s.setOneCard(new OneCard(s));
        System.out.println("Success!");
    }

    public void removeStudent(Student s) {
        // Check if enrolled
        if (!this.studentBody.contains(s)) {
            throw new RuntimeException(s.getName() + " is not enrolled at " + this.name);
        }
        // All good, proceed
        this.studentBody.remove(s);
        s.setSchool(null); // drop affiliation
        s.setOneCard(null); // get rid of their card
    }

    public static void main(String[] args) {
        School smith = new School("Smith College");
        Student s = new Student("A. Smithie", 3.0);
        System.out.println(s);
        smith.enrollStudent(s);
        System.out.println("First onecard: " + s.getOneCard());
        System.out.println(s.getOneCard().getBalance());
        smith.removeStudent(s);
        System.out.println("Should be null: " + s.getOneCard());
        smith.enrollStudent(s);
        System.out.println("Second onecard: " + s.getOneCard());
        System.out.println(s.getOneCard().getBalance());
    }

}
