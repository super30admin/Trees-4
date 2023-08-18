// Time Complexity : O(n) -> if its a skewed tree
//                   O(log n) -> if complete bst
// Space Complexity : O(h) -> height of the tree -> for recursive solution
//                     O(1) -> for iterative solution
// Did this code successfully run on Leetcode : Yes

public class LowestCommonAncestorOfABST {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //recursive solution
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        else if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right,p,q);
        else return root;

        // iterative solution
        // while(true)
        // {
        //     if(root.val > p.val && root.val > q.val) root = root.left;
        //     else if(root.val < p.val && root.val < q.val)root = root.right;
        //     else return root;
        // }

    }
}
