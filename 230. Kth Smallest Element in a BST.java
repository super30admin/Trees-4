class Solution {//Time and space of O(N)
    int result = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return result;
    }
    private void helper(TreeNode node){
        if(node.left != null){
            helper(node.left);
        }
        count--;
        if(count == 0){
            result = node.val;
            return;
        }
         if(node.right != null){
            helper(node.right);
        }
    }
    
}