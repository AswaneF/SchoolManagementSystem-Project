Here is an overview of the School Management System Project and its functionalities:

1. The system supports a maximum of 5 departments.
    - Each department has a unique ID (e.g., "D001").
    - Student Management

2. The system accommodates up to 200 students.
    - Each student has a unique ID (e.g., "S001").
    - Students can register for a maximum of 5 courses.
    - Initial registration for students includes basic information, and course registration starts with an empty array.
    - Teacher Management

3. The system accommodates up to 20 teachers.
    - Each teacher has a unique ID (e.g., "T001").
    - Course Management

4. The system supports a maximum of 30 courses.
    - Each course has a unique ID (e.g., "C001").
    - Courses can be taught by one teacher and registered by a maximum of 5 students.
    - Teachers and students are not assigned during course creation.
      
      System Operations
      
      a. Add a New Department
      
      b. Add a New Student
      
      c. Add a New Teacher
      
      d. Add a New Course
      
      e. Display Departments
        - Display all non-null departments.
          
      f. Display Students
        - Display all non-null students.
        - Display student names along with course and department names if available.
          
      g. Display Teachers
        - Display all non-null teachers.
        - Display teacher names along with course and department names if available.
          
      h. Display Courses
        - Display all non-null courses.
        - Display course details including teacher, students, and department names if available.
          (Note: This method is missing in the class diagram).
          
      i. Search Department
        - Search for a department based on departmentId. Return null if not found.
          
      j. Search Teacher
        - Search for a teacher based on teacherId. Return null if not found.
          
      k. Search Course
        - Search for a course based on courseId. Return null if not found.
          
      l. Search Student
        - Search for a student based on studentId. Return null if not found.
          
      m. Assign Teacher to Course
        - Assign a teacher to a specific course based on teacherId and courseId.
        - Print a message if no teacher or course is found with the provided ids.
          
      n. Register Course for Student
        - Register a course for a student based on studentId and courseId.
        - Check if studentId or courseId doesn't match anything, and print a message.
        - Check if the student has already registered the maximum number of courses (5), and print a message.
        - Check if the course has reached the maximum number of registered students (5), and print a message.
          (Bonus) Check if the student has already registered for the course, and print a message.
        - If all conditions pass, add the course to the student's registered courses and the student to the course's registered students.
