// Binary tree Construction 

public class Node{
    int key;
    Node left, right;
    Node(int data){
        this.key  = data;
        left = right = null;
    }
}

//root -- > first node
//leaf -->  where the left and right child equal null
//sibling --> same level of the tree
//class for the binary tree
class Binary{
    Node root;

    public void traverse(Node node){
        while(node != null){
            traverse(node.left);
            System.out.println(node.key+" ");
            traverse(node.right);
        }
    }

}

public static void main(String args[]){
        Binary tree= new Binary();
        tree.root   = new  Node(1);



}