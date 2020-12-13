public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        long maxA = (long) Math.ceil(Math.cbrt(n));
        int count = 0;

        for (long i = 1; i <= maxA; i++) {
            long a3 = i * i * i;
            long b = (long) Math.ceil(Math.cbrt((n - a3)));
            if (b < 0) break;
            long s = a3 + b * b * b;
            if (n == s) {
                count++;
                if (count > 2) return true;
            }
        }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        boolean res = isRamanujan(n);
        System.out.println(res);
    }
}

