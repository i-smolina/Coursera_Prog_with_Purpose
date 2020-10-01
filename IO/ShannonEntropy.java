public class ShannonEntropy {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] a = new int[n + 1];
        int count = 0;

        while (!StdIn.isEmpty()) {
            int c = StdIn.readInt();
            a[c] += 1;
            count++;
        }

        double h = 0;
        for (int i = 1; i < a.length; i++) {
            double p = (double) a[i] / count;
            double log = 0;
            if (p != 0)
                log = Math.log10(p) / Math.log10(2);
            h += p * log;
        }
        h *= -1;
        StdOut.printf("%.4f", h);
    }
}
