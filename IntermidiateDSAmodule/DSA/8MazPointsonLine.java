// 149. Max Points on a Line
// Hard
// 3.8K
// 421
// Companies
// Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

 

// Example 1:


// Input: points = [[1,1],[2,2],[3,3]]
// Output: 3
// Example 2:


// Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
// Output: 4
 

// Constraints:

// 1 <= points.length <= 300
// points[i].length == 2
// -104 <= xi, yi <= 104
// All the points are unique.
class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 0)
        {
            return 0;
        }
        if(points.length <= 2){
            return points.length;
        }
        int max = 0;
        for(int point1[] :points){
            Map<Double , Integer>map = new HashMap<>();
            for(int point2[] : points){
                if(point1 == point2){
                    continue;
                }
                double slope = 0;
                //if x2 - x1 is equal then infinity line
                if(point2[0] == point1[0]){
                    slope = Double.POSITIVE_INFINITY;
                }
                else{
                    slope = (double)(point2[1] - point1[1])/(double)(point2[0] - point1[0]);

                }
                map.put(slope, map.getOrDefault(slope, 0) +1);
                if(map.get(slope) > max){
                    max = map.get(slope);
                }
            }
        }
        return max+1;
    }
}