//Time : O(n)
//Space : O(1)

//Approach:
// 1. if root contains any of the given node then root will be the common ancestor.
// 2 Else check the same above condition in both left subtree and right subtree. Now,if both left and right subtrees have a solution
//   then root is common ancestor.
// 3. Else if any one is empty then the other will be the common ancestor.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    return null;
        if(root.val == p.val || root.val == q.val)  return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null)   return root;
        if(left == null)    return right;
        else if(right == null)  return left;
        else return null;
    }
}
