package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Student {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private String studentId;
    private String fname;
    private String lname;
    private Department department;
    private int courseNum;
    private List<String> courses;
    private Course[] registeredCourses;

    /**
     * Constructs a new student with a unique student ID and an empty array for registered courses.
     */
    public Student() {
        this.studentId = "S" + String.format("%03d", counter.getAndIncrement());
        this.fname = null;
        this.lname = null;
        this.department = null;
        this.courseNum = 0;
        this.courses = new ArrayList<>();
        this.registeredCourses = new Course[5];
    }

    /**
     * Registers a course for the student, if there is space and the course is not already registered.
     *
     * @param course The course to be registered.
     */
    public void registerCourse(Course course) {
        if (!isFull() && !isAlreadyRegistered(course)) {
            for (int i = 0; i < registeredCourses.length; i++) {
                if (registeredCourses[i] == null) {
                    registeredCourses[i] = course;
                    course.registerStudent(this);
                    break;
                }
            }
        } else {
            System.out.println("Cannot register more than 5 courses or duplicate courses for this student.");
        }
    }

    /**
     * Checks if the student has already registered the maximum number of courses.
     *
     * @return True if the student's course array is full, false otherwise.
     */
    private boolean isFull() {
        return registeredCourses[4] != null;
    }

    /**
     * Checks if the specified course is already registered by the student.
     *
     * @param course The course to check for registration.
     * @return True if the course is already registered, false otherwise.
     */
    private boolean isAlreadyRegistered(Course course) {
        for (Course registeredCourse : registeredCourses) {
            if (registeredCourse == course) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generates a string representation of the student including student ID and registered courses.
     *
     * @return A string representation of the student.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Student ID: " + studentId + "\nRegistered Courses: ");
        if (registeredCourses != null) {
            for (Course course : registeredCourses) {
                if (course != null) {
                    result.append(course.getCourseId()).append(", ");
                }
            }
        }
        return result.toString();
    }

    /**
     * Constructs a new student with the given first name, last name, and department.
     *
     * @param studentId  The id of the student.
     * @param fname      The first name of the student.
     * @param lname      The last name of the student.
     * @param department The department to which the student belongs.
     */
    public Student(String studentId, String fname, String lname, Department department) {
        this.studentId = studentId;
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        this.courseNum = 0;
        this.courses = new ArrayList<>();
        this.registeredCourses = new Course[5];
    }
}