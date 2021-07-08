// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: If the node p and q are lesser than the root, traverse the left subtree, if the node
p and q are greater than the root, traverse the right subtree, and if either of them belong to opposite side of the root, return the root.
*/
// RECURSIVE
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){return root;}                                    // If p and q either is found
        if((p.val < root.val && q.val > root.val)
            || (p.val > root.val && q.val < root.val)){return root;}                                // If either node is in opposite sides of each otherr, return the root
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);                                             // Traverse left subtree iff both the nodes are having lesser values than root
        }
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);                                            // Traverse right subtree iff both the nodes are having greater values than root
        }
        return null;
    }
}

// ITERATIVE
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){return root;}                                        // If p and q either is found
        while(root != null){
            if((p.val <= root.val && q.val >= root.val)||(p.val >= root.val && q.val <= root.val))          // If either of the nodes is root or is in either opposite sides of each other return the root
            { return root;}
            else
            if(p.val < root.val && q.val < root.val){                                                   // If both the nodes are in left side, traverse left subtree
                root = root.left;
            } 
            else
            if(p.val > root.val && q.val > root.val){                                           // If both the nodes are in right side, traverse right subtree
                root = root.right;
            }
        }
        return null;
        }
}