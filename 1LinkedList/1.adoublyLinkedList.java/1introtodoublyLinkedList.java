//point 1.  A doubly linked list (DLL) is a special type of linked list in which each node contains a pointer to the previous 
// node as well as the next node of the linked list.

//point 2. Doubly linked list: A doubly linked list is a little different from singly-linked lists.
// It contains an extra pointer previous which points to the previous node of the linked lists.
// Following are the important terms to understand the concept of a doubly-linked list :
// 1. node− Each node of a linked list can store a data called an element.
// 2. next − Each node of a linked list contains a pointer to the next node called  next.
// 3. prev− Each node of a linked list contains a pointer to the previous node called prev

class Node{
    int data;
    Node next;
    Node prev;
    Node(int val){
        this.data = val;
        next = null;
        prev = null;
    }
}


//basic operation of the doubly linked List
// 1. insertion 
// 2. deletion 
// 3. display

// Advantage of the LinkedList
// 1. it allows us to iterate the both the direction 
// 2. we can delete the node easily as we have access to its previous node
// 3. reversing is Easy
// 4. can grow or shrink in size dynamically



