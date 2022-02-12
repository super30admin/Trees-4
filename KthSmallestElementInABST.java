package trees4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInABST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	//Time Complexity : O(n), where n is the length of TreeNode
	//Space Complexity : O(n), for stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(--k == 0)
                return root.val;
            root = root.right;
        }
        
        return -1;
    }
	
	//Time Complexity : O(n), where n is the length of TreeNode
	//Space Complexity : O(n), for list
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int kthSmallest1(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
