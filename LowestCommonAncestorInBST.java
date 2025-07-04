//time complexity- O(h)
//space complexity- O(1)
public class LowestCommonAncestorInBST {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        /* BST
                    6
                  /   \
                2      8
              /  \    / \
             0    4   7  9
                 / \
                3   5
         */
        TreeNode p = root.left.right , q = root.left.right.right;
        System.out.println("LCA of " + p.val + " and "+ q.val + " is " + lowestCommonAncestor(root, p, q).val);
    }
}
