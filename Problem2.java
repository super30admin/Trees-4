// Time Complexity : (mentioned abve each function)
// Space Complexity : (mentioned abve each function)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    int s =0 , l =0;
    TreeNode lca = null;
    boolean isAncestorFound = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       // traverseRecursive(root,p,q); // Recursive Solution
       iterative(root,p,q);
        return lca;
    }
    /*
    Time : If BST is balanced then O(logn) , otherwise O(h) where h is the height of the tree and in worst case it could be n
    Space : O(1)  , as no stack is used
    */
    private void iterative(TreeNode root, TreeNode p, TreeNode q){

// Since we are traversing a binary search tree in Preorder because we are looking at the current value first before recusing, we need to move left or right based on biary search properties
        // We will only move left , if both values lies in the left tree, i.e if both values are smaller than the current value
        // We will only move right, if both values lies in the right tree, i.e if both values are greater than current values
        // If we cannot move in either of the direction , then this must be the LCA , because
        // A: Either one value is in its left tree and other is on right tree
        // B: Or , this is the descendant of iteself and one of the values is in left or right subtree

        while(lca == null){
            boolean canMoveLeft = (p.val < root.val && q.val < root.val) ? true : false;
            boolean canMoveRight = (p.val > root.val && q.val > root.val) ? true : false;
            if(canMoveLeft){
                // This means LCA may lie on the left of the tree
                root= root.left;
            }else if(canMoveRight){
                // This means LCA may lie on the right of the tree
                root = root.right;
            }
            else{ // if neither is true, then this node is the LCA , as it may be a descendent of iteself, other may lie on either side or p and q lie on the left and right of the bst tree
            lca = root;
            return;
            }
        }
    }

    /*
    Time : If BST is balanced then O(logn) , otherwise O(h) where h is the height of the tree and in worst case it could be n
    Space : O(h) , where h can be n in the worst case
    */

    private boolean traverseRecursive(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){ // base case to stop recursion further
            return false;
        }

        // Since we are traversing a binary search tree in Preorder because we are looking at the current value first before recusing, we need to move left or right based on biary search properties
        // We will only move left , if both values lies in the left tree, i.e if both values are smaller than the current value
        // We will only move right, if both values lies in the right tree, i.e if both values are greater than current values
        // If we cannot move in either of the direction , then this must be the LCA , because
        // A: Either one value is in its left tree and other is on right tree
        // B: Or , this is the descendant of iteself and one of the values is in left or right subtree

        boolean canMoveLeft = (p.val < node.val && q.val < node.val) ? true: false;
        boolean canMoveRight = (p.val > node.val && q.val > node.val) ? true: false;

        if(canMoveLeft){
            traverseRecursive(node.left, p,q);
        }
        if(canMoveRight){
            traverseRecursive(node.right, p,q);
        }

        if((!canMoveLeft && !canMoveRight ) || (canMoveLeft || canMoveRight)){
            if(!isAncestorFound){ // Check if the ancestor is already not found, because the case which is true for child can be true for Parent as well. So if the child has found the lca then we dont want replace for the parent
            lca = node;
            isAncestorFound = true;
            }
        }
        return canMoveLeft || canMoveRight; // this return value is useless anyways


    }
