// Time Complexity : O(N+H)
// Space Complexity : O(3*H) =  O(H)
// Did this code successfully run on Leetcode : Yes
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
        if (root == null) return root;

        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();

        backtracking(root, p, q, new ArrayList<>());

        for ( int i = 0; i < pathP.size(); i++) {
            if (pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i-1);
            }
        }

        return null;
    }

    private void backtracking(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base case
        if (root == null) {
            return;
        }
        //logic
        //action
        path.add(root);
        if (root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }
        if (root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }

        //recurse
        backtracking(root.left, p, q, path);
        backtracking(root.right, p, q, path);

        //backtracking
        path.remove(path.size()-1);
    }
}

// Optimized
// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
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
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (right !=null && left == null) {
            return right;
        } else {
            return root;
        }

    }
}
