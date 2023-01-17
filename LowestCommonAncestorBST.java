// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


// Definition for a binary tree node.
class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

 public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if (p.val < root.val && q.val <root.val)
        //     return lowestCommonAncestor(root.left,p,q);
        // if (p.val > root.val && q.val > root.val)
        //     return lowestCommonAncestor(root.right,p,q);
        // return root;
        while(true){
            if (p.val < root.val && q.val <root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
    }
}
