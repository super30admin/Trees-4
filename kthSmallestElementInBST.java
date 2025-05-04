// Time Complexity : O(h + k) where h = ht of tree and visits k nodes
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - Perform inorder traversal (left-root-right) since BST inorder gives sorted order.
//   - Keep a counter `count` to track visited nodes.
//   - When `count == k`, we found kth smallest and store node in `result`.
//   - Stop recursion early once found.


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class kthSmallestElementInBST {
    // List<Integer> inorderList = new ArrayList<>();
    // private void __inorder(TreeNode root) {
    //     if(root == null) {
    //         return;
    //     }
    //     __inorder(root.left);
    //     inorderList.add(root.val);
    //     __inorder(root.right);
    // }

    // public int kthSmallest(TreeNode root, int k) {
    //     if(root == null) {
    //         return -1;
    //     }
    //     __inorder(root);
    //     return inorderList.get(k-1);
    // }


    int count; //to keep cnt check with k
    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
        this.count = 0;
        inorder(root, k);
        return result.val;
    }

    private void inorder(TreeNode root, int k) {
        if(root == null || result != null) {
            return;
        }

        inorder(root.left, k);
        count++;
        if(count == k) {
            result = root;
        }
        inorder(root.right, k);
    }

    public static void main(String[] args) {
        // Build a BST
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        kthSmallestElementInBST obj = new kthSmallestElementInBST();
        int k = 3;
        System.out.println("The " + k + "th smallest element is: " + obj.kthSmallest(root, k));  // Expected: 3

    }
}
