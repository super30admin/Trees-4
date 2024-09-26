//Iterative Solution
//Time: O(N) -> in case of skewed BST otherwise it can be O(logn)
//Space: O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    
        if(p.val < root.val && q.val > root.val)
            return root;
        if(q.val < root.val && p.val > root.val)
            return root;
        
        while(root != null)
        {
            if(p.val < root.val && q.val < root.val)
                root = root.left;
            else if(p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
        
        return root;
        
    }
}



/*
//Recursive
Time: O(N) -> in case of skewed BST 
Space: O(N)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    
        if(p.val < root.val && q.val < root.val)
            //go to your left
            return lowestCommonAncestor(root.left, p, q);
        else if(p.val > root.val && q.val > root.val)
            //go to your right
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}
*/
