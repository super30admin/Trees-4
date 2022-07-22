//Time : O(logn) Perfect BST
//Space : O(n) constructing a new BST

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
        return kthSmallest(rootWithCount, k);
    }

    private TreeNodeWithCount buildTreeWithCount(TreeNode root) {
        if (root == null)
            return null;
        TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
        rootWithCount.left = buildTreeWithCount(root.left);
        rootWithCount.right = buildTreeWithCount(root.right);
        if (rootWithCount.left != null)
            rootWithCount.count += rootWithCount.left.count;
        if (rootWithCount.right != null)
            rootWithCount.count += rootWithCount.right.count;
        return rootWithCount;
    }

    private int kthSmallest(TreeNodeWithCount rootWithCount, int k) {
        if (k <= 0 || k > rootWithCount.count)
            return -1;
        if (rootWithCount.left != null) {
            if (rootWithCount.left.count >= k)
                return kthSmallest(rootWithCount.left, k);
            if (rootWithCount.left.count == k - 1)
                return rootWithCount.val;
            return kthSmallest(rootWithCount.right, k - 1 - rootWithCount.left.count);
        } else {
            if (k == 1)
                return rootWithCount.val;
            return kthSmallest(rootWithCount.right, k - 1);
        }
    }

    class TreeNodeWithCount {
        int val;
        int count;
        TreeNodeWithCount left;
        TreeNodeWithCount right;

        TreeNodeWithCount(int x) {
            val = x;
            count = 1;
        };
    }
}

public class kthSmallestinBST {

}
