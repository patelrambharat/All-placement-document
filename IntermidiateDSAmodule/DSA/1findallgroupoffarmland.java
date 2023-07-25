// 1992. Find All Groups of Farmland
// Medium
// 719
// 22
// Companies
// You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.

// To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland. These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.

// land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of land is (m-1, n-1). Find the coordinates of the top left and bottom right corner of each group of farmland. A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].

// Return a 2D array containing the 4-length arrays described above for each group of farmland in land. If there are no groups of farmland, return an empty array. You may return the answer in any order.

 

// Example 1:


// Input: land = [[1,0,0],[0,1,1],[0,1,1]]
// Output: [[0,0,0,0],[1,1,2,2]]
// Explanation:
// The first group has a top left corner at land[0][0] and a bottom right corner at land[0][0].
// The second group has a top left corner at land[1][1] and a bottom right corner at land[2][2].
// Example 2:


// Input: land = [[1,1],[1,1]]
// Output: [[0,0,1,1]]
// Explanation:
// The first group has a top left corner at land[0][0] and a bottom right corner at land[1][1].


class Solution {
    private int bottom , right;
    public void dfs(int land[][] , int r, int c){
        if(r < 0 || c< 0 || r >= land.length || c >= land[0].length || land[r][c] == 0){
            return;
        }
        land[r][c] = 0;
        bottom = Math.max(bottom , r);
        right = Math.max(right, c);
        dfs(land , r+1, c);
        dfs(land , r , c+1);
    }
    public int[][] findFarmland(int[][] land) {
        ArrayList<ArrayList<Integer>>res = new ArrayList<>();
        for(int i=0;i<land.length;i++){
            for(int j = 0;j<land[0].length;j++){
                if(land[i][j] == 1){      //means top left corner
                ArrayList<Integer>temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                bottom = i;
                right = j;
                dfs(land, i, j);
               
                temp.add(bottom);
                temp.add(right);
                res.add(temp); 
                }      
                }
        }
        int ans[][] = new int[res.size()][4];
        for(int i=0;i<ans.length;i++){
            for(int j= 0;j<ans[0].length;j++){
                ans[i][j] = res.get(i).get(j);
            }
        }
        return ans;
    }
}