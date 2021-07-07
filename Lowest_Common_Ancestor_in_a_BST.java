
TC:O(n)
SC:O(1)

27 / 27 test cases passed.
Status: Accepted
Runtime: 4 ms

Approach: We will check whether the p and q values are both either left or right and if so traverses that corresponding child node.
Whenever this is not the case, ie if root is an in between value, it is our answer. Return this node as answer.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val< root.val && q.val< root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val> root.val && q.val> root.val){
            return  lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}

