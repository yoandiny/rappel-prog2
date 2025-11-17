import java.time.Instant;
import java.util.Objects;

public class Exam {
    private int id;
    private String title;
    private Course course;
    private Instant examDateTime;
    private double coefficient;

    public Exam(int id, String title, Course course, Instant examDateTime, double coefficient) {
        this.id = id;
        this.title = title;
        this.course = course;
        this.examDateTime = examDateTime;
        this.coefficient = coefficient;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public Course getCourse() { return course; }
    public Instant getExamDateTime() { return examDateTime; }
    public double getCoefficient() { return coefficient; }


}