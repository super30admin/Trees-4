//TC : O(N) N is the no of elements in tree.
//SC : O(1) , we are not using any stack here , so O(1). it will be O(N) , if we use recursive approach.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val> Math.max(p.val,q.val))
            { 
                root = root.left;  // if p and q are in left sub tree, then we move to left.
            }else if(root.val < Math.min(p.val,q.val)){
                root = root.right; // p and q are in right sub tree , the we move to right.
            }else{
                return root;  // if we not found both left and right, then we found the common                                 // ancenstor
            }
        }
        return root;
    }
}
