// Definition for a binary tree node.
class TreeNode {
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

// TC : O(n) SC : O(h)
class KthSmallestBST {
    int result;
    int count;
    boolean flag;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        if (!flag)
            inorder(root.left);
        // root
        count--;
        if (count == 0) {
            flag = true;
            result = root.val;
        }
        if (!flag)
            inorder(root.right);
    }
}

// TC : O(log n) SC : O(h)
class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }
}

// using bottom-up approach
class LowestCommonAncestorBT {
    // TC : O(n) SC : O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null)
            return null;
        else if (left != null && right == null)
            return left;
        else if (left == null && right != null)
            return right;
        else
            return root;
    }
}

public class Solution {
}