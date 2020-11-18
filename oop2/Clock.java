public class Clock {
    private int h;
    private int m;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        this.h = h;
        this.m = m;
        if (h < 0 || h > 23)
            throw new IllegalArgumentException("hours must be between 0 and 23");
        if (m < 0 || m > 59)
            throw new IllegalArgumentException("minutes must be between 0 and 59");
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        int ind = s.indexOf(':');
        String hour = s.substring(0, ind);
        h = Integer.parseInt(hour);
        String min = s.substring(ind + 1);
        m = Integer.parseInt(min);
        if (h < 0 || h > 23)
            throw new IllegalArgumentException("hours must be between 0 and 23");
        if (m < 0 || m > 59)
            throw new IllegalArgumentException("minutes must be between 0 and 59");
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", h, m);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (h < that.h) return true;
        else if (h == that.h) {
            if (m < that.m) return true;
        }
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        m = m + 1;
        if (m == 60) {
            h = h + 1;
            m = 0;
        }
        if (h == 24) {
            h = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("delta must be positive");
        int deltaH = (int) (delta / 60);
        h += deltaH;
        int deltaMin = delta % 60;
        m += deltaMin;
        if (m >= 60) {
            h = h + 1;
            m = m % 60;
        }
        if (h >= 24) {
            h = h / 24;
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock c1 = new Clock("0:0");
        StdOut.println(c1);
        //c1.tic();
        //StdOut.println(c1);
        c1.toc(30000);
        StdOut.println(c1);
        StdOut.println(c1.isEarlierThan(new Clock(23, 0)));
    }
}
