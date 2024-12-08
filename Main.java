import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your department:");
        System.out.println("1: CSE");
        System.out.println("2. CSE AIML");
        System.out.println("3. ISE");
        System.out.println("4: Aeronautical Engineering");
        System.out.println("5. ECE");
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
                scanner.close();
                return; // Exit if invalid choice
        }
        department.run(scanner);
        scanner.close();
    }
}
