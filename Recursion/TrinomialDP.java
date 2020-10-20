public class TrinomialDP {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long res = trinomial(n, k);
        StdOut.println(res);
    }

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (k < 0) k = Math.abs(k);
        long[][] a = new long[n + 1][n + 2];
        a[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int indL = j - 1;
                if (indL < 0)
                    indL = Math.abs(indL);
                a[i][j] = a[i - 1][indL] + a[i - 1][j] + a[i - 1][j + 1];
            }
        }
        return a[n][k];
    }
}
