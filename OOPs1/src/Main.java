import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name = null;
    private String major = null;
    private String id = null;
    private String affiliation = null;
    private String program = null;
    public Student(String name, String major, String id, String affiliation, String program) {
        this.name = name;
        this.major = major;
        this.id = id;
        this.affiliation = affiliation;
        this.program = program;
    }

    @Override
    public String toString() {
        String name = "Name:\t" + this.name;
        String id = "ID:\t" + this.id;
        String program = "Studying " + this.program + " in " + this.major;
        String affiliation = "Affiliation with " + this.affiliation;


        return String.join("\n", new ArrayList<String>(
                List.of(name, id, program, affiliation)
        ));
    }
}

class Students{
    private ArrayList<Student> students;
    private int totalStudents;

    public Students() {
        this.students = new ArrayList<Student>();
        this.totalStudents = 0;
    }

    public void addStudent(Student student){
        students.add(student);
        this.totalStudents ++;
    }

    public void displayStudents(){
        System.out.println("Total Number of Enrolled Students: " + totalStudents);

        for(int index = 1; index <= totalStudents; index++){
            System.out.println("Student #" + index);
            Student student = this.students.get(index-1);
            System.out.println(student);

        }
    }
}

public class Main {
    public static void enroll(Students students){
        System.out.println("Welcome to the University!");
        System.out.println("Please fill out the application form to enroll yourself!");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Name (First Name <space> Middle Name (optional) <space> Last Name):\n\t");
        String name = scanner.nextLine();

        System.out.print("ID (10 digit number):\n\t");
        String id = scanner.nextLine();

        System.out.print("Program (Bachelors/Masters):\n\t");
        String program = scanner.nextLine();

        System.out.print("Major (Write Full Major):\n\t");
        String major = scanner.nextLine();

        System.out.print("Affiliation (Department Name):\n\t");
        String affiliation = scanner.nextLine();

        Student newStudent = new Student(name, major, id, affiliation, program);
        students.addStudent(newStudent);
    }
    public static void main(String[] args) {
        Students students = new Students();

        enroll(students);
        enroll(students);

        students.displayStudents();
    }
}
