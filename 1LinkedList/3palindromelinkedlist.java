

 

// Example 1:


// Input: head = [1,2,2,1]
// Output: true
// Example 2:


// Input: head = [1,2]
// Output: false
 

// Constraints:

// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9
 
1. Approach --> 1. find the middle 
                2. reverse from middle to the end   
                3. compare the element 

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

    public boolean compare(ListNode temp1, ListNode temp2){
        ListNode t1 = temp1, t2 = temp2;
        while(t1 != null && t2 != null){
            if(t1.val != t2.val)   return false;
            t1 = t1.next;
            t2 = t2.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode ford = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ford;
        }
        return prev;
    }
    public ListNode midnode(ListNode head){
         ListNode slow = head;
         ListNode fast = head;
         while(fast.next != null && fast.next.next != null){
             fast = fast.next.next;
             slow = slow.next;
         }
         return slow;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid = midnode(head);
        ListNode temp1= head;
        ListNode temp2 = mid.next;
        mid.next =null;
        temp2 = reverse(temp2);
        return compare(temp1, temp2);
    }
}