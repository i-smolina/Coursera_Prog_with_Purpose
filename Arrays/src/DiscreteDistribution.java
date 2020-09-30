public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] a = new int[n];
        for (int i = 1; i < args.length; i++)
            a[i - 1] = Integer.parseInt(args[i]);

        int[] cumS = new int[n];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            cumS[i] = sum;
        }

        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * sum);
            for (int j = 0; j < cumS.length; j++) {
                if (r < cumS[j]) {
                    System.out.print(j + 1 + " ");
                    break;
                }
            }
        }
    }
}
