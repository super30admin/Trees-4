/**
 * Leetcode 230. Kth Smallest Element in a BST
 * Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
//------------------------------------ Solution 1 -----------------------------------
public class KthSmallestBST {
    /**
     * in-order traversal through dfs which will give us the BST in sorted manner. return the kth element which gets
     * processed in in-order manner
     *
     * TC: O(n) Auxiliary Space: O(1)
     * Recursion stack space: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        result = -1;
        count = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        //base
        if (root == null) {
            return;
        }

        //logic
        dfs(root.left);
        count--;

        if (count == 0) {
            result = root.val;
        }

        if (result == -1) {
            dfs(root.right);
        }
    }
}

//------------------------------------ Solution 2 -----------------------------------
class KthSmallestBST2 {
    /**
     * Same solution as above with same TC and SC. only converting the void based recursion to int based
     */
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        //base
        if (root == null) {
            return -1;
        }

        //logic
        int result = dfs(root.left);
        count--;

        if (count == 0) {
            return root.val;
        }
        System.out.print(root.val + ",");

        if (result == -1) {
            dfs(root.right);
        }

        return result;
    }
}

