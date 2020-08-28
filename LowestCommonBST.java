/*
  Time: O(n)
  Space: O(L) L= height of the tree.
  Run on LeetCode: yes.
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val)
            return lowestCommonAncestor(root, q,p);

        if(root == null)
            return null;

        if(root.val > q.val)
            return lowestCommonAncestor(root.left, p,q);
        else if(root.val < p.val)
            return lowestCommonAncestor(root.right, p,q);

        return root;
    }
}
