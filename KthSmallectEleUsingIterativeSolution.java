// Time Complexity : O(n) -> number of nodes
// Space Complexity : O(h) -> height of the stack
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class KthSmallectEleUsingIterativeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
         TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty() || root!=null)
        {
            while(root!=null)
            {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k == 0) return root.val;
            root = root.right;
        }
        return 0;
    }
}
