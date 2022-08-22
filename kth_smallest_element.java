// Time Complexity : O(k)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution 
{

    public int kthSmallest(TreeNode root, int k) 
    {
        if(root==null)
        {
            return 0;
        }
        int res = -1;

        Stack<TreeNode> st = new Stack<TreeNode>();

        while(!st.isEmpty() || root!=null)
        {
            while(root!=null)
            {
                st.add(root);
                root = root.left;
            }

            root = st.pop();
            k--;
            if(k==0)
            {
                res = root.val;
                break;
            }

            root=root.right;
        }


        return res;
    }


} 