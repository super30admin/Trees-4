
 // Time Complexity : O(N+k)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

// We will set a count variable , which is equal to k. Then we will traverse in preorder manner and keep decrementing count. 
// We will be at kth smallest index when count becomes 0
 class Solution {
    TreeNode result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        this .count=k;
        inorder(root);
        return result.val;
    }
    private void inorder(TreeNode root)
    {
        //base
        if(root==null) return;
        //logic
        if(result==null)
        {
        inorder(root.left);
        count--;
        }
        if(count==0)
        {
            result=root;
        }
        if(result==null)
        {
            inorder(root.right);
        }
        
    }
}