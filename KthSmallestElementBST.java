// Time Complexity :O(N)
// Space Complexity :O(K)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach: recursion

class Solution {
    int count=0;
    int result=0;
    public int kthSmallest(TreeNode root, int k) {
        int count=0;
        helper(root,k);
        return result;
    }
    public void helper(TreeNode root, int k){
        if(root==null) return;

        helper(root.left, k);
        count++;
        if(count==k) {
            result=root.val;
            return;
        }
        helper(root.right, k);

    }
}