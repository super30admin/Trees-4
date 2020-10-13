// TC: O(N) where N is number of nodes in tree
// SC: O(logN) for recursion stack since we are storing only till height of the tree 

import java.util.*;
public class kSmallestBST {

	List<Integer> list;
	public int ksmallest(TreeNode root, int k) {
		list = new ArrayList<>();
		if(root == null)
			return 0;
		// inorder will store the number in ascending order, store the values in list, retrive the k-1 element from list
		inorder(root);
		return list.get(k-1);
	}
	
	public void inorder(TreeNode root) {
		if(root == null)
			return;
		inorder(root.left);
		list.add(root.val);
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		
		kSmallestBST sdm = new kSmallestBST();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		System.out.println(sdm.ksmallest(root, 3));
	}
}
