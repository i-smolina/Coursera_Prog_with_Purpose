public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // the smallest power of 2 larger than n
        int x = (int) Math.ceil((Math.log(n) / Math.log(2)));
        boolean[] seq = new boolean[(int) Math.pow(2, x)];

        // build the Thue–Morse sequence
        for (int i = 0; i < x; i++) {
            int calc = (int) Math.pow(2, i); // count of the Thue–Morse sequences
            for (int j = 0; j < calc; j++) {
                seq[j + calc] = !seq[j];
            }
        }
        // print an n-by-n matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (seq[i] == seq[j]) System.out.print("+  ");
                else System.out.print("-  ");
            }
            System.out.println();
        }
    }
}
