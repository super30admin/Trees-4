class Solution {
    //int cnt,ans;
    public int kthSmallest(TreeNode root, int k) {
     /*   if(root==null)return -1;
        cnt=k;
        ans=-1;
        helper(root);
        return ans;
    }
    private void helper(TreeNode root){
        if(root==null|| ans!=-1)return ;
        helper(root.left);
        cnt--;
        if(cnt==0) {
            ans=root.val;
            return;
        }
        helper(root.right); */
        Stack<TreeNode>st=new Stack<>();
        TreeNode curr=root;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            k--;
            if(k==0)return curr.val;
            curr=curr.right;
        }
        return -1;
    }
}