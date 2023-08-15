// // Wave Traversal - Question | 2-D Arrays | Data Structures and Algorithms in JAVA


// Given a matrix mat[][], print it in Wave Form. 

// Input: mat[][] = {{  1,   2,   3,   4}
//                            {  5,   6,   7,   8}
//                            {  9, 10, 11, 12}
//                            {13, 14, 15, 16}
//                            {17, 18, 19, 20}}
// Output: 1 5 9 13 17 18 14 10 6 2 3 7 11 15 19 20 16 12 8 4 
// Explanation: Output is printed in wave form. 

// Input: mat[][] = {{1,   9,  4, 10}
//                           { 3,   6, 90, 11}
//                           { 2, 30, 85, 72}
//                           { 6, 31, 99, 15}} 
// Output: 1 3 2 6 31 30 6 9 4 90 85 99 15 72 11 10

// Java program for above approach
import java.io.*;
class 2WaveTraversal {

public static int R = 5;
public static int C = 4;

// Function to print wave
// Form for a given matrix
public static void WavePrint(int m, int n, int[][] arr)
{
	
	// Loop to traverse matrix
	for (int j = 0; j < n; j++) {

	// If the current column
	// is even indexed, print
	// it in forward order
	if (j % 2 == 0) {
		for (int i = 0; i < m; i++) {
		System.out.print(arr[i][j] + " ");
		}
	}

	// If the current column
	// is odd indexed, print
	// it in reverse order
	else {
		for (int i = m - 1; i >= 0; i--) {
		System.out.print(arr[i][j] + " ");
		}
	}
	}
}

// Driver Code
public static void main (String[] args)
{
	int[][] arr = { { 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 },
				{ 17, 18, 19, 20 } };

	WavePrint(R, C, arr);
}
}

// This code is contributed by Shubham Singh
