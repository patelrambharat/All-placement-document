// Fold Of Linked List | Linked List

// 143. Reorder List
// Medium
// 9.2K
// 305
// Companies
// You are given the head of a singly linked-list. The list can be represented as:

// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:

// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.


// approach
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
    public ListNode getmiddle(ListNode head){
      ListNode slow = head;
      ListNode fast  = head;
      while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;

      }
      return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode ford = null;
        while(curr != null){
            ford = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ford;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
       ListNode mid = getmiddle(head);
       ListNode head2 = reverse(mid.next);
       mid.next= null;
       ListNode dummy  = new ListNode(-1);
       ListNode curr= dummy;
       while(head != null && head2 != null){
               curr.next = head;
               head = head.next;

               curr.next.next = head2;
               head2 = head2.next;

               curr = curr.next.next;
           
           if(head != null){
               curr.next = head;
           }
       }
    }
}