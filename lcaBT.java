// TC - O(n+h) (n for traversal and h for the final run through the P and Q
//      path arrays and h again for adding p and q paths, and path array also h)
// SC - O(h) for the queue

// Approach
// we will need some way to track the path from root to the element (we can do
// preorder traversal). Once we have the 2 paths, compare each element in each
// path and go on until both have common elements. As soon as it's not same,
// the prev one is the lowest common ancestor.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    List<TreeNode> pathP, pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        dfs(root, p, q, new ArrayList<>());

        // once we find path, traverse and find common nodes
        // and we don't need to bother checking the list lengths since
        // always there are 2 elements minimum, and there's always a mismatch
        for(int i=0; i<pathP.size(); i++) {
            if(pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i-1);
            }
        }
        
        return null;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        if(root == null) {
            return;
        }

        // action
        // traverse current node
        path.add(root);
        if(root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(p); // since node is its own parent
        }
        if(root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(q); // since node is its own parent
        }

        // recurse
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);

        // backtrack
        path.remove(path.size() - 1);
    }
}