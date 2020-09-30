public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        boolean[][] a = new boolean[m][n];  // A boolean 2D array to specify which cells contain mines
        int[][] b = new int[m + 2][n + 2];  // An integer 2D array to count the number of neighboring mine

        for (int i = 0; i < k; i++) {   // Choose k cells to contain mines
            int row = i / n;
            int col = i % n;
            a[row][col] = true;
        }

        for (int i = 0; i < m; i++)     // Use the shuffling algorithm to rearrange the k mines uniformly at random
            for (int j = 0; j < n; j++) {
                int r = (int) (Math.random() * (((m - i) * n) - j - 1));
                r = r + i * n + j;
                boolean t = a[i][j];
                int i1 = r / n;
                int j1 = r % n;
                a[i][j] = a[i1][j1];
                a[i1][j1] = t;
            }

        for (int i = 0; i < m; i++) {   // Count the number of neighboring mines
            for (int j = 0; j < n; j++) {
                if (a[i][j]) {
                    int ib = i + 1;
                    int jb = j + 1;
                    b[ib + 1][jb + 1] = 0;
                    b[ib - 1][jb - 1] = b[ib - 1][jb - 1] + 1;
                    b[ib - 1][jb] = b[ib - 1][jb] + 1;
                    b[ib - 1][jb + 1] = b[ib - 1][jb + 1] + 1;
                    b[ib][jb - 1] = b[ib][jb - 1] + 1;
                    b[ib][jb + 1] = b[ib][jb + 1] + 1;
                    b[ib + 1][jb - 1] = b[ib + 1][jb - 1] + 1;
                    b[ib + 1][jb] = b[ib + 1][jb] + 1;
                    b[ib + 1][jb + 1] = b[ib + 1][jb + 1] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {   // Print the results
            for (int j = 0; j < n; j++) {
                if (a[i][j]) System.out.print("*  ");
                else {
                    System.out.print(b[i + 1][j + 1] + "  ");
                }
            }
            System.out.println();
        }
    }
}
