package scannerrocks;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public int id;
    public String firstName;
    public String lastName;
    public List<Integer> grades;

    public Student(int id, String firstName, String lastName, List<Integer> grades) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    @Override
    public String toString() {
        String basics = this.id + ": " + this.firstName + " " + this.lastName;
        String grades = "Grades:\n";
        for (int g : this.grades) {
            grades += g + "\n";
        }
        return basics + "\n" + grades;
    }
    
    
}
