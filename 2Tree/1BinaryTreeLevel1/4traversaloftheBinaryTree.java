// // Traversals in a Binary Tree | Data Structures and Algorithms in JAVA

// Traversal of the Binary Tree\

// Inorder tree traversal
// Preorder tree traversal
// Postorder tree traversal
// 1. Inorder Traversal

 void printInorder(Node node)
    {
        if (node == null)
            return;
 
        // First recur on left child
        printInorder(node.left);
 
        // Then print the data of node
        System.out.print(node.key + " ");
 
        // Now recur on right child
        printInorder(node.right);
    }

    // 2.Preorder Traversal

    // Given a binary tree, print its nodes in preorder
    void printPreorder(Node node)
    {
        if (node == null)
            return;
 
        // First print data of node
        System.out.print(node.key + " ");
 
        // Then recur on left subtree
        printPreorder(node.left);
 
        // Now recur on right subtree
        printPreorder(node.right);
    }

    //3. Postorder Traversal
    // Given a binary tree, print its nodes according to the
// "bottom-up" postorder traversal.
void printPostorder(struct node* node)
{
    if (node == NULL)
        return;
 
    // First recur on left subtree
    printPostorder(node->left);
 
    // Then recur on right subtree
    printPostorder(node->right);
 
    // Now deal with the node
    printf("%d ", node->data);
}