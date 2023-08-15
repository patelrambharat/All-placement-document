// Bubble Sort | Time and Space | Data Structure and Algorithms in JAVA

// Bubble Sort Algorithm
// In this algorithm, 

// traverse from left and compare adjacent elements and the higher one is placed at right side. 
// In this way, the largest element is moved to the rightmost end at first. 
// This process is then continued to find the second largest and place it and so on until the data is sorted.

  // An optimized version of Bubble Sort
    static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                      
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
  
            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
  

// Complexity Analysis of Bubble Sort:
// Time Complexity: O(N2)
// Auxiliary Space: O(1)

// Advantages of Bubble Sort:
// Bubble sort is easy to understand and implement.
// It does not require any additional memory space.
// It is a stable sorting algorithm, meaning that elements with the same key value maintain their relative order in the sorted output.
// Disadvantages of Bubble Sort:
// Bubble sort has a time complexity of O(N2) which makes it very slow for large data sets.
// Bubble sort is a comparison-based sorting algorithm, which means that it requires a comparison operator to determine the relative order of elements in the input data set. It can limit the efficiency of the algorithm in certain cases.



// Recursion Idea.  

// Base Case: If array size is 1, return.
// Do One Pass of normal Bubble Sort. This pass fixes last element of current subarray.
// Recur for all elements except last of current subarray.

 // A function to implement bubble sort
    static void bubbleSort(int arr[], int n)
    {
        // Base case
        if (n == 1)
            return;
  
         int count = 0;
        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i=0; i<n-1; i++)
            if (arr[i] > arr[i+1])
            {
                // swap arr[i], arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                  count = count+1;
            }
  
          // Check if any recursion happens or not
          // If any recursion is not happen then return
         if (count == 0)
            return;
  
        // Largest element is fixed,
        // recur for remaining array
        bubbleSort(arr, n-1);
    }
      
    