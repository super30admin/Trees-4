// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// We compare the value with current node, if both values are smaller than root node, then answer lies on left, otherwise right
// Then we go to left sub tree or right subtree
// If one value is smaller than current node and other is greater or equal than current node, it means current node is LCA
// We keep going like this until we find the answer

//Iterative approach
public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {    
    
    while(root != null)
    {
        if(root.val < p.val && root.val < q.val)
            root = root.right;
        else if(root.val > p.val && root.val > q.val)
            root = root.left;
        else
            return root;
    }
    return null;
}

//recursive approach
public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
               
    if(root.val > p.val && root.val > q.val)
        return LowestCommonAncestor(root.left, p, q);
    
    else if(root.val < p.val && root.val < q.val)
        return LowestCommonAncestor(root.right, p, q);
    
    else
        return root;
}