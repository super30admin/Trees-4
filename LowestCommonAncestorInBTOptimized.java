/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// optimised approach
// Time Complexity : O(H)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nope


// Your code here along with comments explaining your approach


/*Approach
1) we traverse the tree and store it in left and right subtrees
2) once we reach left==null then we return right
3) Once we reach right==null we return left
4) if none of the cases exist we return the root element, which indicates we have not found the subtree and thus returns the root as in base case it may have been equal to p or q
5) to exit from every recursive call we use the base case and check if we have reached a null node or if root equals p or q
*/

class LowestCommonAncestorInBTOptimized {

    public class TreeNode {
            int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
       if(root==null || root ==p || root==q)
       {
           return root;
       }
        
       TreeNode left = lowestCommonAncestor(root.left,p,q);
       TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left==null)
        {
            return right;
        }
        
        if(right==null)
        {
            return left;
        }
        
        return root;
    }
    
}