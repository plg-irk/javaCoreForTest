package lesson9;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Student1",
                Arrays.asList(new Course("Course1"), new Course("Course2"))
        ));
        students.add(new Student("Student2",
                Arrays.asList(new Course("Course1"), new Course("Course3"),
                        new Course("Course5"), new Course("Course6"))
        ));
        students.add(new Student("Student3",
                Arrays.asList(new Course("Course2"), new Course("Course3"),
                        new Course("Course4"), new Course("Course5"),
                        new Course("Course6"))
        ));
        students.add(new Student("Student4",
                Arrays.asList(new Course("Course4"),
                        new Course("Course5"), new Course("Course6"))
        ));

        for (Course c :
                students.stream()
                        .map(s -> s.getCourse())
                        .flatMap(f -> f.stream())
                        .collect(Collectors.toSet()))
            System.out.println(c);

        List<Student> courseList = students.stream()
                .sorted((s1, s2) -> s2.getCourse().size() - s1.getCourse().size())
                .limit(3)
                .collect(Collectors.toList());
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println(courseList.get(i));
        }

        Course course = new Course("Course1");
        System.out.println(students.stream()
                .filter(s -> s.getCourse().contains(course))
                .collect(Collectors.toList()));


    }

}
