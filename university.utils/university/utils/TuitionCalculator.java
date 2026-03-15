package university.utils;

import university.model.Student.EnrollmentType;

public class TuitionCalculator {

    public static String getTuitionCategory(EnrollmentType enrollmentType) {
        return switch (enrollmentType) {
            case FULL_TIME -> "Standard full-time tuition";
            case PART_TIME -> "Pay-per-credit tuition";
            case EXCHANGE  -> "No tuition (exchange program)";
        };
    }
}
