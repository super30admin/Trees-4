//Leetcode - 235
//TimeComplexity - O(logN)
//Space Complexity - O(H)
public class LowestCommonAncestorBST {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val>root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if(p.val < root.val && q.val <root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else return root;
    }

    /*Iterative
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true)
        if(p.val > root.val && q.val>root.val) {
            root = root.right;
        } else if(p.val < root.val && q.val <root.val) {
            root = root.left;
        } else return root;
        }
    }
     */
}
