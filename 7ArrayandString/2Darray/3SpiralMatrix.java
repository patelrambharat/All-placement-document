// Print a given matrix in spiral form
// Read
// Discuss(360+)
// Courses
// Practice
// Video

// Given a 2D array, print it in spiral form.

// Examples: 

// Input:  {{1,    2,   3,   4},
//               {5,    6,   7,   8},
//              {9,   10,  11,  12},
//             {13,  14,  15,  16 }}
// Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
// Explanation: The output is matrix in spiral format. 


// Input: { {1,   2,   3,   4,  5,   6},
//            {7,   8,   9,  10,  11,  12},
//           {13,  14,  15, 16,  17,  18}}


// Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
// Explanation: The output is matrix in spiral format.


class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int row =matrix.size();
        int col = matrix[0].size();
        int count =0;
        int total = row * col;
        int startrow =0;
        int startcol =0;
        int endrow = row -1;
        int endcol = col-1;
        vector<int>ans;
        while(count< total){
            for(int i=startcol ;count< total && i<=endcol;i++){
                ans.push_back(matrix[startrow][i]);
                count++;
            }
            startrow++;
            
            for(int i= startrow;count< total && i<=endrow;i++){
                ans.push_back(matrix[i][endcol]);
                count++;
            }
            endcol--;
            
            for(int i= endcol ;count< total && i>= startcol ;i--){
                ans.push_back(matrix[endrow][i]);
                count++;
            }
            endrow--;
            
            for(int i=endrow ;count< total && i>= startrow ;i--){
                ans.push_back(matrix[i][startcol]);
                count++;
            }
            startcol++;
        }
        return ans;
    }
};

