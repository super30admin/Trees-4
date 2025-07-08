// Problem 1: Kth Smallest Element in a BST
class KthSmallestInBST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int count = 0, result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null)
            return;
        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }

    // Example usage
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        KthSmallestInBST sol = new KthSmallestInBST();
        System.out.println("Kth Smallest (k=1): " + sol.kthSmallest(root, 1)); // Output: 1
    }
}

// Problem 2: Lowest Common Ancestor of a Binary Search Tree
class LCAofBST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    // Example usage
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        TreeNode p = root.left; // 2
        TreeNode q = root.left.right; // 4
        LCAofBST sol = new LCAofBST();
        TreeNode lca = sol.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of BST: " + (lca != null ? lca.val : "null")); // Output: 2
    }
}

// Problem 3: Lowest Common Ancestor of a Binary Tree
class LCAofBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }

    // Example usage
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode p = root.left; // 5
        TreeNode q = root.left.right.right; // 4
        LCAofBinaryTree sol = new LCAofBinaryTree();
        TreeNode lca = sol.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of Binary Tree: " + (lca != null ? lca.val : "null")); // Output: 5
    }
}