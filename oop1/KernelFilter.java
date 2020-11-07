import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] filter = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };

        Picture newPicture = applyFilter(picture, filter);
        return newPicture;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] filter = {
                { 1, 2, 1 },
                { 2, 4, 2 },
                { 1, 2, 1 }
        };
        double div = 16;

        for (int i = 0; i < filter.length; i++) {
            for (int j = 0; j < filter[i].length; j++) {
                filter[i][j] = filter[i][j] / div;
            }
        }

        Picture newPicture = applyFilter(picture, filter);
        return newPicture;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] filter = {
                { 0, -1, 0 },
                { -1, 5, -1 },
                { 0, -1, 0 }
        };
        Picture newPicture = applyFilter(picture, filter);
        return newPicture;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] filter = {
                { -1, -1, -1 },
                { -1, 8, -1 },
                { -1, -1, -1 }
        };
        Picture newPicture = applyFilter(picture, filter);
        return newPicture;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] filter = {
                { -2, -1, 0 },
                { -1, 1, 1 },
                { 0, 1, 2 }
        };
        Picture newPicture = applyFilter(picture, filter);
        return newPicture;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] filter = new double[9][9];
        int div = 9;

        for (int i = 0; i < filter.length; i++) {
            for (int j = 0; j < filter[i].length; j++) {
                if (i == j)
                    filter[i][j] = (double) 1 / div;
                else filter[i][j] = 0;
            }
        }
        Picture newPicture = applyFilter(picture, filter);
        return newPicture;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        Picture picIden = identity(pic);
        picIden.show();
        Picture picGaus = gaussian(pic);
        picGaus.show();
        Picture picSharp = sharpen(pic);
        picSharp.show();
        Picture picLapl = laplacian(pic);
        picLapl.show();
        Picture picEmb = emboss(pic);
        picEmb.show();
        Picture picMotBl = motionBlur(pic);
        picMotBl.show();
    }

    private static int getHalf(double[][] m) {
        int half = m.length / 2;
        return half;
    }

    private static int clampRGB(double val) {
        int res = (int) Math.round(val);
        if (val < 0) res = 0;
        if (val > 255) res = 255;
        return res;
    }

    private static Picture applyFilter(Picture picture, double[][] filter) {
        int delta = getHalf(filter);
        int w = picture.width();
        int h = picture.height();
        Picture newPicture = new Picture(w, h);

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                // для каждого пикселя!

                int xk = x - delta;
                int yk = y - delta;

                double sumR = 0;
                double sumG = 0;
                double sumB = 0;
                for (int i = 0; i < filter.length; i++) {
                    for (int j = 0; j < filter[i].length; j++) {
                        int xp = xk + j;
                        int yp = yk + i;
                        if (xp < 0)
                            xp = w + xp;
                        if (xp >= w)
                            xp = xp - w;
                        if (yp < 0)
                            yp = h + yp;
                        if (yp >= h)
                            yp = yp - h;

                        sumR += filter[i][j] * picture.get(xp, yp).getRed();
                        sumG += filter[i][j] * picture.get(xp, yp).getGreen();
                        sumB += filter[i][j] * picture.get(xp, yp).getBlue();
                    }
                }
                int red = clampRGB(sumR);
                int green = clampRGB(sumG);
                int blue = clampRGB(sumB);

                newPicture.set(x, y, new Color(red, green, blue));

            }
        }
        return newPicture;
    }

}
