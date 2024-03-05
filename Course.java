import java.util.ArrayList;

public class Course {

    String title;
    String instructor;
    int nSeats;
    ArrayList<Student> roster;

    public Course(String title, String inst, int capacity) {
        this.title = title;
        this.instructor = inst;
        this.nSeats = capacity;
        this.roster = new ArrayList<>();
    }

    public void enrollStudent(Student s) {
        // Check if already enrolled
        if (this.roster.contains(s)) {
            throw new RuntimeException(s.getName() + " is already registered for " + this.title + " with " + this.instructor);
        }
        // All good, proceed
        this.roster.add(s);
        s.schedule.add(this);
        this.nSeats--;
    }

    public void removeStudent(Student s) {
        // Check if enrolled
        if (!this.roster.contains(s)) {
            throw new RuntimeException(s.getName() + " is not registered for " + this.title + " with " + this.instructor);
        }
        // All good, proceed
        this.roster.remove(s);
        s.schedule.remove(this);
        this.nSeats++;
    }

    public String toString() {
        return this.title + "(" + this.instructor + "): " + this.nSeats + " seats available";
    }
    
}
