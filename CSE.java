import java.util.Scanner;

public class CSE extends Department {

    @Override
    protected void calculateSGPAOrCGPA(Scanner scanner) {
    System.out.println("Do you want to calculate SGPA or CGPA?");
        System.out.println("1: SGPA");
        System.out.println("2: CGPA");
        String choice = scanner.next();

        if (choice.equals("1")) {
            System.out.println("Enter the semester you want to check the SGPA for:");
            System.out.println("1: Physics Cycle");
            System.out.println("2: Chemistry Cycle");
            System.out.println("3: 3rd Semester");
            System.out.println("4: 4th Semester");
            System.out.println("5: 5th Semester");
            System.out.println("6: 6th Semester");
            System.out.println("7: 7th Semester");
            System.out.println("8: 8th Semester");

            String semesterChoice = scanner.next();
            switch (semesterChoice) {
                case "1":
                    calculateAndDisplaySGPA(scanner, getPhysicsSubjects(), getPhysicsCredits(), "Physics Cycle");
                    break;
                case "2":
                    calculateAndDisplaySGPA(scanner, getChemistrySubjects(), getChemistryCredits(), "Chemistry Cycle");
                    break;
                case "3":
                    calculateAndDisplaySGPA(scanner, getSemesterSubjects(3), getSemesterCredits(3), "3rd Semester");
                    break;
                case "4":
                    calculateAndDisplaySGPA(scanner, getSemesterSubjects(4), getSemesterCredits(4), "4th Semester");
                    break;
                case "5":
                    calculateAndDisplaySGPA(scanner, getSemesterSubjects(5), getSemesterCredits(5), "5th Semester");
                    break;
                case "6":
                    calculateAndDisplaySGPA(scanner, getSemesterSubjects(6), getSemesterCredits(6), "6th Semester");
                    break;
                case "7":
                    calculateAndDisplaySGPA(scanner, getSemesterSubjects(7), getSemesterCredits(7), "7th Semester");
                    break;
                case "8":
                    calculateAndDisplaySGPA(scanner, getSemesterSubjects(8), getSemesterCredits(8), "8th Semester");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } else if (choice.equals("2")) {
            double totalSGPA = 0;
            int totalCredits = 0;

            for (int i = 1; i <= 8; i++) {
                String semesterName = i == 1 ? "Physics Cycle" : (i == 2 ? "Chemistry Cycle" : i + " Semester");
                String[] subjects = (i == 1) ? getPhysicsSubjects() :
                                   (i == 2) ? getChemistrySubjects() :
                                   getSemesterSubjects(i);
                int[] credits = (i == 1) ? getPhysicsCredits() :
                                (i == 2) ? getChemistryCredits() :
                                getSemesterCredits(i);

                double sgpa = calculateSGPA(scanner, subjects, credits);
                totalSGPA += sgpa * getTotalCredits(credits);
                totalCredits += getTotalCredits(credits);
            }

            double cgpa = totalSGPA / totalCredits;
            System.out.printf("Your CGPA is: %.2f\n", cgpa);
        } else {
            System.out.println("Invalid choice. Please try again.");
        }

        scanner.close();
    }

    private static double calculateSGPA(Scanner scanner, String[] subjects, int[] credits) {
        int totalCredits = 0;
        int totalGradePoints = 0;
        String[][] results = new String[subjects.length][4]; 

        for (int i = 0; i < subjects.length; i++) {
            String[] subjectDetails = subjects[i].split(",");
            String subjectCode = subjectDetails[0];
            String subjectName = subjectDetails[1];
            int credit = credits[i];

            System.out.printf("Subject Code: %s, Subject Name: %s, Credits: %d\n", subjectCode, subjectName, credit);
            System.out.print("Enter Marks (0-100): ");
            double marks = scanner.nextDouble();
            int gradePoint = calculateGradePoint(marks);

            totalCredits += credit;
            totalGradePoints += gradePoint * credit;

            String result = (gradePoint >= 4) ? "P" : "F"; 
            results[i][0] = subjectCode;
            results[i][1] = subjectName;
            results[i][2] = String.valueOf(marks);
            results[i][3] = result;
        }

        System.out.printf("%-15s | %-50s | %-10s | %-10s\n", "Subject Code", "Subject Name", "Marks", "Result");
        System.out.println("---------------------------------------------------------------------");
        for (String[] row : results) {
            System.out.printf("%-15s | %-50s | %-10s | %-10s\n", row[0], row[1], row[2], row[3]);
        }

        return (double) totalGradePoints / totalCredits;
    }

    private static int calculateGradePoint(double marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else if (marks >= 40) return 5;
        else if (marks >= 33) return 4;
        else return 0;
    }

    private static void calculateAndDisplaySGPA(Scanner scanner, String[] subjects, int[] credits, String semesterName) {
        double sgpa = calculateSGPA(scanner, subjects, credits);
        System.out.printf("Your SGPA for %s is: %.2f\n", semesterName, sgpa);
    }

    private static String[] getPhysicsSubjects() {
        return new String[]{
            "BMATSx01,Mathematics - 1 for CSE Stream",
            "BPHYSx02,Applied Physics for CSE",
            "BPOPSx03,Principles of Programming Using C",
            "BESCKx04X,Engineering Science Course-I",
            "BETCKx05x/BPLCKx05x,Emerging Technology Course - I/II OR Programming Language Course-I/II",
            "BENGKx06/BPWSKx06,Communicative English OR Professional Writing Skills in English",
            "BKSKKx07/BKBKKx07,Balake Kannada OR Samskrutika Kannada OR Indian Constitution",
            "BIDTKx58/BSFHx58,Innovation And Design Thinking OR Scientific Foundations of Health"
        };
    }

    private static int[] getPhysicsCredits() {
        return new int[]{4, 4, 3, 3, 3, 1, 1, 1};
    }

    private static String[] getChemistrySubjects() {
        return new String[]{
            "BMATSx01,Mathematics - I/II for CSE Stream",
            "BCHESx02,Applied Chemistry for CSE Stream",
            "BCEDKx03,Computer-Aided Engineering Stream",
            "BESCKx04x,Engineering Science Course - I/II",
            "BETCKx05x/BPLCKx05x,Emerging Technology Course - I/II OR Programming Language Course",
            "BENGKx06/BPWSKx06,Communicative English OR Professional Writing Skills in English",
            "BKSKKx07/BKBKKx07,Balake Kannada OR Samskrutika Kannada OR Indian Constitution",
            "BIDTKx58/BSFHx58,Innovation And Design Thinking OR Scientific Foundations of Health"
        };
    }

    private static int[] getChemistryCredits() {
        return new int[]{4, 4, 3, 3, 3, 1, 1, 1};
    }

    private static String[] getSemesterSubjects(int semester) {
        switch (semester) {
            case 3:
                return new String[]{
                    "BCS301,Mathematics for Computer Science",
                    "BCS302,Digital Design & Computer Organization",
                    "BCS303,Operating Systems",
                    "BCS304,Data Structures and Applications",
                    "BCSL305,Data Structures Lab",
                    "BCS306x,ESC/ETC/PLC",
                    "BSCK307,Social Connect and Responsibility",
                    "BCS358x,Ability Enhancement Course/Skill Enhancement Course-III",
                    "BNSK359/BPEK359/BYOK359,NSS/PE/Yoga"
                };
            case 4:
                return new String[]{
                    "BCS401,Analysis & Design of algorithms",
                    "BCS402,Microcontrollers",
                    "BCS403,Database Management Systems",
                    "BCSL404,Analysis & Design of algorithms Lab",
                    "BCS405x,ESC/ETC/PLC",
                    "BCS358x,Ability Enhancement Course/Skill Enhancement Course-III",
                    "BBOK407,Biology For Engineers",
                    "BUHK408,Universal Human Values Course",
                    "BNSK459/BPEK459/BYOK459,NSS/PE/Yoga"
                };
            case 5:
                return new String[]{
                    "BCS501,Software Engineering & Project Management",
                    "BCS502,Computer Networks",
                    "BCS503,Theory of Computation",
                    "BCS504,Web Technology Lab",
                    "BCS515x,Professional Elective Course",
                    "BCS586,Mini Project",
                    "BRMK557,Research Methodology and IPR",
                    "BESK508,Environmental Studies",
                    "BNSK559/BPEK559/BYOK559,NSS/PE/Yoga"
                };
            case 6:
                return new String[]{
                    "BCS601,Cloud Computing(Open Stack/Google)",
                    "BCS602,Machine Learning",
                    "BCS613x,Professional Elective Course",
                    "BCS654x,Open Elective Course",
                    "BCS685,Project Phase I",
                    "BCSL606,Machine Learning Lab",
                    "BCS657x,Ability Enhancement Course/Skill Enhancement Course-III",
                    "BNSK658/BPEK658/BYOK658,NSS/PE/Yoga"
                };
            case 7:
                return new String[]{
                    "BCS701,Internet of Things",
                    "BCS702,Parallel Computing",
                    "BCS703,Cryptography & Network Security",
                    "BCS714x,Professional Elective Course",
                    "BCS755x,Open Elective Course",
                    "BCS786,Major Project Phase II"
                };
            case 8:
                return new String[]{
                    "BCS801x,Professional Elective (Online Courses) Only through NPTEL",
                    "BCS802x,Open Elective (Online Courses) Only through NPTEL",
                    "BCS803,Internship(Industry/Research)",
                };
            default:
                return new String[]{};
        }
    }

    private static int[] getSemesterCredits(int semester) {
        switch (semester) {
            case 3:
                return new int[]{4, 4, 4, 3, 1, 3, 1, 1, 0};
            case 4:
                return new int[]{3, 4, 4, 1, 3, 1, 2, 1, 0};
            case 5:
                return new int[]{3, 4, 4, 1, 3, 2, 3, 2, 0};
            case 6:
                return new int[]{4, 4, 3, 3, 2, 1, 1, 0};
            case 7:
                return new int[]{4, 4, 4, 3, 3, 6};
            case 8:
                return new int[]{3, 3, 10};
            default:
                return new int[]{};
        }
    }

    private static int getTotalCredits(int[] credits) {
        int total = 0;
        for (int credit : credits) {
            total += credit;
        }
        return total;
    }
}

