// 206. Reverse Linked List
// // Input: head = [1,2,3,4,5]
// // Output: [5,4,3,2,1]

// there is 4 approach to solve this proble 
//1. iterative node 2. iterative pointer 3.  recursive node 4. recursive pointer
//1. iterative node approach --> 
//1. use two pointer approach to find first and last then swap it 
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
    
    public ListNode getNode(int idx, ListNode head){
        ListNode curr = head;
        for(int i =0;i<idx;i++){
            curr= curr.next;
        }
        return curr;
    }
    public int length(ListNode head){
        ListNode temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
    public void swap(ListNode left, ListNode right){
        int leftData = left.val;
        left.val = right.val;
        right.val= leftData;
    }
    public ListNode reverseList(ListNode head) {
        int start = 0;
        int end = length(head) -1;
        while(start < end){
            ListNode left = getNode(start, head);
            ListNode right = getNode(end, head);
            swap(left, right);
            start++;
            end--;
        }
         return head;
    }
   

}

//approach 2. using a third pointer prev and ford 
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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode ford = curr.next;
            curr.next = prev;
            prev = curr;
            curr= ford;
        }
        return prev;
    }
}

// approach 3 :: -->  Date recursive  approach

