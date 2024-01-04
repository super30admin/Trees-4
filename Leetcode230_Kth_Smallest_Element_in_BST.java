/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/*
 * Approach-1
 * inorder traveral - get an arraylist build, that's sprted, return kth element
 * tc: O(n) + O(n)
 * sc: O(n)
 */
class Solution {
    List<Integer> list;

    public int kthSmallest(TreeNode root, int k) {
        // base case
        if (root == null)
            return -1;

        list = new ArrayList<>();

        inorder(root);

        return list.get(k - 1);
    }

    private void inorder(TreeNode root) {
        // basecase
        if (root == null)
            return;

        inorder(root.left);

        if (root != null)
            list.add(root.val);

        inorder(root.right);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/*
 * Iterative approach
 * 1. when we do inrderprocessing, we decrement count, and when reach to zero,
 * we just return root.val
 * tc: O(n)
 * sc: O(h) - stack space
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // bsae case
        if (root == null)
            return -1;

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // reached left most leaf
            // pop from the stack
            root = stack.pop();
            k--;

            if (k == 0)
                return root.val;

            // right child processing
            root = root.right;
        }

        return 9394; // we'll n reach ehre!
    }
}

/*
 * conditional recursion
 * DFS approach - when traversing the tree itself, we reduce k , and return that
 * value
 * tc: O(n), sc: o(h)
 * 
 */
class Solution {
    int rootVal, count;
    boolean flag;

    public int kthSmallest(TreeNode root, int k) {
        // base case
        if (root == null)
            return -1;
        rootVal = 0;
        flag = false;
        count = k;

        inorder(root);

        return rootVal;
    }

    private void inorder(TreeNode root) {
        // base case
        if (root == null)
            return;

        if (!flag)
            inorder(root.left);
        count--;
        if (count == 0) {
            flag = true;
            rootVal = root.val;
            return;
        }

        if (!flag)
            inorder(root.right);
    }
}