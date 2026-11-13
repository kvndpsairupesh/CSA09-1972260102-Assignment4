import java.util.*;

public class Main {

    static class Registration {
        String studentId, name, event;

        Registration(String studentId, String name, String event) {
            this.studentId = studentId;
            this.name = name;
            this.event = event;
        }
    }

    static ArrayList<Registration> registrations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== CAMPUS EVENT REGISTRATION =====");
            System.out.println("1. Register Student");
            System.out.println("2. View Registrations");
            System.out.println("3. Filter by Event");
            System.out.println("4. Export Registrations");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Event Name: ");
                    String event = sc.nextLine();

                    if (id.isEmpty() || name.isEmpty() || event.isEmpty()) {
                        System.out.println("Invalid input. All fields are required.");
                        break;
                    }

                    boolean duplicate = false;

                    for (Registration r : registrations) {
                        if (r.studentId.equalsIgnoreCase(id)
                                && r.event.equalsIgnoreCase(event)) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println("Duplicate registration not allowed.");
                    } else {
                        registrations.add(new Registration(id, name, event));
                        System.out.println("Registration successful!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- ALL REGISTRATIONS ---");
                    for (Registration r : registrations) {
                        System.out.println(r.studentId + " | "
                                + r.name + " | " + r.event);
                    }
                    if (registrations.isEmpty()) {
                        System.out.println("No registrations found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter event to filter: ");
                    String filter = sc.nextLine();

                    for (Registration r : registrations) {
                        if (r.event.equalsIgnoreCase(filter)) {
                            System.out.println(r.studentId + " | "
                                    + r.name + " | " + r.event);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Export feature demonstrated.");
                    System.out.println("Total registrations: " + registrations.size());
                    break;

                case 5:
                    System.out.println("Application closed.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
