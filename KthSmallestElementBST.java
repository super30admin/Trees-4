import java.util.Stack;
//TC: O(n), SC: O(n)
//Approach: The approach is to do an inorder traversal because in a BST, inorder traversal sorts the elements in the tree in ascending order
//which means that when we traverse to the left most node, we are at the lowest value, and we keep traversing until k = 0, return the output
public class KthSmallestElementBST {

    public int kthSmallest(TreeNode root, int k) {
        final Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            k--;

            if (k == 0) return root.val;
            root = root.right;
        }

        return -1;
    }
}
