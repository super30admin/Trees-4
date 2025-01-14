// LC 230

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * NOTE: InOrder traversal of a BST == sorted order
 * Maintain a counter to count for the k-th element reached during this traversal.
 */
public class KthSmallestElementBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * TC: O(n)
     * SC: O(H)
     *
     * @param root
     * @param k
     */
    public int kthSmallest_inorder(TreeNode root, int k) {
        TreeNode[] ans = new TreeNode[1];
        kthSmallest_inorder_dfs(root, new int[]{k}, ans);
        return ans[0].val;
    }

    private void kthSmallest_inorder_dfs(TreeNode root, int[] k, TreeNode[] ans) {
        if (root == null || k[0] == 0) {
            return;
        }
        kthSmallest_inorder_dfs(root.left, k, ans);
        k[0]--;
        if (k[0] == 0) {
            ans[0] = root;
        }
        /*
         * avoid unnecessary iterations
         */
        else if (k[0] > 0) {
            kthSmallest_inorder_dfs(root.right, k, ans);
        }
    }

    /**
     * int-based recursion
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest_inorder_2(TreeNode root, int k) {
        return kthSmallest_inorder_dfs_2(root, new int[]{k});
    }

    private int kthSmallest_inorder_dfs_2(TreeNode root, int[] k) {
        if (root == null) {
            return 0;
        }
        int result = kthSmallest_inorder_dfs_2(root.left, k);
        k[0]--;
        if (k[0] == 0) {
            result = root.val;
        }
        /*
         * avoid unnecessary iterations
         */
        else if (k[0] > 0) {
            result = kthSmallest_inorder_dfs_2(root.right, k);
        }
        return result;
    }

    public int kthSmallest_inorder_iterative(TreeNode root, int k) {
        int result = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode top = stack.pop();
                k--;
                if (k == 0) {
                    result = top.val;
                    break;
                }
                curr = top.right;
            }
        }
        return result;
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest_morrisTraversal(TreeNode root, int k) {
        TreeNode[] ans = new TreeNode[1];
        TreeNode curr = root;
        while (curr != null && k >= 0) {
            TreeNode left = curr.left;
            if (left != null) {
                TreeNode right = left;
                while (right.right != null && right.right != curr) {
                    right = right.right;
                }
                if (right.right == null) {
                    right.right = curr;
                    curr = left;
                } else {
                    k--;
                    if (k == 0) {
                        ans[0] = curr;
                    }
                    right.right = null;
                    curr = curr.right;
                }
            } else {
                k--;
                if (k == 0) {
                    ans[0] = curr;
                }
                curr = curr.right;
            }
        }
        return ans[0].val;
    }
}
