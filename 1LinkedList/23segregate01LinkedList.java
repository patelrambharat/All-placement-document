//  Segregate 01 Node Of Linkedlist Over Swapping Nodes
// Easy  Prev   Next
// 1. Given a singly linklist, Segregate 01 Node of LinkedList and return pivot node of linkedlist.
// 2. After segregation zero nodes should come first and followed by ones node.

// Input Format
// 1->0->1->0->0->1->1->1->1->1->1->null
// Output Format
// 0->0->0->1->1->1->1->1->1->1->1->null
 
 
 public static ListNode segregate01(ListNode head) {
        ListNode d1 = new ListNode(-1);
        ListNode l1 = d1;
        ListNode d2 = new ListNode(-1);
        ListNode l2 = d2;
        ListNode temp = head;
        while(temp != null){
            if(temp.val == 0){
                l1.next = temp;
                l1 = l1.next;
                temp =temp.next;
            }
            else if(temp.val == 1){
                l2.next = temp;
                l2 = l2.next;
                temp = temp.next;
            }
        }
        
        l2.next= null;
        l1.next = d2.next;
        return d1.next;
        
    }