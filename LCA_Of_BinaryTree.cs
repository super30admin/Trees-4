// time complexity - O(n)
// space complexity - O(1)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution
{
    List<TreeNode> path1 = new List<TreeNode>();
    List<TreeNode> path2 = new List<TreeNode>();
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null)
        {
            return null;
        }
        if (root == p || root == q)
        {
            return root;
        }
        TreeNode left = LowestCommonAncestor(root.left, p, q);
        TreeNode right = LowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
        {
            return root;
        }
        if (left != null)
        {
            return left;
        }
        else
        {
            return right;
        }
        // backtracking solution
        // backtrack(root,p,path1);
        // backtrack(root,q,path2);

        // int i=0;
        // while(i<path1.Count() && i<path2.Count())
        // {
        //     if(path1[i] !=path2[i])
        //     {
        //         break;
        //     }
        //     i++;
        // }
        // return path1[i-1];
    }
    public void backtrack(TreeNode root, TreeNode p, List<TreeNode> path)
    {
        // base
        if (root == null)
        {
            return;
        }
        path.Add(root);
        if (root == p)
        {
            return;
        }

        // logic
        backtrack(root.left, p, path);
        if (path[path.Count() - 1] == p) return;
        backtrack(root.right, p, path);
        if (path[path.Count() - 1] == p) return;

        //backtrack
        path.RemoveAt(path.Count() - 1);
    }
}