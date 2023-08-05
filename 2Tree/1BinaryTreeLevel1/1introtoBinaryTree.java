// Introduction to Binary Trees | Data Structures and Algorithms

class Node{
    int key;
    Node left, right;
    public Node(int data){
        key = data;
        left = right = NULL;
    }
}

// Basic Operations On Binary Tree:
// 1.Inserting an element.
// 2.Removing an element.
// 3.Searching for an element.
// 4.Deletion for an element.
// 5.Traversing an element. There are four (mainly three) types of traversals in a binary tree which will be discussed ahead.

// // traversals
// 1.inorder Traversal   --> left -> root --> right
// 2. preorder Traversal   --> root --> left -> right
// 3. Postorder Traversal   --> left --> right --> root 
// 4. level Order Traversal   --> level wise

// // Properties of the Binary Tree
// 1. The maximum number of nodes at level ‘l’ of a binary tree is 2^l: 

// 2. The Maximum number of nodes in a binary tree of height ‘h’ is 2^h – 1:

// 3. In a Binary Tree with N nodes, the minimum possible height or the minimum number of levels is Log2(N+1):
// 4. A Binary Tree with L leaves has at least | Log2L |+ 1   levels:
// 5. In a Binary tree where every node has 0 or 2 children, the number of leaf nodes is always one more than nodes with two children:
// 6. In a non-empty binary tree, if n is the total number of nodes and e is the total number of edges, then e = n-1:


// Types of Binary Tree based on the number of children:
// Following are the types of Binary Tree based on the number of children:

// Full Binary Tree
// Degenerate Binary Tree
// Skewed Binary Trees
// 1. Full Binary Tree
//  A Binary Tree is a full binary tree if every node has 0 or 2 children. 
// A full Binary tree is a special type of binary tree in which every parent node/internal node has either two or no children. 
// It is also known as a proper binary tree.

// 2. Degenerate (or pathological) tree
// A Tree where every internal node has one child. Such trees are performance-wise same as linked list. 
// A degenerate or pathological tree is a tree having a single child either left or right.

// 3. Skewed Binary Tree
// A skewed binary tree is a pathological/degenerate tree in which the tree is either dominated by the left nodes or the right nodes.
//  Thus, there are two types of skewed binary tree: left-skewed binary tree and right-skewed binary tree.

// Types of Binary Tree On the basis of the completion of levels:
// 1.Complete Binary Tree
// 2.Perfect Binary Tree
// 3.Balanced Binary Tree

// 1. Complete Binary Tree
//  A Binary Tree is a Complete Binary Tree if all the levels are completely filled except possibly 
// the last level and the last level has all keys as left as possible.

// 2. Perfect Binary Tree
// A Binary tree is a Perfect Binary Tree in which all the internal nodes have two children and all leaf nodes are at the same level. 
// The following are examples of Perfect Binary Trees. 

// 3. Balanced Binary Tree
// A binary tree is balanced if the height of the tree is O(Log n) where n is the number of nodes. 
// For Example, the AVL tree maintains O(Log n) height by making sure that the difference between the heights of the 
// left and right subtrees is at most 1. Red-Black trees maintain O(Log n) height by making sure that the number of 
// Black nodes on every root to leaf paths is the same and that there are no adjacent red nodes. Balanced Binary 
// Search trees are performance-wise good as they provide O(log n) time for search, insert and delete. 


// Some Special Types of Trees:
// On the basis of node values, the Binary Tree can be classified into the following special types:

// Binary Search Tree
// AVL Tree
// Red Black Tree
// B Tree
// B+ Tree
// Segment Tree

// 1. Binary Search Tree
// Binary Search Tree is a node-based binary tree data structure that has the following properties:

// The left subtree of a node contains only nodes with keys lesser than the node’s key.
// The right subtree of a node contains only nodes with keys greater than the node’s key.

//  2. AVL Tree
// AVL tree is a self-balancing Binary Search Tree (BST) where the difference
//  between heights of left and right subtrees cannot be more than one for all nodes. 

