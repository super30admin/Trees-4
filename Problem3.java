/*
    LC - 236. Lowest Common Ancestor of a Binary Tree
    TC - O(n)
    SC - O(n)
    Approach -
        Using DFS traversal + backtracking
            why backtracking - we need to get the path for P & Q.
            In some path, it may not find the P. so it needs to backtrack and check the remaining path
        store the pathP & pathQ separately in the list
        traverse the pathP and check both val in the path
        if it is unequal, return the i - 1 as we are adding twice if p & q found
        else return null;
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
        if(root == null) {
            return root;
        }
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        dfs(root, p, q, new ArrayList<>());
        for(int i=0; i<pathP.size(); i++) {
            if(pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i - 1);
            }
        }
        return null;
    }
    public void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base
        if(root == null || (pathP.size() > 0 && pathQ.size() > 0)) {
            return;
        }

        // logic
        path.add(root);
        if(root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        path.remove(path.size() - 1);
    }
}