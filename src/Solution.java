import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student {
    double CGPA;
    String name;
    int id;

    Student(String name, double CGPA, int id) {
        this.name = name;
        this.CGPA = CGPA;
        this.id = id;
    }
}
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
public class Solution {
    public static void main(String[] args) {
        Comparator<Student> comparator = new StudentComparator();
        PriorityQueue<Student> queue = new PriorityQueue<Student>(comparator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.nextLine();

        for(int i = 0; i < n; i++) {
            String event = sc.nextLine();
            String[] parts = event.split(" ");
            String eventType = parts[0];

            if (eventType.equals("ENTER")) {
                String name = parts[1];
                double CGPA = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                queue.add(new Student(name, CGPA, id));
            } else if (eventType.equals("SERVED")) {
                if (!queue.isEmpty()) {
                    queue.poll();
                }
            }
        }
        if (queue.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            while (!queue.isEmpty()) {
                System.out.println(queue.poll().name);
            }
        }
        sc.close();
    }
}

