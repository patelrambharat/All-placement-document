// Given a linked list of 0s, 1s and 2s, sort it.
// EasyAccuracy: 60.75%Submissions: 143K+Points: 2
// Share your Interview, Campus or Work Experience to win GFG Swag Kits and much more!

// Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

// Example 1:

// Input:
// N = 8
// value[] = {1,2,2,1,2,0,2,2}
// Output: 0 1 1 2 2 2 2 2
// Explanation: All the 0s are segregated
// to the left end of the linked list,
// 2s to the right end of the list, and
// 1s in between.


class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node l1 = new Node(-1);
        Node d1 = l1;
        Node l2 = new Node(-1);
        Node d2 = l2;
        Node l3 = new Node(-1);
        Node d3 = l3;
        Node temp = head;
        while(temp != null){
            if(temp.data == 0){
                l1.next = temp;
                l1 = l1.next;
                temp = temp.next;
            }
            else if(temp.data == 1){
                l2.next = temp;
                l2 = l2.next;
                temp = temp.next;
            }
            else if(temp.data == 2){
                l3.next = temp;
                l3 = l3.next;
                temp = temp.next;
            }
        }
        l3.next = null;
        l2.next = d3.next;
        l1.next = d2.next;
        return d1.next;
    }
}
