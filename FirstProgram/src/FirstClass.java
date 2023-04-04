import java.util.Scanner;

public class FirstClass {
    public static void printPattern1(int numRows) {
        for(int i=0; i<numRows; i++){
            for(int j=0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many rows do you wanna print? ");
        int numRows = 0;
        try {
            numRows = scanner.nextInt();
        } catch (Exception e){
            System.out.println("Error: " + e.toString());
            System.out.println("Please enter a valid number");
        } finally {
            printPattern1(numRows);
        }
        scanner.close();
    }
}
