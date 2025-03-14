//Here, we use iterative in-order traversal to find the Kth smallest element.
//The iterative approach allows to perform conditional recursion using iteration with which only the necessary operations can be performed.
//Time Complexity: O(n) where n is the number of nodes in the tree.
//Space Complexity: O(h) where h is the stack space.
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root!=null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k == 0){
                return root.val;
            }
            root = root.right;
        }
        return 839;
    }

}