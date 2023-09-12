import java.util.Comparator;
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        // номер группы
        int groupCompare = Integer.compare(s1.getGroupNumber(), s2.getGroupNumber());
        if (groupCompare != 0) {
            return groupCompare;
        }

        // сравниваем фамилии
        int lastNameCompare = s1.getLastName().compareTo(s2.getLastName());
        if (lastNameCompare != 0) {
            return lastNameCompare;
        }

        // отчества
        return s1.getPatronymic().compareTo(s2.getPatronymic());
    }
}
