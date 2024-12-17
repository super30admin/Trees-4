// time Complexity : O(n) where n is the number of nodes in the tree
// Space complexity: O(h) h is height of the tree. Recursive stack space
public class LCAofBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        // base case
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }

        // recursively traverse left and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // if both left and right are not null root is the LCA
        if (left != null && right != null){
            return root;
        }
        return (left != null) ? left : right ;
    }
    public static void main(String [] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Nodes for which we want to find the LCA
        TreeNode p = root.left;        // Node with value 5
        TreeNode q = root.left.right.right; // Node with value 4

        // Create an instance of the class
        LCAofBinaryTree tree = new LCAofBinaryTree();

        // Find LCA
        TreeNode lca = tree.lowestCommonAncestor(root, p, q);

        // Print the result
        if (lca != null) {
            System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
        } else {
            System.out.println("No common ancestor found.");
        }
    }
}

