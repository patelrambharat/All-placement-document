// 23. Merge k Sorted Lists
// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

 

// Example 1:

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6
// Example 2:

// Input: lists = []
// Output: []
// Example 3:

// Input: lists = [[]]
// Output: []


//BruteForce Approach -->  O(n*k)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int minNode(ListNode list[]){
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for(int i=0;i<list.length;i++){
                if(list[i] != null && list[i].val < min){
                    idx = i;
                    min = list[i].val;
                }
            }
            return idx;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy,tail = dummy;
        while(true){
            int minindex = minNode(lists);
            if(minindex == -1)  break;
            tail.next = lists[minindex];
            lists[minindex] = lists[minindex].next;
            tail = tail.next;
        }
        return dummy.next;
    }
}

//Optimize Approach--> using devide and conquer approach 
// 1. merge k sorted list(l, r) = mergeksorted(l, mid) + mergeksorted(m+1, r) + merge 2 LinkedList
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode merge2List(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode l1 = dummy;
        while(list1 != null && list2!= null){
            if(list1.val <= list2.val){
                l1.next = list1;
                l1 = l1.next;
                list1 = list1.next;
            }
            else{
                l1.next = list2;
                l1 =l1.next;
                list2 = list2.next;
            }
        }
        while(list1 != null){
            l1.next = list1;
                l1 = l1.next;
                list1 = list1.next;
        }
        while(list2 != null){
             l1.next = list2;
                l1 =l1.next;
                list2 = list2.next;
        }
        l1.next = null;
       return dummy.next; 
    }
    public ListNode helper(ListNode lists[] , int left, int right){
        if(left > right)  return null;
        if(left == right)   return lists[left];
        int mid = (left + right)/2;
        ListNode l1 = helper(lists, left, mid);
        ListNode l2 = helper(lists, mid +1, right);
        return merge2List(l1, l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length ==0){
            // 0 linked list
            return null;
        }
        return helper(lists, 0, lists.length -1);
    }
}
