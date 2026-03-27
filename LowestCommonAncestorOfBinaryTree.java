// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to have 2 separate list of tree nodes to track the paths of finding p and q nodes.During the
traversal, we keep on adding the root nodes to this path by visiting left and right sub trees recursively.
At any time, if we find p and q nodes, we copy that path to these respective treenode paths.For better time &
space complexities, we backtrack at every recursion instead of using deep copies of path.Now, we iterate
through the respective node paths and when the 2 nodes dont match, the node just before unmatched node gives
us the lowest common ancestor.
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
        helper(root, p, q, new ArrayList<>());
        for(int i = 0 ; i < pathP.size() ; i++) {
            if(pathP.get(i) != pathQ.get(i))
                return pathP.get(i - 1);
        }
        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        if(root == null)
            return;
        path.add(root);
        if(root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }

        if(root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }


        helper(root.left , p, q, path);
        helper(root.right, p , q, path);
        path.remove(path.size() - 1);
    }
}