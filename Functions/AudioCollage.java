public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] res = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = alpha * a[i];
        }
        return res;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        int len = a.length;
        double[] res = new double[len];
        for (int i = 0; i < a.length; i++) {
            res[len - i - 1] = a[i];
        }
        return res;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] res = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++)
            res[i] = a[i];
        int aLen = a.length;
        for (int i = 0; i < b.length; i++)
            res[i + aLen] = b[i];
        return res;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] c1, c2;
        if (a.length <= b.length) {
            c1 = a;
            c2 = b;
        }
        else {
            c1 = b;
            c2 = a;
        }
        double[] res = new double[c2.length];
        for (int i = 0; i < c1.length; i++)
            res[i] = c1[i] + c2[i];
        for (int i = c1.length; i < c2.length; i++)
            res[i] = c2[i];
        return res;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int len = (int) (a.length / alpha);
        double[] res = new double[len];
        for (int i = 0; i < res.length; i++) {
            int ind = (int) (i * alpha);
            res[i] = a[ind];
        }
        return res;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] a1 = StdAudio.read("piano.wav");
        double[] a2 = reverse(a1);
        double[] a3 = merge(a1, a2);
        double[] a4 = StdAudio.read("singer.wav");
        double[] a5 = changeSpeed(a4, 1.3);
        double[] a6 = merge(a3, a5);
        double[] a7 = StdAudio.read("beatbox.wav");
        double[] a8 = StdAudio.read("chimes.wav");
        double[] a9 = mix(a7, a8);
        double[] a10 = merge(a6, a9);
        double[] a11 = StdAudio.read("exposure.wav");
        double[] a12 = amplify(a11, 5);
        double[] a13 = merge(a10, a12);

        StdAudio.play(a13);
    }
}
