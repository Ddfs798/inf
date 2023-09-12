import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        List<Student> students = new ArrayList<>();

        Scanner scanner = new Scanner(new File("students.txt"));
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(" ");
            int groupNumber = Integer.parseInt(parts[0].trim());
            String lastName = parts[1].trim();
            String firstName = parts[2].trim();
            String patronymic = parts[3].trim();
            students.add(new Student(groupNumber, lastName, firstName, patronymic));
        }
        scanner.close();

        Collections.sort(students, new StudentComparator());

        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}

