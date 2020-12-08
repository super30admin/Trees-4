class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            
            root = st.pop();
            k--;
            if(k == 0){
                break;
            }
            root = root.right;
            
        }
        return root.val;
    }
}