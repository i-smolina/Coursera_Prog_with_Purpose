import java.awt.Color;

public class RecursiveSquares {
    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
        double half = length / 2;
        StdDraw.setPenColor(Color.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, half);
        StdDraw.setPenColor(Color.black);
        StdDraw.square(x, y, half);
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;
        double half = length / 2;
        draw(n - 1, x - half, y + half, half);
        draw(n - 1, x + half, y + half, half);
        drawSquare(x, y, length);
        draw(n - 1, x - half, y - half, half);
        draw(n - 1, x + half, y - half, half);
    }

    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }
}
