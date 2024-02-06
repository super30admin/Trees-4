// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : DFS

class Solution {

    int count = 0, result = 0;

    public int kthSmallest(TreeNode root, int k) {
        
        helper(root, k);

        return result;
    }

    private boolean helper(TreeNode root, int k)
    {
        if(root == null) return false;

        if(helper(root.left, k) == true) return true;

        ++count;
        if(count == k)
        {
            result = root.val;
            return true;
        }

        if(helper(root.right, k) == true) return true;

        return false;
    }
}