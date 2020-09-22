public class CMYKtoRGB {
    public static void main(String[] args) {
        double c = Double.parseDouble(args[0]);
        double m = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);
        double k = Double.parseDouble(args[3]);

        long white = Math.round(1 - k);
        long red = Math.round(255 * white * (1 - c));
        long green = Math.round(255 * white * (1 - m));
        long blue = Math.round(255 * white * (1 - y));

        System.out.println("red = " + red);
        System.out.println("green = " + green);
        System.out.println("blue = " + blue);
    }
}
