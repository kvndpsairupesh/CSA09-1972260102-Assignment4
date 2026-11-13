import java.util.*;

public class Main {

    static ArrayList<Point> points = new ArrayList<>();

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void repaint() {
        System.out.println("\n===== DRAWING PAD =====");

        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            System.out.println("Dot " + (i + 1) +
                    " at (" + p.x + ", " + p.y + ")");
        }

        System.out.println("Clicks: " + points.size());
        System.out.println("=======================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== DRAW PAD =====");
        System.out.println("Enter -1 to finish.");

        while (true) {
            System.out.print("\nEnter X coordinate: ");
            int x = sc.nextInt();

            if (x == -1) {
                break;
            }

            System.out.print("Enter Y coordinate: ");
            int y = sc.nextInt();

            points.add(new Point(x, y));

            System.out.println("Point stored successfully.");
            repaint();
        }

        System.out.println("\nDrawing completed.");
        System.out.println("Total clicks: " + points.size());

        sc.close();
    }
}
