//singly LinkedList --> Non contigous memory allocation
public static Node{
    int data;
    Node next;   //extra memory

}

public static class Node{
    int data;
    Node next;
}
public static class LinkedList{
    Node head;
    Node tail;
    int size;
    void addLast(int val){       //1 --> 2 --> add (3)    ===> 1 -> 2 -> 3-> null
        //1.create a new Node 
        Node temp = new Node();   //if tail given then add last will take O(1) time comp
        temp.data = val;
        if(size == 0){
                head = temp;
                tail = temp;
        }
        else{
            tail.next = temp;
            tail = temp;              
        }
        size++;
    }
   
}

//insert at tail if the tail is not given   --> it will take O(n) time complexity
Node insetAtEnd(Node head, int x){
    Node newNode = new Node(x);
    if(head == null)   return newNode;    
    Node temp = head;
    while(temp.next != null){
        temp = temp.next;
    }
    temp.next = newNode;
    return head;
}

//Disadvantage of LinkedList over Array 
//1. Extra space for storing 1 Node 
//2. Random Access Not available
//Advantage of LinkedList over Array
//1.Non contigous memory Allocation 
//2. No problem of fragmantation

//2.a
//add first in the Linked List  
public void addFirst(int val){   1-> 2-> 3 add 4 to the first ==> 4-> 1-> 2-> 3-> null   --> time compexity = O(1)
        Node temp = new Node();
        temp.data = val;
        if(size == 0){
            head = temp;
            tail = temp;
        }
        else{
            temp.next = head;
            head = temp
        }
        size++;
}

//2.b//add first if tail is not given 
public int addFirst(Node head, int val){     //it will take O(1)
    Node newNode = new Node(int val);
    if(head == null){
        return newNode;
    }
    newNode.next = head;
    head = newNode;

    return head;
}


//3. Insert at a given position 
public Node insertAtposition(Node headNode, int position, int data){
    Node head = headNode;
    if(position < 1){
        System.out.println("Invalid position");
    }
    if(position ==1){
        Node newNode = new Node(data);
        newNode.nextNode = headNode;
        head  = newNode;
    }
    else{
        for(int i=1;i<position -1;i++){
            headNode = headNode.nextNode;
        }
        Node newNode = new Node(data);
        newNode.nextNode = headNode.nexNode;
        headNode.nextNode = newNode;
    }
    return head;
}


//4. Deleting operation on the LinkedList 

//4.1--> Delete a Node at front of the LinkedList
static void deleteFirst(){
    if(head == null){
        System.out.println("there is no node to be deleted");
    }
    else{
        //step 1. creating a temp node , and pointing to the head of the LinkedList
        Node temp = head;
        //step 2. making head next as head;
        head = head.next;
        //step 3. making temp next as null;
        temp.next = null;
    }
}

//if tail is given then delete first
static void deletefirst(){
    if(size == 0){
        System.out.println("list is empty");
        return;
    }
    if(size > 1){
        head = head.next;
    }
    else{
        head = tail = null;
    }
    size--;
}




//delete a Node from the tail of the LinkedList
static Node deleteattail(){
    if(head == null)
    {
        return null;
    }
    if(head.next == null){
        return null;
    }
    //find the second last node
    Node second_last = head;
    while(second_last.next.next != null){
        second_last = second_last.next;
    }
    //change next to second_last
    second_last.next = null;
    return head;
}


//delete Node at a given position 
static void deleteatgivenposition(int position){
    if(head  == null){
        return;
    }
    Node temp = head;
    if(position == 0){
        head = temp.next;
        return;
    }
    for(int i=0;temp != null && i< position -1;i++){
        temp = temp.next;
    }
    if(temp == null && temp.next == null){
        return;
    }
    Node next1  = temp.next.next;
    temp.next = next1;
    
}

//deletemiddle of the Linked List
Node deleteMid(Node head){
    if(head == null || head.next == null){
        return null;
    }
    Node slow = head;
    Node fast = head;
    Node prev = null;
    while(fast != null && fast.next != null){
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;

    }
    prev.next = slow.next;
    return head;
}


