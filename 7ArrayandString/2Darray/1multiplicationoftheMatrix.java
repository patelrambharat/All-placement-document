// // // Multiplying A and B where the shape of A is 3 x 2 (meaning it has 3 rows 
// // and 2 columns) and the shape of B is 2 x 4 (meaning it has 2 rows and 4 columns) is possible because both the conditions mentioned above hold.
//  If the shape of A was 3 x 3 and
// //  the shape of B was 2 x 4, the matrix multiplication would not be possible.


// Here A = [{3, 4}, {2, 1}], B = [{1, 5}, {3, 7}]. The product of A and B is C. 
// The C(i, j) entry in matrix C can be calculated as the dot product of row i of A and column j of B.

// Example: C(1,1) = 3 * 1 + 4 * 3 = 15.


// C(1,1) = dotProduct( row(A, 1), col(B, 1) )
// C(1,2) = dotProduct( row(A, 1), col(B, 2) )
// C(2,1) = dotProduct( row(A, 2), col(B, 1) )
// C(2,2) = dotProduct( row(A, 2), col(B, 2) ) 

import java.util.Scanner;

public class MatrixMultiplicationExample {

  public static void main(String args[]) {
    int row1, col1, row2, col2;
    Scanner s = new Scanner(System.in);

    // Input dimensions of First Matrix: A
    System.out.print("Enter number of rows in first matrix: ");
    row1 = s.nextInt();

    System.out.print("Enter number of columns in first matrix: ");
    col1 = s.nextInt();

    // Input dimensions of second matrix: B
    System.out.print("Enter number of rows in second matrix: ");
    row2 = s.nextInt();

    System.out.print("Enter number of columns in second matrix: ");
    col2 = s.nextInt();

    // Requirement check for matrix multiplication
    if (col1 != row2) {
      System.out.println("Matrix multiplication is not possible");
      return;
    }

    int a[][] = new int[row1][col1];
    int b[][] = new int[row2][col2];
    int c[][] = new int[row1][col2];

    // Input the values of matrices
    System.out.println("\nEnter values for matrix A : ");
    for (int i = 0; i < row1; i++) {
      for (int j = 0; j < col1; j++) a[i][j] = s.nextInt();
    }
    System.out.println("\nEnter values for matrix B : ");
    for (int i = 0; i < row2; i++) {
      for (int j = 0; j < col2; j++) b[i][j] = s.nextInt();
    }

    // Perform matrix multiplication
    // Using for loop
    System.out.println("\nMatrix multiplication is : ");
    for (int i = 0; i < row1; i++) {
      for (int j = 0; j < col2; j++) {
        // Initialize the element C(i,j) with zero
        c[i][j] = 0;

        // Dot product calculation
        for (int k = 0; k < col1; k++) {
          c[i][j] += a[i][k] * b[k][j];
        }
        
        System.out.print(c[i][j] + " ");
      }
      System.out.println();
    }
  }
}
