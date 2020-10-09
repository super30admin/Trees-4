//Time Complexity: O(n)
//Space Complexity: O(n)
//Did it run on leetcode: yes

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        
        if(p.val==root.val || q.val==root.val)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left!=null && right!=null)
            return root;
        else if(left!=null)
            return left;
        else
            return right;
    }
}
