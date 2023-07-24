// // Mid Node Of Linked List | Linked List
// 876. Middle of the Linked List
// Easy
// 9.9K
// 290
// Companies
// Given the head of a singly linked list, return the middle node of the linked list.

// If there are two middle nodes, return the second middle node.

 

// Example 1:


// Input: head = [1,2,3,4,5]
// Output: [3,4,5]
// Explanation: The middle node of the list is node 3.
// Example 2:

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
    // public static int size(ListNode head){
    //     ListNode curr = head;
    //     int cnt =0;
    //     while(curr != null){
    //         cnt++;
    //         curr = curr.next;
    //     }
    //     return cnt;
    // }
    public ListNode middleNode(ListNode head) {
        // int n = size(head);
        // ListNode curr = head;
        // for(int i=0;i<n/2;i++){
        //      curr = curr.next;
        // }
        // return curr;
        //slow and fast approach
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}