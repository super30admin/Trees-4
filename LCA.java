//Time complexity: O(N)
//Space Complexity: O(h) (h of the tree)
//Implemented the very first thing that came to my mind on seeing the question not an optimised version. 
//Will resubmit optimised version.
//was accepted in leetcode. 
class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        //Check if the tree is empty or if the current root is p or q then return the node as it is the LCA of p and q
        if((root==null)|| (root==p)||(root==q))
        {
            return root;
        }
        //check the same for all its child nodes on the left and right
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //If the left node is null then return right and viseversa.
        if(left==null) return right;
        if(right==null) return left;
        //return the node
        return root;
    }
   
}