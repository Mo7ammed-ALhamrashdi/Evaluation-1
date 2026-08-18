package main;

import entities.Student;
import entities.SeniorStudent;
import services.StudentService;
import utils.InputHandler;

public class SchoolApp {

    private StudentService studentService =
            new StudentService();

    private InputHandler input =
            new InputHandler();

    public static void main(String[ ] args) {

        SchoolApp app = new SchoolApp();

        app.loadSampleData();

        app.run();
    }

    public void run(  ) {

        boolean exit  =  false;

        while (exit  ==  false) {

            printMenu( );

            int choice =
                    input.getIntInput(
                            "Choose :",
                            1,
                            4
                    );

            switch (choice) {

                case 1:
                    addStudent( );
                    break;

                case 2:
                    viewAllStudents( );
                    break;

                case 3:
                    searchStudent ();
                    break;

                case 4:
                    exit = true;
                    break;
            }
        }

        System.out.println("--Good bye.See You Soon--");
    }

    private void printMenu() {

        System.out.println();

        System.out.println(
                "<... School Menu ...>"
        );

        System.out.println(
                "1. Add New student"
        );

        System.out.println(
                "2. View all students"
        );

        System.out.println(
                "3. Search student by id"
        );

        System.out.println(
                "4. Exit"
        );
    }

    private void addStudent() {

        String first =
                input.getStringInput(
                        "-First name:"
                );

        String last =
                input.getStringInput(
                        "--Last name:"
                );

        String Grade =
                input.getStringInput(
                        "--grade:"
                );
        String Id =
                input.getStringInput(
                        "--id:");
        Student s =
                studentService.addStudent(
                        first,
                        last,
                        Id,Grade
                );

        System.out.println(
                "--Added: "
                        + s.displaySummary()
        );
    }

    private void viewAllStudents() {

        System.out.println(
                "- All students -"
        );

        for (Student s :
                studentService.getAll()) {

            s.displayInfo();
        }
    }

    private void searchStudent() {

        String id =
                input.getStringInput(
                        "--Enter your id:"
                );

        Student s =
                studentService.searchById(id);

        if (s == null) {

            System.out.println(
                    "--No student with that id.--"
            );

        } else {

            s.displayInfo();
        }
    }

    public void loadSampleData() {

        studentService.addStudent(
                "Ali",
                "Khan",
                "90000211"
        );

        studentService.addStudent(
                "Layla",
                "Balushi",
                "90000112",
                "Grade 9"
        );

        SeniorStudent senior =
                new SeniorStudent(
                        "STU-90",
                        "Maryam",
                        "Said",
                        "2005-02-15",
                        "Female",
                        "90000323",
                        "maryam@school.om",
                        "Salalah",
                        "Grade 12",
                        "2024-01-01",
                        100.0,
                        "Science",
                        3.8
                );

        studentService.add(senior);
    }
}
