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
// time complexity - O(n)
//spzce complexity - o(k)
public class Solution
{
    int count = 0;
    int res = -1;
    public int KthSmallest(TreeNode root, int k)
    {
        //helper(root,k);
        //return res;
        // iterative solution
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (true)
        {
            while (root != null)
            {
                st.Push(root);
                root = root.left;
            }
            root = st.Pop();
            k--;
            if (k == 0)
            {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
    public void helper(TreeNode root, int k)
    {
        // base
        if (root == null)
        {
            return;
        }
        helper(root.left, k);
        count++;
        if (count == k)
        {
            res = root.val;
        }
        if (count < k)
        {
            helper(root.right, k);
        }
    }
}
