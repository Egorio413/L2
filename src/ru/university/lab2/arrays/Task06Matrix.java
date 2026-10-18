package ru.university.lab2.arrays;

public class Task06Matrix {
    public void run() {
        int[][] m = createAndFill(3, 4);
        printMatrix("Исходная", m);
        printMatrix("Транспонированная", transpose(m));

        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] r = multiply(a, b);
        if (r != null) printMatrix("A × B", r);

        int[][] bad = multiply(new int[][]{{1,2,3}}, new int[][]{{1,2,3}});
        if (bad == null) System.out.println("\nУмножение невозможно: размеры не согласованы");
    }

    private int[][] createAndFill(int rows, int cols) {
        int[][] m = new int[rows][cols];
        int v = 1;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) m[i][j] = v++;
        return m;
    }

    private void printMatrix(String label, int[][] m) {
        System.out.println("\n" + label + " ");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) System.out.printf("%4d", m[i][j]);
            System.out.println();
        }
    }

    private int[][] transpose(int[][] m) {
        int[][] r = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++) r[j][i] = m[i][j];
        return r;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        if (a[0].length != b.length) return null;
        int[][] r = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < b.length; k++) sum += a[i][k] * b[k][j];
                r[i][j] = sum;
            }
        return r;
    }
}