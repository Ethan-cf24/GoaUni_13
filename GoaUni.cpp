#include <iostream>
#include <vector>
#include <string>
#include <limits> // for numeric_limits<streamsize>::max()

using namespace std;

class Student {
public:
  string studentId;
  string name;
  vector<string> enrolledCourses;

  Student(const string& studentId, const string& name) : studentId(studentId), name(name) {}

  void enrollInCourse(const string& courseName) {
    enrolledCourses.push_back(courseName);
  }
};

class GoaUniversity {
public:
  string universityName;
  vector<Student> enrolledStudents;
  vector<string> offeredCourses; // Optional

  GoaUniversity(const string& universityName) : universityName(universityName) {}

  void addStudent(const string& studentId, const string& name) {
    enrolledStudents.push_back(Student(studentId, name));
  }

  void addCourse(const string& courseName) {
    offeredCourses.push_back(courseName);
  }

  void enrollStudentInCourse(const string& studentId, const string& courseName) {
    for (Student& student : enrolledStudents) {
      if (student.studentId == studentId) {
        student.enrollInCourse(courseName);
        return;
      }
    }
    cout << "Student with ID " << studentId << " not found." << endl;
  }

  void displayAllInformation() const {
    cout << "Goa University" << endl;
    cout << "----------------" << endl;
    for (const Student& student : enrolledStudents) {
      cout << "Student ID: " << student.studentId << endl;
      cout << "Name: " << student.name << endl;
      cout << "Enrolled Courses:" << endl;
      if (student.enrolledCourses.empty()) {
        cout << "  - None" << endl;
      } else {
        for (const string& course : student.enrolledCourses) {
          cout << "  - " << course << endl;
        }
      }
      cout << endl;
    }
  }
};

int main() {
  GoaUniversity goaUniversity("Goa University");

  while (true) {
    cout << "1. Add Student" << endl;
    cout << "2. Enroll Student in Course" << endl;
    cout << "3. Display All Information" << endl;
    cout << "4. Exit" << endl;
    cout << "Choose an option: ";

    int choice;
    if (!(cin >> choice)) {
      cin.clear();
      cin.ignore(numeric_limits<streamsize>::max(), '\n');
      cout << "Invalid choice. Please enter a number." << endl;
      continue;
    }

    cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Clear newline character

    if (choice < 1 || choice > 4) {
      cout << "Invalid choice." << endl;
      continue;
    }

    switch (choice) {
      case 1: {
        string studentId, name;
        cout << "Enter student ID: ";
        getline(cin, studentId);
        cout << "Enter student name: ";
        getline(cin, name);
        goaUniversity.addStudent(studentId, name);
        break;
      }
      case 2: {
        string studentId, courseName;
        cout << "Enter student ID: ";
        getline(cin, studentId);
        cout << "Enter course name: ";
        getline(cin, courseName);
        goaUniversity.enrollStudentInCourse(studentId, courseName);
        break;
      }
      case 3:
        goaUniversity.displayAllInformation();
        break;
      case 4:
        cout << "Exiting..." << endl;
        return 0;
    }
  }

  return 0;
}