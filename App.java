import java.util.Scanner;

public class App {
    public static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix (" + rows + "x" + cols + "):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B, int n, int m, int p) {
        int[][] C = new int[n][p];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                C[i][j] = 0;
                for (int k = 0; k < m; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    // Method to display matrix
    public static void displayMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input dimensions of Matrix A
            System.out.print("Enter the number of rows of Matrix A: ");
            int n = scanner.nextInt();
            System.out.print("Enter the number of columns of Matrix A: ");
            int m = scanner.nextInt();

            // Input dimensions of Matrix B
            System.out.print("Enter the number of rows of Matrix B: ");
            int m2 = scanner.nextInt();
            System.out.print("Enter the number of columns of Matrix B: ");
            int p = scanner.nextInt();

            // Validate matrix dimensions for multiplication
            if (m != m2) {
                System.out.println("The number of columns in Matrix A must be equal to the number of rows in Matrix B.");
                return;
            }

            // Input matrices
            int[][] A = readMatrix(scanner, n, m);
            int[][] B = readMatrix(scanner, m, p);

            // Multiply matrices
            int[][] C = multiplyMatrices(A, B, n, m, p);

            // Display result
            System.out.println("Matrix C:");
            displayMatrix(C, n, p);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numeric values only.");
        } finally {
            scanner.close();
        }
    }
}
