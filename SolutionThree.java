// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :nopes

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class SolutionThree {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {

        if(root==null)
            return -1;


        count=k;
        searchNode(root);
        return result;
    }

    public void searchNode(TreeNode root)
    {
        if(root==null)
            return;

        searchNode(root.left);
        count--;
        if(count==0)
        {
            result=root.val;
            return;
        }
        searchNode(root.right);

    }

}