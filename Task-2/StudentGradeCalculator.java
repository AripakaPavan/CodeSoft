import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numOfSubjects = sc.nextInt();
        int[] marks = new int[numOfSubjects];

        for (int i = 0; i < numOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
        }
        int totalMarks = calculateTotalMarks(marks);
        double avgPercentage = calculateAveragePercentage(totalMarks, numOfSubjects);
        String grade = calculateGrade(avgPercentage);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avgPercentage + "%");
        System.out.println("Grade: " + grade);
    }

    private static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}