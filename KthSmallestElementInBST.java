import java.util.Stack;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Since a BST inorder traversal gives out a ascending sorted number, we use that property to get the kth smallest element
 */

public class KthSmallestElementInBST {
    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    // ---------- APPROACH 1 - Recursion and inorder traversal -----------------
    int count;
    int smallest;
    public int kthSmallest(TreeNode root, int k) {
       count = k;
       smallest = 0;
       inorder(root);
       return smallest;
    }

    private void inorder(TreeNode root) {
        // base
        if (root == null)
            return;
        
        // logic
        // check left
        inorder(root.left);
        // check root
        count--;
        if (count == 0) {
            smallest = root.val;
            return;
        }
        // check right
        inorder(root.right);
    }

    // ---------- APPROACH 1 - Iterative and inorder traversal -----------------
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            root = s.pop();
            k--;
            if (k == 0) {
                return root.val;
            }

            root = root.right;;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Your code here
        KthSmallestElementInBST obj = new KthSmallestElementInBST();
        TreeNode node1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
        int val = obj.kthSmallest(node1, 4);
        System.out.println(val);
        assert(4 == val);

        TreeNode node2 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
        val = obj.kthSmallest2(node2, 4);
        System.out.println(val);
        assert(4 == val);
    }
}