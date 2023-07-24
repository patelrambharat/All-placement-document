// Unfold Of Linked List | Linked List
// Unfold Of Linkedlist

// Given a singly linkedlist : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 -> ln-3 -> ..... 
// reorder it :  l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln
// for more information watch video.
// Input Format
// 1->7->2->6->3->5->4->null
// Output Format
// 1->2->3->4->5->6->7->null

 public static void unfold(ListNode head) {
            ListNode firsthead = new ListNode(-1);
            ListNode first = firsthead;
            ListNode secondhead = new ListNode(-1);
            ListNode second = secondhead;
            while(head != null){
                first.next = head;
                first = head;
                head = head.next;
                if(head != null){
                    second.next = head;
                    second = head;
                    head = head.next;
                }
            }
            first.next = null;
            second.next = null;
            first.next = reverse(secondhead.next);
            head = firsthead.next;
    }