// 25. Reverse Nodes in k-Group
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

// Example 1:


// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]
// Example 2:


// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]

class Solution {
    //a helper function to check if the size of the remaining list is less than k
    //we need this to check whether we need to reverse the list or not
    public boolean checklength(ListNode head, int k){
        ListNode start = head;
        int size = 0;
        while(start != null){
            start  = start.next;
            size++;
        }
        return size < k;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(checklength(head, k))  return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode ford = null;
        int cnt = 0;
        while(curr != null && cnt < k){   //first k node reverse
            ford = curr.next;
            curr.next = prev;
            prev = curr;
            curr  = ford;
            cnt++;
        }
        //recursively call for the rest of the linkedlist
        if(ford != null){
        head.next = reverseKGroup(ford, k);
        }
        return prev;
    }
}