public class KthSmallestElement
	{
        // Time Complexity : O(n), n nodes
        // Space Complexity : O(1) - other than the recursive stack space
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        int count;
        int result;
        public int KthSmallest(TreeNode root, int k)
        {
            inorder(root, k);
            return result;
        }

        private void inorder(TreeNode root, int k)
        {
            //base
            if (root == null)
                return;
            //logic

            inorder(root.left, k);
            count++;
            if (count == k)
            {
                result = root.val;
                return;
            }
            if (count < k)
            {
                inorder(root.right, k);
            }
        }
}
