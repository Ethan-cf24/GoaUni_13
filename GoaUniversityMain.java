import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a student with an ID, name, and list of enrolled courses.
 */
class Student {
    String studentId;
    String name;
    List<String> enrolledCourses;

    /**
     * Constructs a new Student with the specified ID and name.
     * 
     * @param studentId The student's ID.
     * @param name      The student's name.
     */
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    /**
     * Returns the student's ID.
     * 
     * @return The student's ID.
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Returns the student's name.
     * 
     * @return The student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the list of courses the student is enrolled in.
     * 
     * @return The list of enrolled courses.
     */
    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * Enrolls the student in a specified course.
     * 
     * @param courseName The name of the course to enroll in.
     */
    public void enrollInCourse(String courseName) {
        enrolledCourses.add(courseName);
    }
}

/**
 * Represents a university with a list of enrolled students and offered courses.
 */
class GoaUniversity {
    String universityName;
    List<Student> enrolledStudents;
    List<String> offeredCourses;

    /**
     * Constructs a new GoaUniversity with the specified name.
     * 
     * @param universityName The name of the university.
     */
    public GoaUniversity(String universityName) {
        this.universityName = universityName;
        this.enrolledStudents = new ArrayList<>();
        this.offeredCourses = new ArrayList<>();
    }

    /**
     * Returns the name of the university.
     * 
     * @return The name of the university.
     */
    public String getUniversityName() {
        return universityName;
    }

    /**
     * Returns the list of students enrolled at the university.
     * 
     * @return The list of enrolled students.
     */
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    /**
     * Adds a new student to the university.
     * 
     * @param studentId The ID of the student.
     * @param name      The name of the student.
     */
    public void addStudent(String studentId, String name) {
        Student student = new Student(studentId, name);
        enrolledStudents.add(student);
    }

    /**
     * Adds a new course to the list of offered courses.
     * 
     * @param courseName The name of the course.
     */
    public void addCourse(String courseName) {
        offeredCourses.add(courseName);
    }

    /**
     * Enrolls a student in a specified course.
     * 
     * @param studentId  The ID of the student to enroll.
     * @param courseName The name of the course.
     */
    public void enrollStudentInCourse(String studentId, String courseName) {
        for (Student student : enrolledStudents) {
            if (student.studentId.equals(studentId)) {
                student.enrolledCourses.add(courseName);
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    /**
     * Displays all information about the students and their enrolled courses.
     */
    public void displayAllInformation() {
        System.out.println("Goa University");
        System.out.println("----------------");
        for (Student student : enrolledStudents) {
            System.out.println("Student ID: " + student.studentId);
            System.out.println("Name: " + student.name);
            System.out.println("Enrolled Courses:");
            if (student.enrolledCourses.isEmpty()) {
                System.out.println("  - None");
            } else {
                for (String course : student.enrolledCourses) {
                    System.out.println("--->" + course);
                }
            }
            System.out.println();
        }
    }
}

/**
 * Main class for running the GoaUniversity application.
 */
public class GoaUniversityMain {
    /**
     * Entry point of the application.
     * 
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        GoaUniversity goaUniversity = new GoaUniversity("Goa University");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Enroll Student in Course");
            System.out.println("3. Display Information");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    goaUniversity.addStudent(studentId, name);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    studentId = scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    goaUniversity.enrollStudentInCourse(studentId, courseName);
                    break;
                case 3:
                    goaUniversity.displayAllInformation();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
