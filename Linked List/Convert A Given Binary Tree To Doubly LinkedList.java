
/*************************************************************
 class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

*************************************************************/


public class Solution {
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
		// Write your code here
        if (root == null) 
            return root;

        if (root.left != null) {
            BinaryTreeNode left = BTtoDLL(root.left);
            
            while (left.right != null)
                left = left.right;
 
            left.right = root;
            root.left = left;
        }

        if (root.right != null) {
            BinaryTreeNode<Integer> right = BTtoDLL(root.right);

            // Inorder successor.
            while (right.left != null)
                right = right.left;
        
            right.left = root;
            root.right = right;
        }

        while (root.left != null)
            root = root.left;
      
        return root;
    }
}

