// TC => O(n)
// SC => O(H)

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
public class Solution
{
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public int KthSmallest(TreeNode root, int k)
    {

        AddInStack(root);
        while (k - 1 > 0)
        {
            var node = stack.Pop();
            k--;
            AddInStack(node.right);
        }
        var curr = stack.Pop();
        return curr.val;
    }

    public void AddInStack(TreeNode root)
    {
        while (root != null)
        {
            stack.Push(root);
            root = root.left;
        }
    }
}