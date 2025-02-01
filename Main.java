import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] A = generateMatrix(n);
        int[][] B = generateMatrix(n);

        System.out.println("Matrix A:");
        printMatrix(A);

        System.out.println("Matrix B:");
        printMatrix(B);

        long startTime = System.nanoTime();
        System.out.println("Start Time (ns): " + startTime);

        int[][] C = matrixMultiply(A, B, n);

        long endTime = System.nanoTime();
        System.out.println("End Time (ns): " + endTime);

        System.out.println("\nMatrix C (Result):");
        printMatrix(C);

        double elapsedTime = (endTime - startTime) / 1e6;
        System.out.println("Time taken: " + elapsedTime + " ms");
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static int[][] matrixMultiply(int[][] A, int[][] B, int n) {
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
