/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time: O(n+2h) in worst case
// Space: O(n+h) 
// Idea here is to recursively search for p and q and backtrack if the path does not contain the node.
// if paths are found for both the nodes, we can iterate throught them to identify point of change ot path and return previous node.
class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p ||root==q) return root;
        backtrack(root, p, q, new ArrayList<>());
        for(int i=0; i<pathP.size(); i++) {
            if(pathP.get(i)!=pathQ.get(i)) {
                return pathP.get(i-1);
            }
        }
        return null;
    }
    
    public void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base
        if (root==null) return;
        // logic
        // action
        path.add(root);
        if(root==p) {
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root==q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        
        backtrack(root.left, p, q, path);
        backtrack(root.right, p, q, path);
        
        // backtrack
        path.remove(path.size()-1);
    }
}