// Time complexity: O(h) where h is the height of the tree and it becomes O(log n) for a perfectly balanced tree
// space complexity : O(h) recursive stack space

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x){val = x;
    }
}
public class LCAinBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);

        }
        return root;
    }

    public static void main(String [] args) {
           LCAinBST bst = new LCAinBST();

           TreeNode root = new TreeNode(6);
           root.left = new TreeNode(2);
           root.right = new TreeNode(8);
           root.left.left = new TreeNode(0);
           root.left.right = new TreeNode(4);
           root.right.left = new TreeNode(7);
           root.right.right = new TreeNode(9);
           root.left.right.left = new TreeNode(3);
           root.left.right.right = new TreeNode(5);

            // Nodes for which we want to find the LCA
            TreeNode p = new TreeNode(2); // Node 2
            TreeNode q = new TreeNode(8); // Node 8

            // Find LCA
            TreeNode lca = bst.lowestCommonAncestor(root, p, q);

            // Print the result
            if (lca != null) {
                System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
            } else {
                System.out.println("No common ancestor found.");
            }
        }
    }

