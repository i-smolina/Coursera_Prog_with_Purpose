public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);

        int x = 0, y = 0;
        int counter = 0;
        
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
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + counter);
    }
}
