import java.util.*;

// Time Complexity: O(n)
// Space Complexity: O(n) for the result list
public class KSmallestBST {

    List<Integer> result = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return result.get(k - 1);
    }

    public void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        result.add(node.val);
        inorder(node.right);
    }
}
