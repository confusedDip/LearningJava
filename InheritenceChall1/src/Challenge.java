public class Challenge {
    public static void main(String[] args) {
        SalariedEmployee emp = new SalariedEmployee("Souradip Nath", "2000",
                "2024", 1225226964, "2023", 28440.00, false);

        System.out.println("Age of the employee: " + emp.getAge());
        System.out.println("Before Retirement");
        System.out.println(emp);

        System.out.println("After Retirement");
        emp.retire();
        System.out.println(emp);
    }
}
