// Time Complexity : O(n)
// Space Complexity :O(logn)
class Solution {
    int count;
    int smallest;
    public int kthSmallest(TreeNode root, int k) {
       count = 0;
        inorder(root,k);
        return smallest;
    }
    
    public void inorder(TreeNode root, int k){
        if(root==null)
            return;
        if(count<k)
            inorder(root.left,k);
        count++;
        if(count==k)
            smallest = root.val;
        if(count<k)
            inorder(root.right,k);
        
    }
}
x