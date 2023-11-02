// # Time Complexity:  O(n) where n is the number of nodes
// #  Space Complexity:  O(h) where is the height of the tree. 
// #  Did this code successfully run on Leetcode : Yes
// #  Any problem you faced while coding this : No

import java.util.*;

// Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        dfs(root, p, q, new ArrayList<>());

        int lenP = pathP.size();
        int lenQ = pathQ.size();
        int i =  0;
        int j = 0;
        while (i < lenP && j < lenQ) {
            TreeNode x = pathP.get(i);
            TreeNode y = pathQ.get(j);
            if(x.val != y.val) {
                return pathP.get(i-1);
            }
            i += 1;
            j += 1;
        }
        return null;
    }
    

    public void  dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {

        //base
        if(root == null || (pathP.size() > 0 && pathQ.size() > 0)) {
            return;
        }


        path.add(root);
        if(root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }
        if(root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        path.remove(path.size()-1);
    }
}
