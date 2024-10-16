import sys

class Student:
  def __init__(self, student_id, name):
    self.student_id = student_id
    self.name = name
    self.enrolled_courses = []  # List of course names

  def get_student_id(self):
    return self.student_id

  def get_name(self):
    return self.name

  def get_enrolled_courses(self):
    return self.enrolled_courses  # Direct access (not recommended)

  def enroll_in_course(self, course_name):
    self.enrolled_courses.append(course_name)

class GoaUniversity:
  def __init__(self, university_name):
    self.university_name = university_name
    self.enrolled_students = []
    self.offered_courses = []  # List of course names (optional)

  def get_university_name(self):
    return self.university_name

  def get_enrolled_students(self):
    return self.enrolled_students  # Direct access (not recommended)

  def add_student(self, student_id, name):
    student = Student(student_id, name)
    self.enrolled_students.append(student)

  def add_course(self, course_name):
    self.offered_courses.append(course_name)  # Optional

  def enroll_student_in_course(self, student_id, course_name):
    for student in self.enrolled_students:
      if student.student_id == student_id:
        student.enroll_in_course(course_name)
        return
    print(f"Student with ID {student_id} not found.")

  def display_all_information(self):
    print(f"Goa University")
    print("----------------")
    for student in self.enrolled_students:
      print(f"Student ID: {student.student_id}")
      print(f"Name: {student.name}")
      print(f"Enrolled Courses:")
      if not student.enrolled_courses:
        print("  - None")
      else:
        for course in student.enrolled_courses:
          print(f"  - {course}")
      print()

def main():
  goa_university = GoaUniversity("Goa University")

  while True:
    print("1. Add Student")
    print("2. Enroll Student in Course")
    print("3. Display All Information")
    print("4. Exit")
    print("Choose an option: ", end="")

    try:
      choice = int(input())
    except ValueError:
      print("Invalid choice. Please enter a number.")
      continue

    if choice not in range(1, 5):
      print("Invalid choice.")
      continue

    if choice == 1:
      student_id = input("Enter student ID: ")
      name = input("Enter student name: ")
      goa_university.add_student(student_id, name)
    elif choice == 2:
      student_id = input("Enter student ID: ")
      course_name = input("Enter course name: ")
      goa_university.enroll_student_in_course(student_id, course_name)
    elif choice == 3:
      goa_university.display_all_information()
    else:
      print("Exiting...")
      sys.exit(0)

if __name__ == "__main__":
  main()