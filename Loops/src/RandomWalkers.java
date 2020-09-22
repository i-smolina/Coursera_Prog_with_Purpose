public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int x = 0, y = 0;
        int counter = 0;
        double sum = 0;

        for (int i = 0; i < trials; i++) {
            counter = 0;
            x = 0;
            y = 0;
            while (Math.abs(x) + Math.abs(y) < r) {
                counter++;
                if (Math.random() < 0.5) { // change x
                    if (Math.random() < 0.5)
                        x = x - 1;
                    else x = x + 1;
                } else { // change y
                    if (Math.random() < 0.5)
                        y = y - 1;
                    else y = y + 1;
                }
            }
            sum = sum + counter;
        }
        double average = sum / trials;
        System.out.println("average number of steps = " + average);
    }
}
