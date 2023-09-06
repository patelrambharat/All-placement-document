// G-39: Minimum Multiplications to Reach End
// Given start, end, and an array arr of n numbers. At each step, the start is multiplied by any number in the array and then a mod operation with 100000 is done to get the new start.
// Your task is to find the minimum steps in which the end can be achieved starting from the start. If it is not possible to reach the end, then return -1.

// Example 2:

// Input:
// arr[] = {2, 5, 7}
// start = 3
// end = 30
// Output:
// 2
// Explanation: 
// Step 1: 3*2 = 6 % 100000 = 6 
// Step 2: 6*5 = 30 % 100000 = 30
// Therefore, in minimum 2 multiplications we reach the 
// end number which is treated as a destination 
// node of a graph here.\


// Initial configuration:

// Queue: Define a Queue which would contain pairs of the type {steps, num }, where ‘steps’ indicates the currently updated value of no. of steps taken to reach from source to the current ‘num’.
// Distance Array: Define a distance array that would contain the minimum no. of multiplications/distance from the start number to the current number. If a cell is marked as ‘infinity’ then it is treated as unreachable/unattained.
// Start and End: Define the start and the end value which we have to reach through a series of multiplications.

class Pair {
    int first, second; 
    Pair(int first, int second) {
        this.first = first;
        this.second = second; 
    }
}
class Solution {
    int minimumMultiplications(int[] arr, 
    int start, int end) {

        // Create a queue for storing the numbers as a result of multiplication
        // of the numbers in the array and the start number.
        Queue<Pair> q = new LinkedList<>(); 
        q.add(new Pair(start, 0)); 

        // Create a dist array to store the no. of multiplications to reach
        // a particular number from the start number.
        int[] dist = new int[100000]; 
        for(int i = 0;i<100000;i++) dist[i] = (int)(1e9);
        dist[start] = 0; 
        int mod = 100000;
        int n = arr.length; 
        // O(100000 * N) 

        // Multiply the start no. with each of numbers in the arr
        // until we get the end no.
        while(!q.isEmpty()) {
            int node = q.peek().first; 
            int steps = q.peek().second;
            q.remove(); 
            
            for(int i = 0;i < n; i++) {
                int num = (arr[i] * node) % mod; 

                // If the no. of multiplications are less than before
                // in order to reach a number, we update the dist array.
                if(steps + 1 < dist[num]) {
                    dist[num] = steps + 1; 

                    // Whenever we reach the end number
                    // return the calculated steps
                    if(num == end) return steps + 1; 
                    q.add(new Pair(num, steps + 1)); 
                }
            }
        }
        // If the end no. is unattainable.
        return -1; 
    }
}


