//TC will be O(h), where h is the height of the tree
//SC will be O(h)

//USing recursive approach

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class SolutLowerCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }

        return lca(root, p, q);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        //base
        if(root == null){
            return null;
        }
        //logic
        if(root.val > p.val && root.val > q.val){
            return lca(root.left, p, q);
        }
        else if(root.val < p.val && root.val< q.val){
            return lca(root.right, p, q);
        }
        else{
            return root;
        }
    }

    public static void main(String[] args) {
        // Create the BST using the correct data structure
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.right; // Node with value 8

        SolutLowerCommonAncestorBST obj = new SolutLowerCommonAncestorBST();
        TreeNode result = obj.lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor: " + result.val);
    }
}