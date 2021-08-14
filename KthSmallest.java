// Time Complexity : o(n)
// Space Complexity : 0(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        result = 0;
        if(root == null) {
            return result;
        }

        count = 0;
        helper(root,k);

        return result;
    }

    private void helper(TreeNode root, int k) {
        if(root == null) {
            return;
        }

        helper(root.left,k);
        count++;
        if(count == k) {
            result = root.val;
            return;
        }
        // System.out.println(root.val + ", " + count);
        helper(root.right,k);
    }
}

