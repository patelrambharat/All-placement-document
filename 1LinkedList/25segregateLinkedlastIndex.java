
//     Segregate Node Of Linkedlist Over Last Index.
// Easy  Prev   Next
// 1. Given a singly linklist, Segregate Node of LinkedList over lastindex and return pivot node of linkedlist.
// 2. pivot is always be last index of linkedlist.
// 3. After segregation pivot Element should have to be present at correct position as in sorted linkedlist.
// Input Format
// 1->5->2->9->5->14->11->1->10->10->1->3->null
// Output Format
// 3->5->9->5->14->11->10->10->null 
    
    public static ListNode findlast(ListNode head){
        if(head == null) return head;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
        }
        return temp;
    }  
    public static ListNode segregateOnLastIndex(ListNode head) {
        if(head == null || head.next == null)  return head;
      ListNode tail = findlast(head);
      ListNode smaller = new ListNode(-1);
      ListNode selem= smaller;
      ListNode larger = new ListNode(-1);
      ListNode largele = larger;
      ListNode temp = head;
      while(temp != null){
          if(temp.val <= tail.val){
              selem.val = temp;
              selem = selem.next;
              temp = temp.next;
          }
          else{
              largele.val = temp;
              largele = largele.next;
              temp = temp.next;
          }
      }
      largele.next = null;
      selem.next = lerger.next;
      return smaller;
    return null;
    }
