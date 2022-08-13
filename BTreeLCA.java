/*
The following code uses a bottom up approach to solving the problem. At each node, it traverses the left and right children
to check whether they contain the values of the given nodes. On the basis of this, it will return to the previous
node in the recursive stack, which will then propogate the return to the root of the true for the answer. 

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root == p || root == q)
            return root;
            
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //Nodes not found on either side
        if(left == null && right == null)
            return null;
        //Only one of the nodes found at the right side
        else if(left == null && right != null)
            return right;
        //Only one of the nodes found at the left side
        else if(left != null && right == null)
            return left;
        //When both the nodes are found on both the sides, the current node will be returned as the LCA
         else
             return root;
        
    }
}