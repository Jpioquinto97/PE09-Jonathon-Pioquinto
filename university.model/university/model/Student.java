package university.model;

import java.util.List;

public record Student(String name, String id, EnrollmentType enrollmentType, List<Course> courses) {

    public enum EnrollmentType {
        FULL_TIME,
        PART_TIME,
        EXCHANGE
    }

    // Compact constructor for validation
    public Student {
        int totalCredits = courses.stream().mapToInt(Course::getCreditHours).sum();

        int maxCredits = switch (enrollmentType) {
            case FULL_TIME -> 18;
            case PART_TIME -> 9;
            case EXCHANGE  -> 6;
        };

        if (totalCredits > maxCredits) {
            System.out.println("Validation Error: Total credits (" + totalCredits +
                    ") exceed the limit for " + enrollmentType + " students (max " + maxCredits + ").");
            System.out.println("Registered Courses:");
            courses.forEach(c -> System.out.println("  - " + c));
            System.out.println("Exceeded by: " + (totalCredits - maxCredits) + " credit(s).");
            throw new IllegalArgumentException("Credit limit exceeded.");
        }
    }
}
