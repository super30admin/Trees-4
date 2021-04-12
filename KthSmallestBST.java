import java.util.ArrayList;
import java.util.List;
//tc : O(n)
//sc : O(n); n = #nodes
public class KthSmallestBST {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return list.get(k - 1);
    }
    public void inorder(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                inorder(root.left);
            }
            // System.out.println(root.val);
            list.add(root.val);
            if (root.right != null) {
                inorder(root.right);
            }
        }

    }
}
