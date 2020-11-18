public class ColorHSB {
    private final int h;
    private final int s;
    private final int b;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359)
            throw new IllegalArgumentException();
        if (s < 0 || s > 100)
            throw new IllegalArgumentException();
        if (b < 0 || b > 100)
            throw new IllegalArgumentException();
        this.h = h;
        this.s = s;
        this.b = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + h + ", " + s + ", " + b + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (s == 0 || b == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null)
            throw new IllegalArgumentException();

        int minH = (int) Math.pow(Math.abs(h - that.h), 2);
        minH = Math.min(minH, (int) Math.pow(360 - Math.abs(h - that.h), 2));
        int dist = minH + (int) Math.pow(s - that.s, 2) + (int) Math.pow(b - that.b, 2);
        return dist;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        String[] lines = StdIn.readAllLines();
        ColorHSB[] colors = new ColorHSB[lines.length];
        String[] names = new String[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            String[] val = cutValueFromString(line, ' ');
            String name = val[0];
            line = val[1];

            val = cutValueFromString(line, ' ');
            int hLine = Integer.parseInt(val[0]);
            line = val[1];

            val = cutValueFromString(line, ' ');
            int sLine = Integer.parseInt(val[0]);
            line = val[1];

            val = cutValueFromString(line, ' ');
            int bLine = Integer.parseInt(val[0]);
            line = val[1];

            colors[i] = new ColorHSB(hLine, sLine, bLine);
            names[i] = name;
        }

        ColorHSB thatColors = new ColorHSB(h, s, b);
        int min = colors[0].distanceSquaredTo(thatColors);
        int indMin = 0;
        for (int i = 1; i < colors.length; i++) {
            int dist = colors[i].distanceSquaredTo(thatColors);
            if (dist < min) {
                min = dist;
                indMin = i;
            }
        }
        StdOut.println(names[indMin] + " " + colors[indMin]);
    }

    private static String[] cutValueFromString(String str, char ch) {
        String[] res = new String[2];
        int ind = str.indexOf(ch);
        String val;
        if (ind > 0) {
            val = str.substring(0, ind);
        }
        else val = str;
        res[0] = val;
        if (ind > 0)
            str = str.substring(ind);
        str = str.trim();
        res[1] = str;
        return res;
    }

}
