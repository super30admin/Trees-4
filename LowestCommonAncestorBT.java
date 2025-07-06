import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 236. Lowest Common Ancestor of a Binary Tree
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
// ------------------------- Solution 1 --------------------------------
public class LowestCommonAncestorBT {
    /**
     * Prepare list/path of all ancestors for both p and q nodes using backtracking. In both these lists traverse from
     * end starting at the same index as of the shorter list and find the first common node, that's the LCA
     *
     * TC: O(n + h) = O(n) n -> all nodes h -> height of tree/max length of the path lists we need to iterate
     * Auxiliary SC: O(h) h -> height of the tree, worst case O(n), complete BST O(log n)
     * Recursive stack SC: O(h) h -> height of the tree, worst case O(n), complete BST O(log n)
     */
    List<TreeNode> pList;
    List<TreeNode> qList;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> path = new ArrayList<>();
        backtracking(root, p, q, path);

        int min = Math.min(pList.size(), qList.size()) - 1;

        while (min >= 0) {
            if (pList.get(min) == qList.get(min)) {
                return pList.get(min);
            }
            min--;
        }
        return null;
    }

    private void backtracking(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        //base
        if (root == null || (pList != null && qList != null)) {
            return;
        }

        //logic
        //action
        path.add(root);
        if (p == root) {
            pList = new ArrayList<>(path);
        }
        if (q == root) {
            qList = new ArrayList<>(path);
        }

        //recurse
        backtracking(root.left, p, q, path);
        backtracking(root.right, p, q, path);

        //backtrack
        path.remove(path.size() - 1);
    }
}

// ------------------------- Solution 2 --------------------------------
class LowestCommonAncestorBT2 {
    /**
     * bottom up recursion to bubble up the LCA/root of either p and q. At any node if bubbled up nodes from both subtrees
     * are different that's the LCA otherwise keep bubbling up p or q till the root. Bubble up approach needs post-order
     * level logic
     *
     * TC: O(n) visit all nodes
     * Auxiliary SC: O(1)
     * Recursive stack SC: O(h) h -> height of the tree, worst case O(n), complete BST O(log n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if (root == null || root == p || root == q) {
            return root;
        }

        //logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return root;
        }
    }
}