 import java.util.ArrayList;

public class Student {
    private int studentID;
    private String name;
    private ArrayList<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        course.enrollStudent();
        System.out.println(name + " registered for course: " + course.getTitle());
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.removeStudent();
            System.out.println(name + " dropped course: " + course.getTitle());
        } else {
            System.out.println(name + " is not registered for course: " + course.getTitle());
        }
    }

    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Registered Courses:");
        for (Course course : registeredCourses) {
            System.out.println(course.getTitle());
        }
    }
}
