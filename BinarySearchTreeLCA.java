// Time Complexity : O(N) for Iterative and Recursive
// Space Complexity :  O(1) for Iterative and Recursive
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Yes


// Your code here along with comments explaining your approach

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null)
        return null;
        
        int rootVal = root.val;
        int leftChild = p.val;
        int rightChild = q.val;
        
        if(rightChild > rootVal && leftChild > rootVal){
            return lowestCommonAncestor(root.right,p,q);
        }
        else if(rightChild < rootVal && leftChild < rootVal){
            return lowestCommonAncestor(root.left,p,q);    
        }
        else{
            return root;
        }
        
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }
}