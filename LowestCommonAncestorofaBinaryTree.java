package trees4;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorofaBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	//Time Complexity : O(n), where n is the size of string s
	//Space Complexity : O(n), recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base
        if(root == null || root == p || root == q)
            return root;
        
        // logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null)
            return null;
        else if(left != null && right == null)
            return left;
        else if(left == null && right != null)
            return right;
        else
            return root;
    }
	
	//Time Complexity : O(n), where n is the size of string s
	//Space Complexity : O(n), for list and recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	List<TreeNode> pList = new ArrayList<>();
    List<TreeNode> qList = new ArrayList<>();
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        inorder(root, p, q, new ArrayList<>());
        
        for(int i=0; i<pList.size(); i++) {
            if(pList.get(i) != qList.get(i))
                return pList.get(i - 1);
        }
        
        return null;
    }
    
    private void inorder(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base
        if(root == null)
            return;
        
        // logic
        if(root.val == p.val) {
            pList = new ArrayList<>(path);
            pList.add(p);
            pList.add(p);
        }
        if(root.val == q.val) {
            qList = new ArrayList<>(path);
            qList.add(q);
            qList.add(q);
        }
        
        // action
        path.add(root);
        // recurse
        inorder(root.left, p, q, path);
        inorder(root.right, p, q, path);
        // backtrack
        path.remove(path.size() - 1);
    }
}
