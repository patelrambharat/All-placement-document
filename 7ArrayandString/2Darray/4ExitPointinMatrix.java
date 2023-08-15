// // Given a binary matrix of size N x M, you enter the matrix at cell (0, 0) in the left to the right direction. 
// // Whenever encountering a 0  retain in the same direction if encountered a 1 change direction to the right of the current 
// // direction and change that 1 value to 0,  find out exit point from the Matrix.

// // Examples: 

// // Input: matrix = {{0, 1, 0},

// //                    {0, 1, 1},

//                 //   {0, 0, 0}}
// // Output: 1 0
// // Explanation: 
// // Enter the matrix at 0, 0 -> then move towards 0, 1 ->  1 is encountered -> turn right towards 1, 
// // 1 -> again 1 is encountered -> turn right again towards 1, 0 -> now, the boundary of matrix will be 
// // crossed ->hence, exit point reached at 1, 0.

// Approach:  Since the matrix is entered at 0, 0 position the approach to solve this problem is based on the following observations

// Initially, a matrix is entered at 0, 0 and moved towards the right.
// As soon as 1 is encountered the direction is turned 90 degree clockwise i.e, right -> down -> left -> up.
// Keep traversing the matrix in an above-mentioned manner till a boundary is reached.
// As soon as the boundary is reached and no turn is encountered, the boundary will be crossed and the exit point will be the last cell traversed.

// Java program for the above approach
import java.util.*;
class GFG {

// Function to find the exit
// point in a given matrix
public static int[] FindExitPoint(int[][] matrix)
{
	// initialization of row, column
	int i = 0, j = 0;
	int dir = 0;

	while (true) {
	dir = (dir + matrix[i][j]) % 4;

	// If a cell is traversed
	// then mark it has 0
	if (matrix[i][j] == 1) {
		matrix[i][j] = 0;
	}
	// Right direction
	if (dir == 0) {
		j++;
	}
	// Down direction
	else if (dir == 1) {
		i++;
	}
	// Left direction
	else if (dir == 2) {
		j--;
	}
	// Up direction
	else if (dir == 3) {
		i--;
	}

	// decrement either the row or col
	// since it crossed the boundary
	if (i < 0) {
		i++;
		break;
	}
	else if (i == matrix.length) {
		i--;
		break;
	}
	else if (j < 0) {
		j++;
		break;
	}
	else if (j == matrix[0].length) {
		j--;
		break;
	}
	}

	// return row and column
	int[] v = new int[] { i, j };
	return v;
}

// Driver Code
public static void main(String[] args)
{

	int[][] matrix = new int[][] { { 0, 1, 0 },
								{ 0, 1, 1 },
								{ 0, 0, 0 } };
	int[] exitPoints = FindExitPoint(matrix);

	System.out.println(exitPoints[0] + " "
					+ exitPoints[1]);

}
}

// This code is contributed by rakeshsahni
