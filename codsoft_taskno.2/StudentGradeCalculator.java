import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int numOfSubjects = scanner.nextInt();

        int totalMarks = 0;

        System.out.println("Enter marks for each subject (out of 100):");
        for (int i = 0; i < numOfSubjects; i++) {
            System.out.print("Subject " + (i + 1) + " marks: ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numOfSubjects;

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);

        char grade = calculateGrade(averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
