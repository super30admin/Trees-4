// Time Complexity : O(n)
// Space Complexity : Recursive Stack Space O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
 * 1 - We will perform inorder traversal. Once the left node hits null, we will start a counter as it will be in ascending order.
 * 2 - Once the count is equal to k, return the root value.
 */

public class kthSmallest {
    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    public void inorder(TreeNode root, int k)
    {
        //base
        if(root == null)
        {
            return;
        }
        
        //logic
        inorder(root.left,k);
        count++;
        
        if(count == k){
            result = root.val;
            return;
        }
        
        inorder(root.right,k);
    }
}
