/**
Running Time Complexity: Height of the tree or O(log n)
Space Complexity: Height of the tree becasue most node recursion can conatain is in height only 
Successfully Run and Compiled on leetcode 
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
        while(true){
            if (p.val<root.val && q.val<root.val) root = root.left;
            else if (p.val>root.val && q.val>root.val) root = root.right;
            else return root;
        
        }
        }
}