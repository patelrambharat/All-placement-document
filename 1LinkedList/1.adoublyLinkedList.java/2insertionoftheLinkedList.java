// 1. insertion at the front of the Linked List
// Insetion at the front 

// 1. Firstly, allocate a new node (say new_node).
// 2. Now put the required data in the new node.
// 3. Make the next of new_node point to the current head of the doubly linked list.
// 4. Make the previous of the current head point to new_node.
// Lastly, point head to new_node.

public static void push(int newdata){
    //1. allocate a node
    //2. put the required data in the new node
    Node newNode = new Node(newdata);

    //3.make next of new node as head and previous as null
    newNode.next = head;
    newNode.prev = null;

    //4. change previous of head node to newNode
    if(head != null){
        head.prev = newNode;
    }
    //5. move the head to point to the new node
    head = newNode;

}