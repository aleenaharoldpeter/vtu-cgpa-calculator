import java.util.Scanner;
public class ECE extends Department {
    @Override
    protected void calculateSGPAOrCGPA(Scanner scanner) {
            System.out.println("Enter the semester you want to check the SGPA for:");
            System.out.println("1: Physics Cycle");  // Changed order to prioritize Physics
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
        }
    private static double calculateSGPA(Scanner scanner, String[] subjects, int[] credits) {
        int totalCredits = 0;
        int totalGradePoints = 0;
        String[][] results = new String[subjects.length][4]; // To store subject code, name, marks, and result
        // Input marks and calculate grade points
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

            String result = (gradePoint >= 4) ? "P" : "F"; // Pass or Fail
            results[i][0] = subjectCode;
            results[i][1] = subjectName;
            results[i][2] = String.valueOf(marks);
            results[i][3] = result;
        }
         System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-30s | %-75s | %-5s | %-7s | \n", "Subject Code", "Subject Name", "Marks", "Result");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        for (String[] row : results) {
            System.out.printf("%-30s | %-75s | %-5s | %-7s |\n", row[0], row[1], row[2], row[3]);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

        // Calculate SGPA
        return (double) totalGradePoints / totalCredits;
    }
    private static int calculateGradePoint(double marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else if (marks >= 40) return 5;
        else if (marks >= 33) return 4; // Pass
        else return 0; // Fail
    }
    private static void calculateAndDisplaySGPA(Scanner scanner, String[] subjects, int[] credits, String semesterName) {
        double sgpa = calculateSGPA(scanner, subjects, credits);
        System.out.printf("Your SGPA for %s is: %.2f\n", semesterName, sgpa);
    }
    private static String[] getPhysicsSubjects() {
        return new String[] {
            "BMATEx01,MATHEMATICS - I/II for EEE Stream",
            "BPHYEx02,Applied Physics for EEE Stream",
            "BEEEx03,Elements of Electrical Engineering",
            "BESCKx04x,Engineering Science Course - I/II",
            "BETCKx05x,Emerging Technology Course - I/II",
            "BENGKx06,Communicative English",
            "BKSKKx07,Samskrutika Kannada/Balake Kannada",
            "BIDTKx58,Innovation and Design Thinking"
        };
    }
    private static int[] getPhysicsCredits() {
        return new int[]{4, 4, 3, 3, 3, 1, 1, 1};
    }
    private static String[] getChemistrySubjects() {
        return new String[] {
            "BMATEx01,Mathematics - I/II for EEE Stream",
            "BCHEEx02,Applied Chemistry for EEE Stream",
            "BCEDKx03,Computer-Aided Engineering Drawing",
            "BESCKx04x,Engineering Science Course - I/II",
            "BETCKx05x,Emerging Technology Course - I/II",
            "BENGKx06,Communicative English",
            "BKSKKx07,Samskrutika Kannada/Balake Kannada",
            "BIDTKx58,Innovation and Design Thinking"
        };
    }

    private static int[] getChemistryCredits() {
        return new int[]{4, 4, 3, 3, 3, 1, 1, 1};
    }

    private static String[] getSemesterSubjects(int semester) {
        switch (semester) {
            case 3:
                return new String[] {
                    "BMATEC301,AV Mathematics - III for EC Engineering",
                    "BEC302,Digital System Design using Verilog",
                    "BEC303,Electronic Principles and Circuits",
                    "BEC304,Network Analysis",
                    "BECL305,Analog and Digital Systems Design Lab",
                    "BXX306x,ESC/ETC/PLC",
                    "BSCK307,Social Connect and Responsibility",
                    "BXX358x,Ability Enhancement Course / Skill Enhancement Course III",
//                    "BNSK359,NSS / PE / Yoga"
                };
            case 4:
                return new String[] {
                    "BEC401,Engineering Electromagnetics",
                    "BEC402,Basic Signal Processing",
                    "BEC403,Principles of communication Systems",
                    "BECL404,Communication Laboratory",
                    "BEC405x,ESC / ETC / PLC",
                    "BXX456x,Ability Enhancement Course/Skill Enhancement Course - IV",
                    "BBOK407,Biology For Engineers",
                    "BUHK408,Universal human values course",
//                    "BNSK459,NSS/ PE/ Yoga"
                };
            case 5:
                return new String[] {
                    "BEC501,Technological Innovation and Management Entrepreneurship", // Placeholder for actual subject name
                    "BEC502,Digital Signal Processing", // Placeholder for actual subject name
                    "BEC503,Digital Communication", // Placeholder for actual subject name
                    "BECL504,Digital Communication Lab", // Placeholder for actual subject name
                    "BEC515x,Professional Elective Course",
                    "BEC586,Mini Project",
                    "BRMK557,Research Methodology and IPR",
                    "BESK508,Environmental Studies",
//                    "BNSK559/BPEK559/BYOK559,NSS/PE/Yoga"
                };
            case 6:
                return new String[] {
                    "BEC601,Embedded System Design",
                    "BEC602,VLSI Design and Testing",                    "BEC603,Subject Name", // Placeholder for actual subject name
                    "BEC613x,Professional Elective Course", // Placeholder for actual subject name
                    "BEC654x,Open Elective Course",
                    "BEC685,Major Project Phase I",
                    "BECL606,VLSI Design and Testing Lab",
                    "BEC657x,Ability Enhancement Course/Skill Development Course V",
//                    "BNSK658/BPEK658 /BYOK658,NSS/PE/Yoga",
//                    "BIKS609,Indian Knowledge System"
                };
            case 7:
                return new String[] {
                    "BEC701,Microwave Engineering and Antenna Theory", // Placeholder for actual subject name
                    "BEC702,Computer Networks and Protocols", // Placeholder for actual subject name
                    "BEC703,Wireless Communication Systems", // Placeholder for actual subject name
                    "BEC714x,Professional Elective Course", // Placeholder for actual subject name
                    "BEC755x,Open Elective Course",
                    "BEC786,Major Project Phase-II"
                };
            case 8:
                return new String[] {
                    "BEC801,Subject Name", // Placeholder for actual subject name
                    "BEC802,Subject Name", // Placeholder for actual subject name
                    "BEC803,Subject Name", // Placeholder for actual subject name
                    "BECL804,Subject Name", // Placeholder for actual subject name
                    "BEC805x,ESC / ETC / PLC",
                    "BXX856x,Ability Enhancement Course/Skill Enhancement Course - VIII",
                    "BNSK857,NSS / PE / Yoga"
                };
            default:
                return new String[0];
        }
    }
    private static int[] getSemesterCredits(int semester) {
        switch (semester) {
            case 3:
                return new int[]{3, 4, 4, 3, 1, 3, 1, 1, 0};
            case 4:
                return new int[]{3, 4, 4, 1, 3, 1, 3, 1, 0};
            case 5:
                return new int[]{3, 4, 4, 1, 3, 2, 3, 2, 0};
            case 6:
                return new int[]{4, 4, 3, 3, 2, 1, 1, 0, 0};
            case 7:
                return new int[]{4, 4, 4, 3, 3, 6};
            case 8:
                return new int[]{3, 3, 10};
            default:
                return new int[0];
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
