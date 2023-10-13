package sde.virginia.edu.hw4;

public class RegistrationService {
    public enum RegistrationResult {
        /**
         * The student was successfully enrolled into the section.
         */
        ENROLLED,
        /**
         * The student was successfully added to the wait list for the section.
         */
        WAIT_LISTED,
        /**
         * Unable to enroll student because the student is already either enrolled or wait listed in the course
         */
        ALREADY_IN_COURSE,
        /**
         * Unable to enroll because the course is closed
         */
        ENROLLMENT_CLOSED,

        /**
         * Unable to enroll because both the enrollment and wait list for the course are full
         */
        SECTION_FULL,

        /**
         * Unable to enroll because the student is either enrolled or wait listed in a class with a time conflict
         */
        SCHEDULE_CONFLICT,
        /**
         * Unable to enroll because the student does not meet the prerequisites for the class.
         */
        PREREQUISITE_NOT_MET,
        /**
         *
         */
        CREDIT_LIMIT_VIOLATION
    }

    public RegistrationResult register(Student student, Section section) {
        return null;
        //TODO: implement and test
    }

    public boolean drop(Student student, Section section) {
        return false;
        //TODO: implement and test
    }
}
