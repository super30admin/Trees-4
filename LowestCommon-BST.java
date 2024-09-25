/*Time Complexity : O(N/2);
Space Complexity : O(1) // recursive stack space.
Did it run on LeetCode : Yes
Any Problems : No
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p ,q); 
        
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p ,q);
                
                else
                return root;
        
        
    }
}