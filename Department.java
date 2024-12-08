import java.util.Scanner;

public abstract class Department {
    protected abstract void calculateSGPAOrCGPA(Scanner scanner);

    public void run(Scanner scanner) {
        calculateSGPAOrCGPA(scanner);
    }
}