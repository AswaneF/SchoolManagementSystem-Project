package org.example;

import lombok.Data;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

@Data
public class SchoolManagementSystem {
    private static final int MAX_DEPARTMENTS = 5;
    private static final int MAX_STUDENTS = 200;
    private static final int MAX_TEACHERS = 20;
    private static final int MAX_COURSES = 30;

    private List<Department> departments;
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;

    /**
     * Constructs a School Management System with empty lists for departments, students, teachers, and courses.
     */
    public SchoolManagementSystem() {
        this.departments = new ArrayList<>(MAX_DEPARTMENTS);
        this.students = new ArrayList<>(MAX_STUDENTS);
        this.teachers = new ArrayList<>(MAX_TEACHERS);
        this.courses = new ArrayList<>(MAX_COURSES);
    }

    /**
     * Adds a new department to the system if the maximum limit is not reached.
     *
     * @return
     */
    public Department addDepartment(DepartmentName departmentName) {
        Department department = new Department(departmentName);
        if (departments.size() < MAX_DEPARTMENTS) {
            departments.add(department);
            System.out.println("Add department " + department + " successfully.");
        } else {
            System.out.println("Max department reached, add a new department failed.");
        }
        return department;
    }

    /**
     * Adds a new student to the system if the maximum limit is not reached.
     */
    public void addStudent() {
        if (students.size() < MAX_STUDENTS) {
            students.add(new Student());
        } else {
            System.out.println("Cannot add more than " + MAX_STUDENTS + " students.");
        }
    }

    /**
     * Adds a new teacher to the system if the maximum limit is not reached.
     */
    public void addTeacher() {
        if (teachers.size() < MAX_TEACHERS) {
            teachers.add(new Teacher());
        } else {
            System.out.println("Cannot add more than " + MAX_TEACHERS + " teachers.");
        }
    }

    /**
     * Adds a new course to the system if the maximum limit is not reached.
     */
    public void addCourse() {
        if (courses.size() < MAX_COURSES) {
            courses.add(new Course());
        } else {
            System.out.println("Cannot add more than " + MAX_COURSES + " courses.");
        }
    }

    /**
     * Displays all departments in the system.
     */
    public void displayDepartments() {
        for (Department department : departments) {
            if (department != null) {
                System.out.println(department);
            }
        }
    }

    /**
     * Displays all students in the system with their courses and department information.
     */
    public void displayStudents() {
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    /**
     * Displays all teachers in the system with their courses and department information.
     */
    public void displayTeachers() {
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
    }

    /**
     * Displays all courses in the system with their teacher, students, and department information.
     */
    public void displayCourses() {
        for (Course course : courses) {
            if (course != null) {
                System.out.println(course);
            }
        }
    }

    /**
     * Searches for a department by departmentId.
     *
     * @param departmentId The ID of the department to search for.
     * @return The department with the specified ID, or null if not found.
     */
    public Department searchDepartment(String departmentId) {
        for (Department department : departments) {
            if (department != null && department.getDepartmentId().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }

    /**
     * Searches for a teacher by teacherId.
     *
     * @param teacherId The ID of the teacher to search for.
     * @return The teacher with the specified ID, or null if not found.
     */
    public Teacher searchTeacher(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher != null && teacher.getTeacherId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }

    /**
     * Searches for a course by courseId.
     *
     * @param courseId The ID of the course to search for.
     * @return The course with the specified ID, or null if not found.
     */
    public Course searchCourse(String courseId) {
        for (Course course : courses) {
            if (course != null && course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Searches for a student by studentId (integer).
     *
     * @param studentId The ID of the student to search for.
     * @return The student with the specified ID, or null if not found.
     */
    public Student searchStudent(int studentId) {
        for (Student student : students) {
            if (Objects.equals(student != null ? student.getStudentId() : null, studentId)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Searches for a student by studentId (string).
     *
     * @param studentId The ID of the student to search for as a string.
     * @return The student with the specified ID, or null if not found.
     */
    public Student searchStudent(String studentId) {
        int searchId;
        try {
            searchId = Integer.parseInt(studentId);
        } catch (NumberFormatException e) {
            return null; // Handle the case where studentId is not a valid integer
        }

        return searchStudent(searchId);
    }

    /**
     * Modifies the teacher assigned to a specific course.
     *
     * @param courseId  The ID of the course to be modified.
     * @param teacherId The ID of the teacher to be assigned to the course.
     */
    public void modifyTeacherForCourse(String courseId, String teacherId) {
        // Search for the course and teacher by their IDs
        Course course = searchCourse(courseId);
        Teacher teacher = searchTeacher(teacherId);

        // Check if the course and teacher are found
        if (course != null && teacher != null) {
            // Update the teacher for the course
            course.setTeacher(teacher);
            System.out.println("Course teacher updated successfully.");
        } else {
            // Display an error message if the course or teacher is not found
            System.out.println("Cannot find the specified course or teacher. Update failed.");
        }
    }

    /**
     * Assigns a teacher to a specific course.
     *
     * @param teacherId The ID of the teacher to be assigned.
     * @param courseId  The ID of the course to which the teacher will be assigned.
     */
    public void assignTeacherToCourse(String teacherId, String courseId) {
        Teacher teacher = searchTeacher(teacherId);
        Course course = searchCourse(courseId);

        if (teacher != null && course != null) {
            course.setTeacher(teacher);
        } else {
            System.out.println("Teacher or course not found.");
        }
    }

    /**
     * Registers a course for a student.
     *
     * @param studentId The ID of the student to register the course for.
     * @param courseId  The ID of the course to be registered.
     */
    public void registerCourseForStudent(int studentId, String courseId) {
        Student student = searchStudent(studentId);
        Course course = searchCourse(courseId);

        if (student != null && course != null) {
            course.registerStudent(student);
        } else {
            System.out.println("Student or course not found.");
        }
    }
}