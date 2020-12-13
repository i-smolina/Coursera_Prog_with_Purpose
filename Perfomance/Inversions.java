public class Inversions {
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) count++;
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = i;

        for (int i = 0; i < n; i++) {
            if (k >= n - i - 1) {
                int temp = a[n - 1];
                for (int j = n - 1; j > i; j--) {
                    a[j] = a[j - 1];
                }
                a[i] = temp;
                k = k - (n - i - 1);
            }

            if (k < n - i - 1) {
                int temp = a[n - 1];
                for (int j = n - 1; j >= n - k; j--) {
                    a[j] = a[j - 1];
                }
                int ind = (int) (n - k - 1);
                a[ind] = temp;
                break;
            }
        }
        return a;
    }


    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        int[] a = generate(n, k);
        printArray(a);
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
}
