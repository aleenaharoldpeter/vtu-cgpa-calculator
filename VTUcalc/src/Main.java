import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\f"); // Clear screen - Optional, might not work everywhere.
            System.out.println("--------------------------------------------------------------");
            System.out.println("Do you want to calculate SGPA or CGPA?");
            System.out.println("1: SGPA");
            System.out.println("2: CGPA");
            System.out.println("3: Exit");

            try {
                int choice = scanner.nextInt(); // Get main choice

                switch (choice) {
                    case 1: { // SGPA Calculation
                        System.out.println("Select your department:");
                        System.out.println("1: CSE");
                        System.out.println("2: CSE AIML");
                        System.out.println("3: ISE");
                        System.out.println("4: Aeronautical Engineering");
                        System.out.println("5: ECE");

                        try {
                            int departmentChoice = scanner.nextInt();
                            Department department = null;

                            switch (departmentChoice) {
                                case 1:
                                    department = new CSE();
                                    break;
                                case 2:
                                    department = new CSE_AIML();
                                    break;
                                case 3:
                                    department = new ISE();
                                    break;
                                case 4:
                                    department = new AeronauticalEngineering();
                                    break;
                                case 5:
                                    department = new ECE();
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    continue; // Restart loop for valid department
                            }

                            // Run SGPA calculation for the selected department
                            department.run(scanner);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine(); // Clear invalid input
                        }
                        break;
                    }

                    case 2: { // CGPA Calculation
                        try {
                            System.out.println("Enter the number of semesters:");
                            int semNum = scanner.nextInt();
                            System.out.println("Enter the department:\n1. CSE\n2. CSE AIML\n3. ISE\n4. Aeronautical Engineering\n5. ECE");
                            int dep = scanner.nextInt();

                            double weightedTotal = 0.0;
                            double totalCredits = 0.0;

                            // Department-specific credits for CGPA calculation
                            int[] credits1 = {20, 20, 21, 19, 22, 18, 24, 16}; // Example credits for CSE/CSE AIML/ISE
                            int[] credits2 = {20, 20, 20, 20, 22, 18, 24, 16}; // Example credits for Aeronautical/ECE

                            switch (dep) {
                                case 1: // CSE/CSE AIML/ISE
                                case 2:
                                case 3:
                                    for (int i = 0; i < semNum; i++) {
                                        System.out.println("Enter the SGPA for semester " + (i + 1) + ":");
                                        double sgpa = scanner.nextDouble();
                                        weightedTotal += sgpa * credits1[i];
                                        totalCredits += credits1[i];
                                    }
                                    double avg = weightedTotal / totalCredits;
                                    System.out.printf("The CGPA for %d semester(s) is %.2f\n", semNum, avg);
                                    break;

                                case 4: // Aeronautical Engineering
                                case 5: // ECE
                                    for (int i = 0; i < semNum; i++) {
                                        System.out.println("Enter the SGPA for semester " + (i + 1) + ":");
                                        double sgpa = scanner.nextDouble();
                                        weightedTotal += sgpa * credits2[i];
                                        totalCredits += credits2[i];
                                    }
                                    double avg2 = weightedTotal / totalCredits;
                                    System.out.printf("The CGPA for %d semester(s) is %.2f\n", semNum, avg2);
                                    break;

                                default:
                                    System.out.println("Invalid department choice.");
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.nextLine(); // Clear invalid input
                        }
                        break;
                    }

                    case 3: { // Exit
                        System.out.println("Exiting the program...");
                        scanner.close();
                        System.exit(0);
                    }

                    default:
                        System.out.println("Invalid choice. Please choose 1 for SGPA, 2 for CGPA, or 3 to Exit.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
}
