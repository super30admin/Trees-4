// Time Complexity : O(n)
// Space Complexity : O(h) h=height of the stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach - Do inorder traversal, as the K value reaches 0 
// as it decrements with each recursive call, return the root value.

// Iterative
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || st.isEmpty()) {
            while(root!=null) { // inorder
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k==0) return root.val; // k reached 0, return val
            root = root.right;
        }
        return -1;
    }
}

// Recursive

class Solution {
    int count, result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }
    
    private void inorder(TreeNode root) {
        //base
        if(root == null) return;
        //logic
        inorder(root.left);
        count--;
        if(count==0) {
            result = root.val;
            return;
        }
        inorder(root.right);
    }
}


