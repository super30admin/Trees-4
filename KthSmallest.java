/* INORDER iterative, O(N) 
 * */

class Solution {
    int count = 0;
    int ans; 
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }
    
    public void inorder(TreeNode root, int k){
        if (root == null) return ;
        inorder(root.left,k);
        count += 1;
        if (count == k) {ans = root.val;}
        inorder(root.right,k);
    }
}
