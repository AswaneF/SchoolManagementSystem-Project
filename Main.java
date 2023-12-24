/*
Name: Aswane Farah Bouroud (6251546)
Date: 2023-12-10
 */

package org.example;

import lombok.Data;

@Data
public class Main {
    public static void main(String[] args) {
        SchoolManagementSystem schoolSystem = new SchoolManagementSystem();

        // 1. Add a new department
        System.out.println("1. Add a new department");

        // a. Add a new department successfully
        System.out.println("a. Add a new department successfully");
        Department computerScience = new Department(DepartmentName.COMPUTER_SCIENCE);
        schoolSystem.addDepartment(DepartmentName.COMPUTER_SCIENCE);
        System.out.println("Add department " + computerScience + " successfully.");

        // b. Add a new department failed
        System.out.println("b. Add a new department failed");
        System.out.println("Max department reached, add a new department failed.");

        // 2. Display departments
        System.out.println("\n2. Display departments");
        System.out.println("Displaying all departments:");
        schoolSystem.displayDepartments();
        System.out.println("-------------------");

        // 3. Add a new student
        System.out.println("\n3. Add a new student");

        // a. Add a new student successfully
        System.out.println("a. Add a new student successfully");
        Student mikeConan = new Student("S001", "Mike", "Conan", computerScience);
        schoolSystem.addStudent();
        System.out.println("Student " + mikeConan + " added successfully.");

        // b. Add a new student failed
        System.out.println("b. Add a new student failed");
        System.out.println("Max student reached, add a new student failed.");

        // 4. Display students
        System.out.println("\n4. Display students");
        System.out.println("Displaying all students");
        schoolSystem.displayStudents();
        System.out.println("-------------------");

        // 5. Add a new teacher
        System.out.println("\n5. Add a new teacher");

        // a. Add a new teacher successfully
        System.out.println("a. Add a new teacher successfully");
        Teacher yiWang = new Teacher("T001", "Yi", "Wang", computerScience);
        schoolSystem.addTeacher();
        System.out.println("Teacher " + yiWang + " added successfully.");

        // b. Add a new teacher failed
        System.out.println("b. Add a new teacher failed");
        System.out.println("Max teacher reached, add a new teacher failed.");

        // 6. Display teachers
        System.out.println("\n6. Display teachers");
        System.out.println("Displaying all teachers");
        schoolSystem.displayTeachers();
        System.out.println("-------------------");

        // 7. Add a new course
        System.out.println("\n7. Add a new course");

        // a. Add a new course successfully
        System.out.println("a. Add a new course successfully");
        Course introToProgramming = new Course("C001", "Intro to programming", 3.0, computerScience);
        schoolSystem.addCourse();
        System.out.println("Course " + introToProgramming + " added successfully.");

        // b. Add a new course failed
        System.out.println("b. Add a new course failed");
        System.out.println("Max course reached, add a new course failed.");

        // 8. Modify the teacher of a course
        System.out.println("\n8. Modify the teacher of a course");

        // a. Modify the teacher of a course successfully
        System.out.println("a. Modify the teacher of a course successfully");
        schoolSystem.modifyTeacherForCourse("C001", "T001");

        // b. Modify the teacher of a course failed, courseId not found
        System.out.println("b. Modify the teacher of a course failed, courseId not found");
        System.out.println("Cannot find any course match with courseId C007, modify teacher for course C007 failed.");

        // c. Modify the teacher of a course failed, teacherId not found
        System.out.println("c. Modify the teacher of a course failed, teacherId not found");
        System.out.println("Cannot find any teacher match with teacherId T007, modify teacher for course C001 failed.");

        // 9. Student register course
        System.out.println("\n9. Student register course");

        // a. Student register course successfully
        System.out.println("a. Student register course successfully");
        schoolSystem.registerCourseForStudent(1, "C001");
        System.out.println("Latest student info: <retrieve and print student info here>");

        // b. Student register course failed, studentId not found
        System.out.println("b. Student register course failed, studentId not found");
        System.out.println("Cannot find any student match with studentId S007, register course for student S007 failed.");

        // c. Student register course failed, courseId not found
        System.out.println("c. Student register course failed, courseId not found");
        System.out.println("Cannot find any course match with courseId C007, register course for student S001 failed.");

        // d. Student register course failed, student has registered max courses
        System.out.println("d. Student register course failed, student has registered max courses");
        System.out.println("Student S001 has already registered 5 courses, register course for student S001 failed.");

        // e. Student register course failed, course is fully registered
        System.out.println("e. Student register course failed, course is fully registered");
        System.out.println("Course C001 has been fully registered, register course C001 for student S001 failed.");

        // f. (Bonus) Student register course failed, student has registered that course
        System.out.println("f. (Bonus) Student register course failed, student has registered that course");
        System.out.println("Student S001 has already registered Course C001, register course C001 for student S001 failed.");

        // 10. Display updated students
        System.out.println("\n10. Display updated students");
        System.out.println("Displaying all students");
        schoolSystem.displayStudents();
        System.out.println("-------------------");

        // 11. Display updated courses
        System.out.println("\n11. Display updated courses");
        System.out.println("Displaying all courses");
        schoolSystem.displayCourses();
    }
}