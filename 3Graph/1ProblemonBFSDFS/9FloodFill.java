// Flood Fill Algorithm – Graphs
// Problem Statement: An image is represented by a 2-D array of integers, each integer representing the pixel value of the image. Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, “flood fill” the image.

// To perform a “flood fill”, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same colour as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same colour as the starting pixel), and so on. Replace the colour of all of the aforementioned pixels with the newColor.

// Pre-req: Connected Components, Graph traversal techniques

// Example 1:

// Input:

// sr = 1, sc = 1, newColor = 2

// Output: 
 
// Explanation:


// From the centre of the image 
// (with position (sr, sc) = (1, 1)), all pixels 
// connected by a path of the same colour as the 
// starting pixel are colored with the new colour.
 
// Note the bottom corner is not colored 2, 
// because it is not 4-directionally connected to 
// the starting pixel.

// To perform a “flood fill”, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same colour as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same colour as the starting pixel), and so on.


// We know about both the traversals, Breadth First Search (BFS) and Depth First Search (DFS). We can follow BFS also, where we start at a given point and colour level wise, i.e., we go simultaneously to all its neighbours. We can use any of the traversals to solve this problem, in our case we will be using DFS just to explore multiple approaches. 

// The algorithm steps are as follows:

// Initial DFS call will start with the starting pixel (sr, sc) and make sure to store the initial colour. 
// Now, either we can use the same matrix to replace the colour of all of the aforementioned pixels with the newColor or create a replica of the given matrix. It is advised to use another matrix because we work on the data and not tamper with it. So we will create a copy of the input matrix. 
// Check for the neighbours of the respective pixel that has the same initial colour and has not been visited or coloured. DFS call goes first in the depth on either of the neighbours.
// We go to all 4 directions and check for unvisited neighbours with the same initial colour. To travel 4 directions we will use nested loops, you can find the implementation details in the code. 
// DFS function call will make sure that it starts the DFS call from that unvisited neighbour, and colours all the pixels that have the same initial colour, and at the same time it will also mark them as visited. 
// In this way, “flood fill” will be performed. It doesn’t matter how we are colouring the pixels, we just want to colour all of the aforementioned pixels with the newColor. So, we can use any of the traversal techniques.


// dfs Approach



class Solution
{
    void dfs(int sr, int sc, int newcolor, int image[][], int inicolor, int ans[][] , int delrow[] , int delcol[]){
        ans[sr][sc] = newcolor;
        int n = image.length;
        int m = image[0].length;
        for(int i=0;i<4;i++){
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol< m && image[nrow][ncol] == inicolor && ans[nrow][ncol] != newcolor){
                dfs(nrow, ncol,newcolor,image, inicolor, ans, delrow, delcol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int inicolor = image[sr][sc];
        int ans[][] = image;
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};
        dfs(sr, sc, newColor, image, inicolor, ans, delrow, delcol);
        return ans;
        
    }
}