/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h) for recursive stack, pathP and pathQ storage
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using the backtracking to keep track of the current path. When the node was found, save the path for that node. After both paths are found, find the LCA by traversing the paths and finding the last common node.
 */
class NonBSTBacktrackingSolution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q, new ArrayList<>());

        // if one node is not ancestor of the other node, then the first divergent node -1 will be the LCA
        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if (pathP.get(i) != pathQ.get(i)) return pathP.get(i - 1);
        }

        // if one node is ancestor of the other node, then last element on the smaller path will be LCA
        return pathP.size() > pathQ.size() ? pathQ.get(pathQ.size() - 1) : pathP.get(pathP.size() - 1);
    }

    private void helper(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> path) {
        if (node == null) return;

        // both p and q are found, so no need to explore further
        if (pathP != null && pathQ != null) return;

        //action
        path.add(node);
        if (node == p) {
            pathP = new ArrayList<>(path);
        }

        if (node == q) {
            pathQ = new ArrayList<>(path);
        }

        //recurse
        helper(node.left, p, q, path);
        helper(node.right, p, q, path);

        //backtrack
        path.remove(path.size() - 1);
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h) for recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using the recursion to find if the p and q are in left or right side of the subtree.
 * If one is in left and other is in right subtree, then LCA is at the current root
 * If one is in left and the other is null, then we return non-null to the parent since it might be descendant of the other node OR it doesn't exist in the other side of the tree
 */
class NonBSTRecursiveSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) {
            return node;
        }

        // if left subtree has p or q, it will return p or q
        TreeNode left = helper(node.left, p, q);
        // if right subtree has p or q, it will return p or q
        TreeNode right = helper(node.right, p, q);

        // if both are non null, we are at LCA
        if (left != null && right != null) return node;
            // if left is null and right is not null, then either left is not in node's leftside sub tree OR it is descendant of rightside subtree
        else if (left == null && right != null) return right;
            // if left is not null and right is null, then either right is not in node's rightside sub tree OR it is descendant of leftside subtree
        else if (left != null && right == null) return left;
            // both left and right were null which means no nodes were found
        else return null;
    }
}