// Construct a Binary Search Tree from given postorder
// Read
// Discuss(20+)
// Courses
// Practice

// Given postorder traversal of a binary search tree, construct the BST.

// For example, if the given traversal is {1, 7, 5, 50, 40, 10}, then following tree should be constructed and root of the tree should be returned. 

//      10
//    /   \
//   5     40
//  /  \      \
// 1    7      50
// Method 1 ( O(n^2) time complexity ):

// The last element of postorder traversal is always root. We first construct the root. Then we find the index of last element which is smaller than root. Let the index be ‘i’. The values between 0 and ‘i’ are part of left subtree, and the values between ‘i+1’ and ‘n-2’ are part of right subtree. Divide given post[] at index “i” and recur for left and right sub-trees. 


// For example in {1, 7, 5, 50, 40, 10}, 10 is the last element, so we make it root. Now we look for the last element smaller than 10, we find 5. So we know the structure of BST is as following. 

//              10
//            /    \
//           /      \
//   {1, 7, 5}       {50, 40}
// We recursively follow above steps for subarrays {1, 7, 5} and {40, 50}, and get the complete tree.

// Method 2 ( O(n) time complexity ):

// The trick is to set a range {min .. max} for every node. Initialize the range as {INT_MIN .. INT_MAX}. The last node will definitely be in range, so create root node. To construct the left subtree, set the range as {INT_MIN …root->data}. If a values is in the range {INT_MIN .. root->data}, the values is part of left subtree. To construct the right subtree, set the range as {root->data .. INT_MAX}.

/* A O(n) program for construction of BST from
postorder traversal */

/* A binary tree node has data, pointer to left child
and a pointer to right child */
class Node
{
	int data;
	Node left, right;

	Node(int data)
	{
		this.data = data;
		left = right = null;
	}
}

// Class containing variable that keeps a track of overall
// calculated postindex
class Index
{
	int postindex = 0;
}

class BinaryTree
{
	// A recursive function to construct BST from post[].
	// postIndex is used to keep track of index in post[].
	Node constructTreeUtil(int post[], Index postIndex,
			int key, int min, int max, int size)
	{
		// Base case
		if (postIndex.postindex < 0)
			return null;

		Node root = null;

		// If current element of post[] is in range, then
		// only it is part of current subtree
		if (key > min && key < max)
		{
			// Allocate memory for root of this subtree and decrement
			// *postIndex
			root = new Node(key);
			postIndex.postindex = postIndex.postindex - 1;

			if (postIndex.postindex >= 0)
			{
				// All nodes which are in range {key..max} will go in
				// right subtree, and first such node will be root of right
				// subtree
				root.right = constructTreeUtil(post, postIndex,
						post[postIndex.postindex],key, max, size);

				// Construct the subtree under root
				// All nodes which are in range {min .. key} will go in left
				// subtree, and first such node will be root of left subtree.
				root.left = constructTreeUtil(post, postIndex,
						post[postIndex.postindex],min, key, size);
			}
		}
		return root;
	}

	// The main function to construct BST from given postorder
	// traversal. This function mainly uses constructTreeUtil()
	Node constructTree(int post[], int size)
	{
		Index index = new Index();
		index.postindex = size - 1;
		return constructTreeUtil(post, index, post[index.postindex],
				Integer.MIN_VALUE, Integer.MAX_VALUE, size);
	}

	// A utility function to print inorder traversal of a Binary Tree
	void printInorder(Node node)
	{
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	// Driver program to test above functions
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		int post[] = new int[]{1, 7, 5, 50, 40, 10};
		int size = post.length;

		Node root = tree.constructTree(post, size);

		System.out.println("Inorder traversal of the constructed tree:");
		tree.printInorder(root);
	}
}

// This code has been contributed by Mayank Jaiswal
