import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some sample courses
        Course course1 = new Course("CS101", "Introduction to Programming", "Learn programming basics", 3);
        Course course2 = new Course("MATH201", "Calculus", "Advanced calculus", 2);

        // Create a list to store courses
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);

        // Create a sample student
        Student student1 = new Student(1, "Harshvardhan");

        // Course registration system
        while (true) {
            System.out.println("\n1. View available courses");
            System.out.println("2. Register for a course");
            System.out.println("3. Drop a course");
            System.out.println("4. View student details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayCourses(courseList);
                    break;
                case 2:
                    registerCourse(student1, courseList, scanner);
                    break;
                case 3:
                    dropCourse(student1, scanner);
                    break;
                case 4:
                    student1.displayStudentDetails();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }

    // Method to display available courses
    public static void displayCourses(ArrayList<Course> courseList) {
        System.out.println("\nAvailable Courses:");
        for (Course course : courseList) {
            course.displayCourseDetails();
            System.out.println("------------------------------");
        }
    }

    // Method for student registration
    public static void registerCourse(Student student, ArrayList<Course> courseList, Scanner scanner) {
        displayCourses(courseList);
        System.out.print("Enter the course code to register: ");
        String courseCode = scanner.next();

        Course selectedCourse = null;
        for (Course course : courseList) {
            if (course.getCourseCode().equals(courseCode)) {
                selectedCourse = course;
                break;
            }
        }

        if (selectedCourse != null) {
            student.registerCourse(selectedCourse);
        } else {
            System.out.println("Invalid course code.");
        }
    }

    // Method for dropping a course
    public static void dropCourse(Student student, Scanner scanner) {
        student.displayStudentDetails();
        System.out.print("Enter the course code to drop: ");
        String courseCode = scanner.next();

        Course selectedCourse = null;
        for (Course course : student.getRegisteredCourses()) {
            if (course.getCourseCode().equals(courseCode)) {
                selectedCourse = course;
                break;
            }
        }

        if (selectedCourse != null) {
            student.dropCourse(selectedCourse);
        } else {
            System.out.println("Course not found in registered courses.");
        }
    }
}
