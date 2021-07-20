package Trees4;

public class question102_LowestCommonAncestorOfBinarySearchTree {
    /* Created by palak on 7/19/2021 */

    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*
        Time Complexity: O(h)
        Space Complecity: O(h)
    */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor1(root.right, p, q);
        else if(root.val > p.val && root.val > q.val) return lowestCommonAncestor1(root.left, p, q);
        else return root;
    }

    /*
        Time Complexity: O(h)
        Space Complecity: O(h)
    */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(root.val < p.val && root.val < q.val) root = root.right;
            else if(root.val > p.val && root.val > q.val) root = root.left;
            else return root;
        }
    }

    public static void main(String[] args) {

    }
}
