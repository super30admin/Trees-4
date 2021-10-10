package Trees4;
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
import Trees1.TreeNode;

public class KthSmallestElementBST {
    int count = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return ans;
    }

    private void helper(TreeNode root, int k){
        if(root == null)
            return;
        helper(root.left, k);
        count++;
        if(count == k){
            ans = root.val;
            return;
        }
        helper(root.right, k);
    }
}
