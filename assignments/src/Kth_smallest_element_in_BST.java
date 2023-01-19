import java.util.*;

// Approach: Go to the leftmost bottom first as that will be the smallest, travel back up to right
// of each node if there is, else keep going up to root and then similarly on the right side.
// Make sure to maintain a count k and do k-- everytime a node is popped from the stack. Finally,
// return the element root's val if the count k reaches 0.
// Time: O(H + k) where H is height of the tree and k is the i/p k
// Space: O(H)
class Kth_smallest_element_in_BST {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}