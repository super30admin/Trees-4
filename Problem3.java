import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> pNode;
    List<TreeNode> qNode;

    // BackTracking
    // TC : O(n)
    // SC : O(h) where h is height of tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;

        backTracking(root, p, q, new ArrayList<>());

        for (int i = 0; i < pNode.size(); i++) {
            if (pNode.get(i) != qNode.get(i)) {
                return pNode.get(i - 1);
            }
        }
        return root;
    }

    private void backTracking(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        //base case
        if (root == null) return;

        //logic
        path.add(root);
        if (root.val == p.val) {
            pNode = new ArrayList<>(path);
            pNode.add(root);
        }
        if (root.val == q.val) {
            qNode = new ArrayList<>(path);
            qNode.add(root);
        }
        //action
        backTracking(root.left, p, q, path);
        backTracking(root.right, p, q, path);
        //recurse
        path.remove(path.size() - 1);
    }

    // Bottom-up Recusrion
    // TC : O(n)
    // SC : O(h)
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);

        if (left == null && right == null){
            return null;
        }
        else if (left != null && right == null){
            return left;
        }
        else if (left == null && right != null){
            return right;
        }
        return root;
    }
}
