import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public Student getStudent() {
        return student;
    }

    public Exam getExam() {
        return exam;
    }

    public List<GradeHistoryEntry> getHistory() {
        return history;
    }

    public Double getValueAt(Instant t) {
        GradeHistoryEntry latestEntryBeforeT = null;

        for (GradeHistoryEntry entry : history) {
            if (!entry.getChangeTimestamp().isAfter(t)) {
                if (latestEntryBeforeT == null || entry.getChangeTimestamp().isAfter(latestEntryBeforeT.getChangeTimestamp())) {
                    latestEntryBeforeT = entry;
                }
            }
        }

        if (latestEntryBeforeT != null) {
            return latestEntryBeforeT.getValue();
        } else {
            return null;
        }
    }
}