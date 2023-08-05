//1.find the height of the tree 


class Solution {
    //Function to find the height of a binary tree.
  
    int height(Node node) 
    {
       // code here 
        if(node == null){
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return 1+Math.max(lh, rh);
    }

}

// 2. find the size of the tree

class Tree
{
	public static int getSize(Node root)
	{
//add Code here.
        if(root == null){
            return 0;
        }
        int lesize = getSize(root.left);
        int risize = getSize(root.right);
        return 1 + lesize + risize;
    }
}


//3. sum of the tree

/*  Tree node
struct Node
{
    int data;
    Node* left, * right;
}; */

// Should return true if tree is Sum Tree, else false
class Solution
{
    public:
     pair<bool,int> isSumTreeFast(Node* root) {
        
        //base case
        if(root == NULL) {
            pair<bool,int> p = make_pair(true, 0);
            return p;
        }
        
        if(root->left == NULL && root->right == NULL ) {
            pair<bool,int> p = make_pair(true, root->data);
            return p;
        }
        
        pair<bool,int> leftAns = isSumTreeFast(root->left);
        pair<bool,int> rightAns = isSumTreeFast(root->right);
        
        bool isLeftSumTree = leftAns.first;
        bool isRightSumTree = rightAns.first;
        
        int leftSum = leftAns.second;
        int rightSum = rightAns.second;
        
        bool condn = root->data == leftSum + rightSum;
        
        pair<bool, int> ans;
        
        if(isLeftSumTree && isRightSumTree && condn) {
            ans.first = true;
            ans.second = root->data + leftSum + rightSum ;
        }
        else
        {
            ans.first = false;
        }
        return ans;
        
    }
    bool isSumTree(Node* root)
    {
        return isSumTreeFast(root).first;
    }
};