package org.example;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Department {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private String departmentId;
    private DepartmentName departmentName;

    /**
     * Constructs a new department with a unique department ID and the specified department name.
     */
    public Department(DepartmentName departmentName) {
        this.departmentId = "D" + String.format("%03d", counter.getAndIncrement());
        this.departmentName = departmentName;
    }

    /**
     * Gets the unique ID of the department.
     *
     * @return The department ID.
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * Gets the name of the department.
     *
     * @return The department name.
     */
    public DepartmentName getDepartmentName() {
        return departmentName;
    }

    /**
     * Generates a string representation of the department including the department ID and name.
     *
     * @return A string representation of the department.
     */
    @Override
    public String toString() {
        return "Department ID: " + departmentId + ", Department Name: " + departmentName;
    }
}