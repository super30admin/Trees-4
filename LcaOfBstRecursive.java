/* Approach: 
Since this is a binary search tree, lowest common ancester withh always be the node that satisfies the condition of one nodes value being less than the nodes and one nodes value being larger than the node 
We can recursively traverse the tree and reduce the search space by half.
If current nodes value is greater than both nodes values, than the node we are looking for would be in the left half. And vice versa.
In any other condition, we have found the root.

Time complexity: O(H), in worst case, we would traverese the length
Space complexity: O(H)
*/
public class LcaOfBstRecursive {
    TreeNode rootToReturn;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return rootToReturn;
    }
    
    private void helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(p.val > root.val && q.val > root.val)
            helper(root.right, p, q);
        else if(p.val < root.val && q.val < root.val)
            helper(root.left, p, q);
        else
            rootToReturn = root;
    }
}

/*
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(p.val > root.val && q.val > root.val)
        return lowestCommonAncestor(root.right, p, q);
    else if(p.val < root.val && q.val < root.val)
        return lowestCommonAncestor(root.left, p, q);
    else
        return root;
}
*/