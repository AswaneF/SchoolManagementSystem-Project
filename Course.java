package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Course {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private String courseId;
    private Teacher teacher;
    private List<Student> registeredStudents;

    /**
     * Constructs a new course with a unique course ID and an empty list for registered students.
     */
    public Course() {
        this.courseId = "C" + String.format("%03d", counter.getAndIncrement());
        this.registeredStudents = new ArrayList<>();
    }

    /**
     * Registers a student for the course if there is space and the student is not already registered.
     *
     * @param student The student to be registered.
     */
    public void registerStudent(Student student) {
        if (registeredStudents.size() < 5 && !isAlreadyRegistered(student)) {
            registeredStudents.add(student);
        } else {
            System.out.println("Cannot register more than 5 students or duplicate students for this course.");
        }
    }

    /**
     * Checks if the specified student is already registered for the course.
     *
     * @param student The student to check for registration.
     * @return True if the student is already registered, false otherwise.
     */
    private boolean isAlreadyRegistered(Student student) {
        return registeredStudents.contains(student);
    }

    /**
     * Generates a string representation of the course including course ID, teacher, and registered students.
     *
     * @return A string representation of the course.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Course ID: " + courseId + "\nRegistered Students: ");
        if (registeredStudents != null) {
            for (Student student : registeredStudents) {
                if (student != null) {
                    result.append(student.getStudentId()).append(", ");
                }
            }
        }
        return result.toString();
    }

    /**
     * Constructs a new course with the given ID, course name, credit value, and department.
     *
     * @param courseId   The ID of the course.
     * @param courseName The name of the course.
     * @param credit     The credit value assigned to the course.
     * @param department The department offering the course.
     */
    public Course(String courseId, String courseName, double credit, Department department) {
    }
}