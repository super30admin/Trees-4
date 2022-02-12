package trees4;

public class LowestCommonAncestorofaBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	//Time Complexity : O(log n), where n is the number of elements in root
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(root.val < p.val && root.val < q.val)
                root = root.right;
            else if(root.val > p.val && root.val > q.val)
                root = root.left;
            else
                return root;
        }
    }
	
	//Time Complexity : O(log n), where n is the number of elements in root
	//Space Complexity : O(n), for recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if(root.val < p.val && root.val < q.val)
			return lowestCommonAncestor1(root.right, p, q);
		else if(root.val > p.val && root.val > q.val)
			return lowestCommonAncestor1(root.left, p, q);
		else
			return root;
	}
}
