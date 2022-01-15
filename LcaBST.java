// Time Complexity: O(h) h is height of Tree
// Space Complexity: O(h) h is height of Tree
// Recursive
public class LcaBst 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        // Using BST as an advantage to reduce the search space
        if(root.val > p.val  && root.val > q.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(root.val < p.val  && root.val < q.val)
        {
            return lowestCommonAncestor(root.right, p, q);
        }
        else
        {
            return root;
        }
    }
}

// Time Complexity: O(h) h is height of Tree
// Space Complexity: O(1)
// iterative
public class LcaBst{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        while(true)
        {
            if(root.val > p.val && root.val > q.val)
            {
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val)
            {
                root = root.right;
            }
            else
                return root;
        }        
    }
}