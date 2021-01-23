/*Time Complexity - O(N)
Space Complexity - O(N)
*/
class Solution {
    int kthSmall;
    int count;
    boolean flag = false;
    public int kthSmallest(TreeNode root, int k) { 
        count = k;
        helper(root); 
        return kthSmall;
    }
    
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        count--;
        if(count==0 && !flag){
            kthSmall = root.val;
            flag = true;
            return;
        }
        helper(root.right);
    }
}