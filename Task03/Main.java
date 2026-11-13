import java.util.*;

public class Main {

    static ArrayList<String> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        books.add("Java Programming");
        books.add("Data Structures");
        books.add("Database Systems");
        books.add("Computer Networks");
        books.add("Operating Systems");

        System.out.println("===== CAMPUS LIBRARY SEARCH =====");
        System.out.println("Categories: All, Programming, Science, Technology");
        System.out.print("Enter book name to search: ");
        String search = sc.nextLine().trim();

        System.out.println("\nSearch Results:");

        int count = 0;
        for (String book : books) {
            if (book.toLowerCase().contains(search.toLowerCase())) {
                System.out.println((++count) + ". " + book);
            }
        }

        if (count == 0) {
            System.out.println("No books found.");
        }

        System.out.println("\n1. Prev");
        System.out.println("2. Next");
        System.out.println("3. Reserve");
        System.out.print("Choose an option: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Previous page selected.");
                break;
            case 2:
                System.out.println("Next page selected.");
                break;
            case 3:
                System.out.println("Reservation request submitted.");
                break;
            default:
                System.out.println("Invalid option.");
        }

        System.out.println("\nLibrary operation completed.");
        sc.close();
    }
}
