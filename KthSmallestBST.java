// Time Complexity : O(k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class KthSmallestBST {
    class Solution {
        private int result;
        private int count;
        public int kthSmallest(TreeNode root, int k) {
            this.result = 0;
            this.count = 0;
            inorder(root, k);
            return result;
        }
        private void inorder(TreeNode root, int k){
            //base
            if(root == null)
                return;

            //logic
            inorder(root.left, k);
            count++;
            if(count == k){
                result = root.val;
                return;
            }
            if(result == 0)
                inorder(root.right, k);
        }
    }
}
