import java.awt.Color;

public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        double halfLen = 0.5;
        StdDraw.setScale(0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0)
                    StdDraw.setPenColor(Color.BLUE);
                else StdDraw.setPenColor(Color.LIGHT_GRAY);
                StdDraw.filledSquare(i + halfLen, j + halfLen, halfLen);
            }
        }
    }
}
