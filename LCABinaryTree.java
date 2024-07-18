import java.util.ArrayList;
import java.util.List;

class LCABinaryTree {
    List<TreeNode> plist, qlist;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        plist = new ArrayList<>();
        qlist = new ArrayList<>();
        helper(root, p, q, new ArrayList<>());

        int len = Math.min(plist.size(), qlist.size());
        for(int i=0; i<len; i++) {
            if(plist.get(i).val != qlist.get(i).val) {
                return plist.get(i-1);
            }
        }

        return null;
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> locallist) {
        if(root == null) return;

        locallist.add(root);

        if(root == p) {
            plist = new ArrayList<>(locallist);
            plist.add(root);
        }
        if(root == q) {
            qlist = new ArrayList<>(locallist);
            qlist.add(root);
        }

        helper(root.left, p, q, locallist);
        helper(root.right, p, q, locallist);

        locallist.remove(locallist.size()-1);
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