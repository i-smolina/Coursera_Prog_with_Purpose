public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);

        double r = 6371.0;
        double distance = 2 * r * Math.asin(Math.sqrt(Math.pow(Math.sin(Math.toRadians((x2 - x1) / 2)), 2)
                + Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * Math.pow(Math.sin(Math.toRadians((y2 - y1) / 2)), 2)));
        System.out.println(distance + " kilometers");
    }
}
