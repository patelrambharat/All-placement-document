//   Segregate Node Of Linkedlist Over Pivot Index
// Medium  Prev   Next
// 1. Given a singly linklist, Segregate Node of LinkedList over pivot index and return starting node of linkedlist.
// 2. pivot will be any random index in range of 0 to length Of Linkedlist
// 3. After segregation pivot Element should have to be present at correct position as in sorted linkedlist.
// Input Format
// 1->5->2->9->5->14->11->1->10->10->1->3->null
// 11
// Output Format
// 1->2->1->1->3->5->9->5->14->11->10->10->null 
// Question Video
  
  public static int length(ListNode head) {
    int len = 0;
    ListNode curr = head;
    while (curr != null) {
      curr = curr.next;
      len++;
    }
    return len;
  }

  public static ListNode segregate(ListNode head, int idx) {
    if (head == null || head.next == null)
      return head;

    int i = 0, data = 0;
    ListNode curr = head;
    while (curr != null) {
      if (i == idx)
        data = curr.val;

      i++;
      curr = curr.next;
    }

    ListNode smaller = new ListNode(-1);
    ListNode sp = smaller;

    ListNode greater = new ListNode(-1);
    ListNode gp = greater;

    i = 0;
    curr = head;
    ListNode pivot = null;
    while (curr != null) {
      if (i == idx) {
        pivot = curr;
      } else if (curr.val <= data) {
        sp.next = curr;
        sp = sp.next;
      } else {
        gp.next = curr;
        gp = gp.next;
      }

      curr = curr.next;
      i++;
    }

    sp.next = pivot;
    pivot.next = greater.next;
    gp.next = null;
    sp = sp.next;

    return smaller.next;
  }