// Time - O(N+k)
// Space - O(N)

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        int result = 0;
        
        while(root!=null || !st.isEmpty()) {
            while(root!=null) {
                st.push(root);                
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k==0) {
                result = root.val;
                break;
            }
            root = root.right;
        }
        
        return result;
    }
}
