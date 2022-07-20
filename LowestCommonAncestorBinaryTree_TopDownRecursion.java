/* Time Complexity: O(n)
 * Space Complexity: O(h), h is the height of the tree, recursive stack space
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

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
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //null
        if(root == null) return null;
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        helper(root, p, q, new ArrayList<>());
        for(int i = 0; i < pathP.size(); i++){
            if(pathP.get(i) != pathQ.get(i)){
                return pathP.get(i-1);
            }
        }
        return null;
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root == null) return;
        //action
        path.add(root);
        if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }
        if(root == q){
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }
        
        //logic
              
        //recurse
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);
        //backtrack
        path.remove(path.size() - 1);
    }
}