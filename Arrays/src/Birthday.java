public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        boolean[] bool_birth = new boolean[n];
        int[] count_birth = new int[n + 2];

        for (int i = 0; i < trials; i++) {
            for (int j = 0; j < bool_birth.length; j++) bool_birth[j] = false;
            int count = 1;
            while (true) {
                int r = (int) (Math.random() * n);      // Choose a birthday for the next person, uniformly at random between 0 and n−1
                if (bool_birth[r]) {                    // If that person shares a birthday with someone else in the room, stop
                    count_birth[count] = count_birth[count] + 1;
                    break;
                } else {
                    bool_birth[r] = true;
                    count++;
                }
            }
        }

        double stop_fraction = 0.5;
        for (int i = 1; i < count_birth.length; i++) {
            double fraction = 0;
            for (int j = 0; j <= i; j++) {
                fraction = fraction + count_birth[j];
            }
            fraction = fraction / trials;
            System.out.println(i + "\t" + count_birth[i] + "\t" + fraction);
            if (fraction > stop_fraction)
                break;
        }
    }
}
