import java.time.LocalDate;

public class Tutor extends Person {
    private String relationship;

    public Tutor(int id, String lastName, String firstName, LocalDate birthDate, String email, String phoneNumber, String relationship) {
        super(id, lastName, firstName, birthDate, email, phoneNumber);
        this.relationship = relationship;
    }

    public String getRelationship() { return relationship; }
}