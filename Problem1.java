// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Runtime: 1 ms, faster than 74.74% of Java online submissions for Kth Smallest Element in a BST.
//Memory Usage: 38 MB, less than 97.25% of Java online submissions for Kth Smallest Element in a BST.
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
import java.util.*;
import java.io.*;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x){ val=x;}
	
}
public class Problem1{
	TreeNode root ;
	public static void main(String[] args) {
		Problem1 tree = new Problem1();
		tree.root= new TreeNode(3);
		tree.root.left= new TreeNode(9);
		tree.root.right= new TreeNode(20);
		tree.root.right.left= new TreeNode(15);
		tree.root.right.right= new TreeNode(7);
		
		int ans = kthSmallest(tree.root, 4);
		System.out.println("kth Smallest element: "+ ans);
		
	}
	public static int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> result = inorder(root, new ArrayList<Integer>());
		return result.get(k-1);
		
	}
	public static ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> nums){
		if(root == null) return nums;
		inorder(root.left, nums);
		nums.add(root.val);
		inorder(root.right, nums);
		return nums;
		
	}
}