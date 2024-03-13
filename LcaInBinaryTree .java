// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Keep track of p and q's paths. Once they are found, store them
// in variables. Iterate the paths and keep updating the results
// as long as they are same.

import java.util.ArrayList;
import java.util.List;

class LcaInBinaryTree {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q, new ArrayList<>());

        TreeNode res = null;
        int i = 0;
        int j = 0;
        while (i < pathP.size() && j < pathQ.size()) {
            if (pathP.get(i) == pathQ.get(i)) {
                res = pathP.get(i);
                i++;
                j++;
            } else {
                break;
            }
        }

        return res;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // both nodes are found
        if (root == null || (pathP != null && pathQ != null)) {
            return;
        }
        path.add(root);

        if (root == p) {
            pathP = new ArrayList<>(path);
        }

        if (root == q) {
            pathQ = new ArrayList<>(path);
        }

        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        path.remove(path.size() - 1);
    }
}