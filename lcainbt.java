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
        // keeping track of path recursively and then fidning the last common node, would also give the solution, but TC-O(N),SC-O(N+h)
        // less space complexity
        // TC-O(N),SC-O(h)
        // return nodes at each point, if left and right subtrees have the nodes then that is the answer
        // if root is null, return null
        // basically if we find p or q, we return those nodes, if not we return null
        if(root == null || root == p || root == q){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // if left and right are null, return null
        if(left == null && right == null){
            return null;
        }
        else if(left == null && right !=null){
            return right;
        }
        else if(left != null && right ==null){
            return left;
        }
        // left and right are found, i.e they are not null
        else{
            return root;
        }

    }
}