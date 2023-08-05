// Print the nodes having exactly one child in a Binary tree
// S

// shivanshu_gupta
// Read
// Discuss
// Courses
// Practice

// Given a binary tree, the task is to print all the nodes having exactly one child. Print “-1” if no such node exists.
// Examples: 

// Input: 
//             2
//            / \
//           3   5
//          /   / \
//         7   8   6
// Output: 3

// Function to find the nodes 
// having single child 
static void printNodesOneChild(Node root)
{
    // Base case
    if (root == null)
        return;
 
    // Condition to check if the node
    // is having only one child
    if (root.left != null && root.right == null ||
        root.left == null && root.right != null)
    {
        list.add(root.data);
    }
     
    // Traversing the left child
    printNodesOneChild(root.left);
     
    // Traversing the right child
    printNodesOneChild(root.right);
}
 