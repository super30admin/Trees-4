/*
Desc : We move in inorder fashion to encounter the kth element, as we would be traveersing from smaller to larger element
we would find our kth smallest element on the kth element of inorder traversal itself.
Time Complexity : O(n)
Space Complexity : O(1)
*/

class Solution {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return result;
    }
    private void inorder(TreeNode root,int k){
        if(root == null) return;
        
        //logic
        inorder(root.left, k);
        count++;
        if(count == k){
            result = root.val;
        }
        inorder(root.right,k);
    }
}
