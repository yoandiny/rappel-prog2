import java.time.LocalDate;

public class Teacher extends Person {
    private String specialty;

    public Teacher(int id, String lastName, String firstName, LocalDate birthDate, String email, String phoneNumber, String specialty) {
        super(id, lastName, firstName, birthDate, email, phoneNumber);
        this.specialty = specialty;
    }
}