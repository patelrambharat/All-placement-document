// 1326. Minimum Number of Taps to Open to Water a Garden
// Hard
// 2K
// 122
// Companies
// There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).

// There are n + 1 taps located at points [0, 1, ..., n] in the garden.

// Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.

// Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.

 

// Example 1:


// Input: n = 5, ranges = [3,4,1,1,0,0]
// Output: 1
// Explanation: The tap at point 0 can cover the interval [-3,3]
// The tap at point 1 can cover the interval [-3,5]
// The tap at point 2 can cover the interval [1,3]
// The tap at point 3 can cover the interval [2,4]
// The tap at point 4 can cover the interval [4,4]
// The tap at point 5 can cover the interval [5,5]
// Opening Only the second tap will water the whole garden [0,5]
// Example 2:

// Input: n = 3, ranges = [0,0,0,0]
// Output: -1
// Explanation: Even if you activate all the four taps you cannot water the whole garden.



// Approach: We just have to find the tap with largest rightMax range && which should start atleast from our current minimum ranged reached. Now the current minimum point will be the rightMax range of previously selected tap.
// Hence if no tap is selected, previous minimum would be 0, so next tap should be selected as: left point zero or less than zero, but right should be max of all.
// Repeat untill we get rightMax >= time.

public int minTaps(int n, int[] ranges) {
        int max = 0;
        int min = 0;
        int taps = 0;
        while(max<n){
		
		//finding the best fit max by keeping min as constant
            for(int i=0; i<ranges.length; i++){
                int left = i-ranges[i];
                int right = i+ ranges[i];
                if(left<=min && right>max){
                    max = right;
                }
            }
			
			//now if there is a gap, then it is not possible to merge ranges of taps,
			//hence min == max indicates that we end up getting same max as previous hence not possible.
            if(min == max) return -1;
          	
			//now our max will be min
            min = max;
			
			taps++;
			//now we will find the next best fit tap
        }
        return taps;
    }