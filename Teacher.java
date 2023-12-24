package org.example;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Teacher {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private String teacherId;

    /**
     * Constructs a new teacher with a unique teacher ID.
     * The teacher ID is generated in the format "T001" and increments each time a new teacher is created.
     */
    public Teacher() {
        this.teacherId = generateTeacherId();
    }

    /**
     * Gets the teacher's unique ID.
     *
     * @return The teacher ID.
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * Generates a unique teacher ID in the format "T001" using an atomic counter.
     *
     * @return A unique teacher ID.
     */
    private String generateTeacherId() {
        return "T" + String.format("%03d", counter.getAndIncrement());
    }

    /**
     * Generates a string representation of the teacher including the teacher ID.
     *
     * @return A string representation of the teacher.
     */
    @Override
    public String toString() {
        return "Teacher ID: " + teacherId;
    }

    /**
     * Constructs a new teacher with the given ID, first name, last name, and department.
     *
     * @param teacherId  The ID of the teacher.
     * @param firstName  The first name of the teacher.
     * @param lastName   The last name of the teacher.
     * @param department The department to which the teacher belongs.
     */
    public Teacher(String teacherId, String firstName, String lastName, Department department) {
    }
}