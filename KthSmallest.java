// the time complexity of this implementation is O(N) where
// N is the number of nodes
import javax.swing.tree.TreeNode;
import java.util.Stack;

class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        // Initialize a stack for the in-order traversal
        Stack<TreeNode> stack = new Stack<>();

        // Initialize a counter for the number of nodes visited
        int count = 0;

        // Traverse the tree in-order using a stack
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            count++;

            if (count == k) {
                return root.val;
            }

            root = root.right;
        }

        // If k is larger than the number of nodes in the tree, return -1 or throw an exception
        return -1;
    }
    public static void main(String[] args) {
        // Create the binary search tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        // Find the kth smallest element
        int k = 3;
        Solution solution = new Solution();
        int kthSmallest = solution.kthSmallest(root, k);

        System.out.println("The " + k + "th smallest element is " + kthSmallest);
    }

}
