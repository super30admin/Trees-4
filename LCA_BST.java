//time complexity: O(N)
// space complexity: O(height of tree)

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(p.val==root.val || q.val == root.val)
            return root;
        else if ((p.val > root.val && q.val < root.val) ||(p.val < root.val && q.val > root.val) )
            return root;
        else if (p.val> root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}