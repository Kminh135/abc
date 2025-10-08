import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y) {
        if (x.CGPA != y.CGPA) {
            return Double.compare(x.CGPA, y.CGPA);
        } else if (!x.name.equals(y.name)) {
            return x.name.compareTo(y.name);
        } else {
            return x.id - y.id;
        }
    }
}
