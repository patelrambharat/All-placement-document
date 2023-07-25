// 1861. Rotating the Box
// Medium
// 855
// 47
// Companies
// You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:

// A stone '#'
// A stationary obstacle '*'
// Empty '.'
// The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

// It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

// Return an n x m matrix representing the box after the rotation described above.

 

// Example 1:



// Input: box = [["#",".","#"]]
// Output: [["."],
//          ["#"],
//          ["#"]]
// Example 2:



// Input: box = [["#",".","*","."],
//               ["#","#","*","."]]
// Output: [["#","."],
//          ["#","#"],
//          ["*","*"],
//          [".","."]]
// Example 3:



// Input: box = [["#","#","*",".","*","."],
//               ["#","#","#","*",".","."],
//               ["#","#","#",".","#","."]]
// Output: [[".","#","#"],
//          [".","#","#"],
//          ["#","#","*"],
//          ["#","*","."],
//          ["#",".","*"],
//          ["#",".","."]]
 

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        for (int i = 0; i < m; i++) {
            int j = n - 1, k = n - 1;
            while (true) {
                while (j >= 0 && box[i][j] != '#') {
                    if (box[i][j] == '*') k = j - 1;
                    j--;
                }
                while (k >= 0 && box[i][k] != '.') {
                    k--;
                }
                if (j < 0 || k < 0) break;
                if (k < j) {
                    j--;
                    continue;
                }
                swap(box[i], j, k);
            }
        }

        char[][] res = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = box[m - j - 1][i];
            }
        }
        return res;
    }

    public void swap(char[] box, int i, int j) {
        char tmp = box[i];
        box[i] = box[j];
        box[j] = tmp;
    }
}