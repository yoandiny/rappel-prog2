// GradeHistoryEntry.java
import java.time.Instant;

public class GradeHistoryEntry {
    private double value;
    private Instant changeTimestamp;
    private String reason;

    public GradeHistoryEntry(double value, Instant changeTimestamp, String reason) {
        this.value = value;
        this.changeTimestamp = changeTimestamp;
        this.reason = reason;
    }


    public double getValue() { return value; }
    public Instant getChangeTimestamp() { return changeTimestamp; }
}