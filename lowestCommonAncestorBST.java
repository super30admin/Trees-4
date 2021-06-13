RECURSIVE SOLUTION
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
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}

//Time Complexity = O(h)
//Space Complexity = O(h)
h -> height of tree

==========================================================================================

ITERATIVE SOLUTION

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(p.val < root.val && q.val < root.val) {
                root = root.left;
            }else if(p.val > root.val && q.val > root.val) {
                root = root.right;
            }else return root;
        }    
    }
}

//Time Complexity = O(h)
//Space Complexity = O(h)
