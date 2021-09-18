//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
/*
Time: O(H+K) where H=Height of the tree
Space: O(N) for Stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class KthSmallestInBST {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }

        return -1;
    }

}
