public class MaximumSquareSubmatrix {
    public static void main(String[] args) {
        int[][] m = readMatrixFromInput();
        int count = size(m);
        StdOut.println(count);
    }

    private static int[][] readMatrixFromInput() {
        int n = StdIn.readInt();
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = StdIn.readInt();
            }
        }
        return m;
    }

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int n = a.length;
        int[][] buf = new int[n][n];
        int countMax = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 < 0 || j - 1 < 0) {
                    buf[i][j] = a[i][j];
                }
                else {
                    if (a[i][j] == 0) buf[i][j] = 0;
                    else {
                        boolean isOne = true;
                        int countPrev = buf[i - 1][j - 1];
                        for (int i1 = i - countPrev; i1 < i; i1++) {
                            if (a[i1][j] == 0) {
                                isOne = false;
                                break;
                            }
                        }
                        if (isOne) {
                            for (int j1 = j - countPrev; j1 < j; j1++) {
                                if (a[i][j1] == 0) {
                                    isOne = false;
                                    break;
                                }
                            }
                        }

                        if (isOne) {
                            int countCur = countPrev + 1;
                            buf[i][j] = countCur;
                            if (countCur > countMax)
                                countMax = countCur;
                        }
                        else buf[i][j] = 1;
                    }
                }
            }
        }
        // for (int i = 0; i < buf.length; i++) {
        //     for (int j = 0; j < buf[i].length; j++) {
        //         StdOut.print(buf[i][j] + " ");
        //     }
        //     StdOut.println();
        // }
        return countMax;
    }
}
