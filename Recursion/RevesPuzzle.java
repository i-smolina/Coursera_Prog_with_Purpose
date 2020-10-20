public class RevesPuzzle {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");
    }

    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (n == 0 || n <= k) return;
        hanoi(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }

    // move n smallest discs from one pole to another, using the temp pole
    private static void reves(int n, String from, String temp1, String temp2, String to) {
        if (n == 1) {
            System.out.println("Move disc " + n + " from " + from + " to " + to);
            return;
        }
        // if (n == 0) return;
        int k = (int) Math.round(1.0 + n - Math.sqrt(1.0 + 2 * n));
        // if (k == 1) return;
        reves(n - 1, "A", "D", "C", "B");
        //System.out.println("n = " + n + ", k = " + k);
        //System.out.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n, k, "A", "C", "D");
        reves(k, "B", "A", "C", "D");

    }


}
