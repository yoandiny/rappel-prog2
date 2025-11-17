import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Grade {
    private Student student;
    private Exam exam;
    private List<GradeHistoryEntry> history;

    public Grade(Student student, Exam exam, double initialValue, String reason) {
        this.student = student;
        this.exam = exam;
        this.history = new ArrayList<>();

        addGradeChange(initialValue, Instant.now(), reason);
    }

    public void addGradeChange(double value, Instant timestamp, String reason) {
        this.history.add(new GradeHistoryEntry(value, timestamp, reason));
        this.history.sort(Comparator.comparing(GradeHistoryEntry::getChangeTimestamp));
    }


    public Student getStudent() { return student; }
    public Exam getExam() { return exam; }
    public List<GradeHistoryEntry> getHistory() { return history; }

    public Optional<Double> getValueAt(Instant t) {
        return history.stream()

                .filter(entry -> !entry.getChangeTimestamp().isAfter(t))

                .max(Comparator.comparing(GradeHistoryEntry::getChangeTimestamp))

                .map(GradeHistoryEntry::getValue);
    }
}