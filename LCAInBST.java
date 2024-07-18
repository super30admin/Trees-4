//Time - O(n)
//Space - O(h)
public class LCAInBST {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        helper(root,  p, q);
        return res;
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return;

        if(root.val <= p.val && root.val >= q.val){
            res = root;
            return;
        } else if(root.val <= q.val && root.val >= p.val) {
            res = root;
            return;
        } else if(root.val < p.val && root.val < q.val) {
            helper(root.right, p, q);
        } else if(root.val > p.val && root.val > q.val) {
            helper(root.left, p, q);
        }
    }

     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
