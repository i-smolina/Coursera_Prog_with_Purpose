public class Divisors {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int gcd = gcd(a, b);
        StdOut.println("gcd(" + a + "," + b + ") = " + gcd);
        int lcm = lcm(a, b);
        StdOut.println("lcm(" + a + "," + b + ") = " + lcm);
        boolean relat = areRelativelyPrime(a, b);
        StdOut.println("areRelativelyPrime(" + a + "," + b + ") = " + relat);
        int totientA = totient(a);
        StdOut.println("totient(" + a + ") = " + totientA);
        int totientB = totient(b);
        StdOut.println("totient(" + b + ") = " + totientB);
    }

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) return a + b;

        while (a != 0 && b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0) return 0;
        int gcd = gcd(a, b);
        return a / gcd * b;
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        int t = gcd(a, b);
        if (t == 1) return true;
        else return false;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (areRelativelyPrime(i, n)) count++;
        }
        return count;
    }
}
