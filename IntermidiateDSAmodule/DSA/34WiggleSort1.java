// Wiggle Sort 1
// Easy  Prev   Next
// 1. Given an unsorted array 'arr'.
// 2. Reorder it in-place such that :  arr[0] <= arr[1] >= arr[2] <= arr[3] . . . .
// 3. Please sort the array in place and do not define additional arrays.
// 4. Allowed Time Complexity : O(n)
// Input Format
// Input: [3, 5, 2, 1, 6, 4]
// Output Format
// Output: [1, 6, 2, 5, 3, 4]


  private static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static void wiggleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (i % 2 == 0) {
        if (arr[i] > arr[i + 1]) {
          swap(arr, i, i + 1);
        }
      } else {
        if (arr[i] < arr[i + 1]) {
          swap(arr, i, i + 1);
        }
      }
    }
  }