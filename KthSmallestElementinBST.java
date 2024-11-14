class Solution {
    int count;
    int result=0;
    public int kthSmallest(TreeNode root, int k) {
        this.count=0;
        helper(root,k);
        return result;
    }
    
    private void helper(TreeNode root,int k){
        if(root==null) return;
        
        if(count!=k);
            helper(root.left,k);
        count++;
        if(count==k){
            this.result=root.val;
            return;
            
        }
        
        
        if(count!=k)
            helper(root.right,k);
    }
}