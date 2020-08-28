import java.util.*;
// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
/**********************************Iterative************************************/
//Time Complexity : O(k)
//Space Complexity : O(h), if its balanced BST: O(log n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

/**since, its a BST, Inorder traversal of BST will be sorted
 * will do inorder traversal and return the kth element that is popped.**/

public class Kth_Smallest_Element_ina_BST {
	public int kthSmallest(TreeNode root, int k) {        
		Stack<TreeNode> stack = new Stack<>();
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			k--;
			if(k == 0)
				return root.val;

			root = root.right;
		}
		return -1;
	}
}

/**********************************Using Recursion************************************/
//Time Complexity : O(n)
//Space Complexity : O(h), if its balanced BST: O(log n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

class Solution {
	int count;
	int result;
	public int kthSmallest(TreeNode root, int k) {        
		if(root == null)
			return -1;
		count = k;

		inorder(root);

		return result;
	}
	private void inorder(TreeNode root){
		if(root == null)
			return;

		inorder(root.left);
		count--;
		if(count == 0)
			result = root.val;
		inorder(root.right);
	}
}