// 148. Sort List
// Medium
// 10.2K
// 294
// Companies
// Given the head of a linked list, return the list after sorting it in ascending order.

 

// Example 1:


// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
// Example 2:


// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]
// Example 3:

// Input: head = []
// Output: []

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
    public ListNode getMid(ListNode head){
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        return slow;
    }
    public ListNode merge(ListNode l1 , ListNode l2){
        ListNode d1= new ListNode(-1);
        ListNode temp = d1;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }
            else{
                temp.next =l2;
                l2 = l2.next;
                temp =temp.next;
            }
        }
        if(l1 != null)  temp.next = l1;
        if(l2 != null)  temp.next = l2;
        return d1.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)  return head;
        ListNode mid = getMid(head);
        ListNode l = sortList(head);
        ListNode r = sortList(mid);
        return merge(l,r);
    }
}