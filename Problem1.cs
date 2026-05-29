// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree(space occupied by the recursion stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I maintain global variables for result, count and found. I set count = k and result = -1 initially. I then perform inorder traversal 
and for each root node visited, I decrement count by 1. If count equals 0, I set my result to root.val and set found to true and
stop the recursion there.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    int result;
    bool found;
    int count;
    public int KthSmallest(TreeNode root, int k) {
        found = false;
        result = -1;
        count = k;

        Inorder(root);
        return result;
    }

    public void Inorder(TreeNode root)
    {
        //Base Case
        if(root == null)
        {
            return;
        }

        // Logic
        Inorder(root.left);

        count-=1;

        if(count==0)
        {
            result = root.val;
            found = true;
        }

        if(!found)
        {
            Inorder(root.right);
        }

    }
}