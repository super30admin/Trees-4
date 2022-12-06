
// TC : O(h)
// SC : O(1)

package S30_Codes.Trees_4;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(p.val <= root.val && root.val <= q.val  || q.val <= root.val && root.val <= p.val)
                return root;

            if(p.val < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return null;
    }
}