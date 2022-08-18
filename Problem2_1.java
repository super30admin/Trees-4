//Time Complexity: O(n)
//Space Complexity: O(h)
//Code run successfully on LeetCode.

public class Problem2_1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
            return null;
        
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left,p,q);
        
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);
        
            return root;
    }
}
