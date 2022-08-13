/*
The following approach finds the lowest common ancestor using the base condition that, if both the nodes lie on either side
of the current node, then the current node is the LCA, and if both of them lie on the same side, then we traverse to that 
side till we find the base condition.

Did this code run on leetcode: Yes
*/

class Solution {
    //Time Complexity: O(h)
    //Space Complexity: O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        

        while(true)
        {
            if(p.val < root.val && q.val < root.val) 
                root = root.left;
            
            else if(p.val > root.val && q.val > root.val) 
                root = root.right;
            //This condition also handles the condition where if one of the nodes is the current root node,
            //and the other node is its child, then the LCA will be the current root node.
            else
                return root;
        }
    }
}