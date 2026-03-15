package university.main;

import university.model.Course;
import university.model.Student;
import university.model.Student.EnrollmentType;
import university.utils.TuitionCalculator;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        // Valid student - FULL_TIME with 7 credits (under 18 limit)
        Course course1 = new Course("CS101", "Intro to CS", 3);
        Course course2 = new Course("MATH201", "Discrete Math", 4);
        List<Course> courses = List.of(course1, course2);

        Student student = new Student("Luna", "S12345", EnrollmentType.FULL_TIME, courses);

        System.out.println("Name: " + student.name());
        System.out.println("ID: " + student.id());
        System.out.println("Enrollment Type: " + student.enrollmentType());
        System.out.println("Registered Courses:");
        student.courses().forEach(c -> System.out.println("  - " + c));

        String tuitionCategory = TuitionCalculator.getTuitionCategory(student.enrollmentType());
        System.out.println("Tuition Category: " + tuitionCategory);

        System.out.println();

        // Invalid student - FULL_TIME with 20 credits (exceeds 18 limit)
        try {
            Course phy = new Course("PHY101", "Physics", 6);
            Course bio = new Course("BIO101", "Biology", 6);
            Course chem = new Course("CHEM101", "Chemistry", 8);
            List<Course> overloadCourses = List.of(phy, bio, chem);

            Student overload = new Student("Max", "S99999", EnrollmentType.FULL_TIME, overloadCourses);
        } catch (IllegalArgumentException e) {
            // Exception already handled in Student constructor
        }
    }
}
