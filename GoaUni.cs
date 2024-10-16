using System;
using System.Collections.Generic;
using System.Scanner; // Replace with appropriate input library (e.g., Console)

class Student
{
    public string StudentId { get; set; }
    public string Name { get; set; }
    public List<string> EnrolledCourses { get; private set; } // Consider using private setter for better encapsulation

    public Student(string studentId, string name)
    {
        this.StudentId = studentId;
        this.Name = name;
        this.EnrolledCourses = new List<string>();
    }

    public void EnrollInCourse(string courseName)
    {
        EnrolledCourses.Add(courseName);
    }
}

class GoaUniversity
{
    public string UniversityName { get; set; }
    public List<Student> EnrolledStudents { get; private set; } // Consider using private setter for better encapsulation
    public List<string> OfferedCourses { get; set; } // Optional

    public GoaUniversity(string universityName)
    {
        this.UniversityName = universityName;
        this.EnrolledStudents = new List<Student>();
        this.OfferedCourses = new List<string>();
    }

    public void AddStudent(string studentId, string name)
    {
        Student student = new Student(studentId, name);
        EnrolledStudents.Add(student);
    }

    public void AddCourse(string courseName)
    {
        OfferedCourses.Add(courseName);
    }

    public void EnrollStudentInCourse(string studentId, string courseName)
    {
        foreach (Student student in EnrolledStudents)
        {
            if (student.StudentId == studentId)
            {
                student.EnrollInCourse(courseName);
                return;
            }
        }
        Console.WriteLine($"Student with ID {studentId} not found.");
    }

    public void DisplayAllInformation()
    {
        Console.WriteLine($"Goa University");
        Console.WriteLine("----------------");
        foreach (Student student in EnrolledStudents)
        {
            Console.WriteLine($"Student ID: {student.StudentId}");
            Console.WriteLine($"Name: {student.Name}");
            Console.WriteLine("Enrolled Courses:");
            if (!student.EnrolledCourses.Any())
            {
                Console.WriteLine("  - None");
            }
            else
            {
                foreach (string course in student.EnrolledCourses)
                {
                    Console.WriteLine($"  - {course}");
                }
            }
            Console.WriteLine();
        }
    }
}

class GoaUniversityMain
{
    static void Main(string[] args)
    {
        GoaUniversity goaUniversity = new GoaUniversity("Goa University");

        while (true)
        {
            Console.WriteLine("1. Add Student");
            Console.WriteLine("2. Enroll Student in Course");
            Console.WriteLine("3. Display All Information");
            Console.WriteLine("4. Exit");
            Console.Write("Choose an option: ");

            int choice;
            try
            {
                choice = int.Parse(Console.ReadLine());
            }
            catch (FormatException)
            {
                Console.WriteLine("Invalid choice. Please enter a number.");
                continue;
            }

            if (choice < 1 || choice > 4)
            {
                Console.WriteLine("Invalid choice.");
                continue;
            }

            switch (choice)
            {
                case 1:
                    Console.Write("Enter student ID: ");
                    string studentId = Console.ReadLine();
                    Console.Write("Enter student name: ");
                    string name = Console.ReadLine();
                    goaUniversity.AddStudent(studentId, name);
                    break;
                case 2:
                    Console.Write("Enter student ID: ");
                    studentId = Console.ReadLine();
                    Console.Write("Enter course name: ");
                    string courseName = Console.ReadLine();
                    goaUniversity.EnrollStudentInCourse(studentId, courseName);
                    break;
                case 3:
                    goaUniversity.DisplayAllInformation();
                    break;
                case 4:
                    Console.WriteLine("Exiting...");
                    Environment.Exit(0);
                default:
                    break;
            }
        }
    }
}