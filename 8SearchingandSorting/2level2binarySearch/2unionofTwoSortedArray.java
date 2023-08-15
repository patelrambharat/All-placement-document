// // Union of Two Sorted Arrays | GFG Union of Two Sorted Arrays Solution | Searching and Sorting
// // Union of Two Sorted Arrays | GFG Union of Two Sorted Arrays Solution | Searching and Sorting

// Union of Two Sorted Arrays
// EasyAccuracy: 31.39%Submissions: 147K+Points: 2
// Done with this problem? Now use these skills to apply for a job in Job-A-Thon 21!

// Union of two arrays can be defined as the common and distinct elements in the two arrays.
// Given two sorted arrays of size n and m respectively, find their union.


// Example 1:

// Input: 
// n = 5, arr1[] = {1, 2, 3, 4, 5}  
// m = 3, arr2 [] = {1, 2, 3}
// Output: 1 2 3 4 5
// Explanation: Distinct elements including 
// both the arrays are: 1 2 3 4 5.

//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
                public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
                {
                    // add your code here
            int i = 0, j = 0; // pointers
              ArrayList<Integer > Union=new ArrayList<>(); // Uninon vector
              while (i < n && j < m) {
                if (arr1[i] <= arr2[j]) // Case 1 and 2
                {
                  if (Union.size() == 0 || Union.get(Union.size()-1) != arr1[i])   //check for empty and duplicate condition 
                    Union.add(arr1[i]);  
                  i++;
                } else // case 3
                {
                  if (Union.size() == 0 || Union.get(Union.size()-1) != arr2[j])
                    Union.add(arr2[j]);
                  j++;
                }
              }
              while (i < n) // IF any element left in arr1
              {
                if (Union.get(Union.size()-1) != arr1[i])
                  Union.add(arr1[i]);
                i++;
              }
              while (j < m) // If any elements left in arr2
              {
                if (Union.get(Union.size()-1) != arr2[j])
                  Union.add(arr2[j]);
                j++;
              }
              return Union;
    }
}