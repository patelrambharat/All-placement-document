// 1.	Find All Groups of Farmland - LeetCode
// 2.	Sum of distance in tree
// 3.	Evaluate Division - LeetCode
// 4.	Minimum Number of K Consecutive Bit Flips - LeetCode
// 5.	https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/
// 6.	https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/



// 1992. Find All Groups of Farmland

class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> result = new ArrayList<>(); // List to store the coordinates of farmland groups

        // Iterate over each cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) { // If cell represents farmland
                    int[] farmland = findFarmlandHelper(land, i, j); // Find the coordinates of the farmland group
                    result.add(farmland); // Add the farmland coordinates to the result list
                }
            }
        }

        // Convert the result list to a 2D array
        int[][] output = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output; // Return the resulting 2D array of farmland coordinates
    }

    private int[] findFarmlandHelper(int[][] land, int row, int col) {
        int m = land.length;
        int n = land[0].length;
        int[] farmland = new int[4]; // Array to store the coordinates of the farmland group
        farmland[0] = row; // Set the top left corner row coordinate
        farmland[1] = col; // Set the top left corner column coordinate

        // Find the bottom right corner of the farmland group
        int i = row;
        while (i < m && land[i][col] == 1) { // Move downwards until encountering non-farmland cells
            i++;
        }
        farmland[2] = i - 1; // Set the bottom right corner row coordinate

        int j = col;
        while (j < n && land[row][j] == 1) { // Move towards the right until encountering non-farmland cells
            j++;
        }
        farmland[3] = j - 1; // Set the bottom right corner column coordinate

        // Mark the visited farmland cells as 0 (non-farmland)
        for (int r = row; r <= farmland[2]; r++) {
            for (int c = col; c <= farmland[3]; c++) {
                land[r][c] = 0;
            }
        }

        return farmland; // Return the coordinates of the farmland group
    }
}
class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> result = new ArrayList<>(); // List to store the coordinates of farmland groups

        // Iterate over each cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) { // If cell represents farmland
                    int[] farmland = findFarmlandHelper(land, i, j); // Find the coordinates of the farmland group
                    result.add(farmland); // Add the farmland coordinates to the result list
                }
            }
        }

        // Convert the result list to a 2D array
        int[][] output = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output; // Return the resulting 2D array of farmland coordinates
    }

    private int[] findFarmlandHelper(int[][] land, int row, int col) {
        int m = land.length;
        int n = land[0].length;
        int[] farmland = new int[4]; // Array to store the coordinates of the farmland group
        farmland[0] = row; // Set the top left corner row coordinate
        farmland[1] = col; // Set the top left corner column coordinate

        // Find the bottom right corner of the farmland group
        int i = row;
        while (i < m && land[i][col] == 1) { // Move downwards until encountering non-farmland cells
            i++;
        }
        farmland[2] = i - 1; // Set the bottom right corner row coordinate

        int j = col;
        while (j < n && land[row][j] == 1) { // Move towards the right until encountering non-farmland cells
            j++;
        }
        farmland[3] = j - 1; // Set the bottom right corner column coordinate

        // Mark the visited farmland cells as 0 (non-farmland)
        for (int r = row; r <= farmland[2]; r++) {
            for (int c = col; c <= farmland[3]; c++) {
                land[r][c] = 0;
            }
        }

        return farmland; // Return the coordinates of the farmland group
    }
}
