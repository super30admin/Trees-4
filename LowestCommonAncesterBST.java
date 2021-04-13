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
        
        while(root != null){
            //if nodes are on either side of tree then return root
             if(root.val > p.val && root.val < q.val || root.val < p.val && root.val > q.val){
                    return root;
            }
            // if one node you are searching for is root then return root
            if(p.val == root.val || q.val == root.val){
                    return root;
            }
            //if both the nodes are less than root then move to left sub tree
            //else move to right sub tree
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return root;
    }
}
//Time Complexity: O(log n) n -> number of nodes
//Space Complexity: O(1)