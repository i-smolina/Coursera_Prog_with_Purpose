public class ActivationFunction {
    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);

        System.out.println(getStringOut("heaviside", x, heaviside(x)));
        System.out.println(getStringOut("sigmoid", x, sigmoid(x)));
        System.out.println(getStringOut("tanh", x, tanh(x)));
        System.out.println(getStringOut("softsign", x, softsign(x)));
        System.out.println(getStringOut("sqnl", x, sqnl(x)));
    }

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x < 0) return 0;
        else {
            if (x == 0) return 0.5;
            else return 1;
        }
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        return 1 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x <= -20) return -1;
        if (x >= 20) return 1;
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x == Double.NEGATIVE_INFINITY) return -1;
        if (x == Double.POSITIVE_INFINITY) return 1;

        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x <= -2) {
            return -1;
        }
        else if (x > -2 && x < 0) {
            return x + Math.pow(x, 2) / 4;
        }
        else if (x >= 0 && x < 2) {
            return x - Math.pow(x, 2) / 4;
        }
        else return 1;
    }

    private static String getStringOut(String nameFunc, double x, double val) {
        return nameFunc + "(" + x + ") = " + val;
    }
}
