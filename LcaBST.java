class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LcaBST {

    // TC : O(h) h - height of tree
    // SC : O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        TreeNode current = root;

        while(current != null) {
            if(p.val < current.val && q.val < current.val) {
                current = current.left;
            }else if(p.val > current.val && q.val > current.val) {
                current = current.right;
            }else return current;

        }
        return null;
    }
}
