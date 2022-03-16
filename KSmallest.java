class Solution {
    int counter = 0;
    int ans = -1;
    int k;
    
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        helper(root);
        return ans;
    }
    private void helper(TreeNode root){
        if(root== null ) return;
        helper(root.left);
        counter++;
        if(counter==k) {
            ans = root.val;
            return;
        }
        
        helper(root.right);
    }
}
// time complexity- O(n)
//space complexity- O(n)