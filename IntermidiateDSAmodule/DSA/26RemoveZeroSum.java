// 1171. Remove Zero Sum Consecutive Nodes from Linked List
// Medium
// 2K
// 86
// Companies
// Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

// After doing so, return the head of the final linked list.  You may return any such answer.

 

// (Note that in the examples below, all sequences are serializations of ListNode objects.)

// Example 1:

// Input: head = [1,2,-3,3,1]
// Output: [3,1]
// Note: The answer [1,2,1] would also be accepted.
// Example 2:

// Input: head = [1,2,3,-3,4]
// Output: [1,2,4]
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
    public ListNode removeZeroSumSublists(ListNode head) {
       ListNode dummy = new ListNode(0);
        ListNode currNode = dummy;
        dummy.next = head;
        int prefixsum = 0;
        Map<Integer, ListNode>mp = new HashMap<>();
        while(currNode != null){
            prefixsum += currNode.val;
            //if seen in hashmap , the remove all the nodes
            if(mp.containsKey(prefixsum)){
                currNode = mp.get(prefixsum).next;
                int sum = prefixsum + currNode.val;
                while(sum != prefixsum){
                    mp.remove(sum);
                    currNode = currNode.next;
                    sum += currNode.val;
                }
                mp.get(prefixsum).next = currNode.next;
            }
            else{
                mp.put(prefixsum , currNode);
            }
            currNode = currNode.next;
        }
        return dummy.next;
    }
}