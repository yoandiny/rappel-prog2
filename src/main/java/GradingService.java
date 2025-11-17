import java.time.Instant;
import java.util.List;

public class GradingService {

    private List<Grade> allGrades;
    private List<Exam> allExams;

    public GradingService(List<Grade> allGrades, List<Exam> allExams) {
        this.allGrades = allGrades;
        this.allExams = allExams;
    }

    public double getExamGrade(Exam exam, Student student, Instant t) {
        Grade foundGrade = null;
        for (Grade g : allGrades) {
            if (g.getStudent().equals(student) && g.getExam().equals(exam)) {
                foundGrade = g;
                break;
            }
        }

        if (foundGrade == null) {
            return 0.0;
        }

        Double value = foundGrade.getValueAt(t);

        if (value == null) {
            return 0.0;
        } else {
            return value;
        }
    }

    public double getCourseGrade(Course course, Student student, Instant t) {
        List<Exam> courseExams = allExams.stream()
                .filter(e -> e.getCourse().equals(course))
                .toList();

        if (courseExams.isEmpty()) {
            return 0.0;
        }

        double totalWeightedGrade = 0.0;
        double totalCoefficients = 0.0;

        for (Exam exam : courseExams) {
            double examGrade = getExamGrade(exam, student, t);
            if (examGrade > 0) {
                totalWeightedGrade += examGrade * exam.getCoefficient();
                totalCoefficients += exam.getCoefficient();
            }
        }

        if (totalCoefficients == 0) {
            return 0.0;
        }

        return totalWeightedGrade / totalCoefficients;
    }
}