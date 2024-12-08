# VTU CGPA and SGPA Calculator (Scheme 2022)

## Project Overview
A Java-based application designed to calculate *CGPA* and *SGPA* for students of various engineering departments based on the VTU 2022 scheme. The program features a menu-driven interface and leverages *Object-Oriented Programming (OOP)* principles to ensure modularity and scalability.

## Features
- Menu-driven interface for user-friendly navigation.
- Supports multiple departments: *CSE, CSE-AIML, ISE, Aeronautical, ECE*.
- Robust error handling for invalid inputs using try-catch blocks.
- Hierarchical class structure:
  - *Base class*: Department
  - *Derived classes*: CSE, CSE_AIML, ISE, Aeronautical, ECE
- Calculates *CGPA* and *SGPA* for students based on user input.
- Ensures input validation for accurate results.

## Technologies Used
- *Programming Language*: Java
- *Concepts*: Object-Oriented Programming (OOP), Exception Handling, Inheritance
- *Tools*: IntelliJ IDEA, Git

## Prerequisites

Before running this program, ensure you have the following:

- Java Development Kit (JDK) installed (version 8 or higher).
- An Integrated Development Environment (IDE) such as:
  - [BlueJ](https://www.bluej.org/) - A simple IDE for beginners.
  - [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) - A powerful IDE with more advanced features.

## Downloading the IDE

To download and install your preferred IDE:

1. For BlueJ:
   - Visit the [BlueJ download page](https://www.bluej.org/).
   - Select your operating system and follow the installation instructions.

2. For IntelliJ IDEA:
   - Go to the [IntelliJ IDEA download page](https://www.jetbrains.com/idea/download/).
   - Choose the Community edition for free use and follow the installation steps.



## Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or later
- IntelliJ IDEA or any other Java IDE
- Git (optional for version control)

### Installation
1. Clone the repository:
   bash
   git clone https://github.com/aleenaharoldpeter/vtu-cgpa-calculator.git
2. Open the project in your Java IDE.
3. Compile the code:
   bash
    javac Main.java
   
4. Run the application:
   bash
   java Main
   
## Usage
1. Launch the program.
2. Select your department from the menu.
3. Enter your grades for the respective subjects.
4. The program will calculate and display your CGPA and SGPA.
## Directory Structure
```bash
vtu-cgpa-calculator/
├── Department.java
├── CSE.java
├── CSE_AIML.java
├── ISE.java
├── Aeronautical.java
├── ECE.java
├── Main.java
├── README.md
└── .gitignore
```
## Example Output
```bash
--------------------------------------------------------------
Do you want to calculate SGPA or CGPA?
1: SGPA
2: CGPA
3: Exit
--------------------------------------------------------------
Enter your choice: 1

Select your department:
1: CSE
2: CSE AIML
3: ISE
4: Aeronautical Engineering
5: ECE
Enter your choice: 1

Enter the number of subjects: 5
Enter the grade points for each subject:
Subject 1: 8.5
Subject 2: 7.8
Subject 3: 9.0
Subject 4: 8.3
Subject 5: 7.9

Your SGPA is: 8.30
```
## Contributing
Contributions are welcome! Follow these steps to contribute:

1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-branch
   ```
3. Make your changes and commit them:
   ```bash
   git commit -m "Add new feature"
   ```
4. Push to the branch:
   ```bash
   git push origin feature-branch
   ```
5. Submit a pull request.
## Future Plans

We aim to expand the scope and accessibility of this project by:

### Developing an Android App:
- Creating an intuitive mobile application for easier access and use on the go.
- Leveraging tools like Android Studio and integrating modern UI/UX design principles.

### Making the Project Open Source:
- Hosting the code on GitHub to allow contributions from the global developer community.
- Encouraging collaboration to keep the project updated with new features and improvements.

These future developments will ensure the tool remains relevant and beneficial for VTU students and beyond.

## License
This project is licensed under the MIT License.
## Contact

For any questions, suggestions, or feedback, feel free to reach out:

- *Name*: Aleena Harold Peter  
- *Email*: [aleenaharoldpeter120@gmail.com](mailto:aleenaharoldpeter120@gmail.com)  
- *LinkedIn*: https://www.linkedin.com/in/aleena-harold-peter