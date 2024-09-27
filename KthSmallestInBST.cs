using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class KthSmallestInBST
    {
        /// Time Complexity : O(n)
        // Space Complexity :O(n)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        public int KthSmallest(TreeNode root, int k)
        {
            Stack<TreeNode> st = new Stack<TreeNode>();
            while (root != null || st.Count != 0)
            {
                while (root != null)
                {
                    st.Push(root);
                    root = root.left;
                }
                root = st.Pop();
                k--;
                if (k == 0) return root.val;
                root = root.right;
            }
            return 4456;
        }


        /// Time Complexity : O(n)
        // Space Complexity :O(n)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        int count = 0;
        int result = 0;
        public int KthSmallest_recursive(TreeNode root, int k)
        {
            this.count = k;
            helper(root);
            return result;

        }

        private void helper(TreeNode root)
        {
            if (root == null) return;

            helper(root.left);
            count--;
            if (count == 0)
            {
                result = root.val;
                return;
            }
            helper(root.right);
        }
    }
}
