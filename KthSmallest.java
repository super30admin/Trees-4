/**
 * Description: Given a binary search tree (BST), find the k-th smallest element in it.
 * 
 * Approach: In-order traversal of the BST gives elements in sorted order.
 * We can use a counter to find the k-th smallest element.
 * - We perform a depth-first search (DFS) starting from the root, traversing the left subtree,
 * - then visiting the current node, and finally traversing the right subtree.
 * - The first time the counter reaches k, we return the value of the current node.
 * 
 * Time Complexity: O(N) in the worst case, where N is the number of nodes.
 * Space Complexity: O(H) where H is the height of the tree (due to recursion stack).
 */
public class KthSmallest {
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, k);
    }

    private int dfs(TreeNode node, int k) {
        if (node == null) {
            return -1;
        }

        int left = dfs(node.left, k);
        if (left != -1) {
            return left;
        }

        count++;
        if (count == k) {
            return node.val;
        }

        return dfs(node.right, k);
    }
}
