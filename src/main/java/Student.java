import java.time.LocalDate;
import java.util.Objects;

public class Student extends Person {
    private String group;
    private Tutor tutor;

    public Student(int id, String lastName, String firstName, LocalDate birthDate, String email, String phoneNumber, String group, Tutor tutor) {
        super(id, lastName, firstName, birthDate, email, phoneNumber);
        this.group = group;
        this.tutor = tutor;
    }


}