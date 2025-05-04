/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // Recursive

 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if(p.val < root.val && q.val < root.val){
             root = root.left;
             return lowestCommonAncestor(root, p, q);
        }

        else if(p.val > root.val && q.val > root.val){
            root = root.right;
            return lowestCommonAncestor(root, p, q);
        }

        else return root;
    }
}

//Iterative

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
        if(root == null)
            return null;
        while(true)
        {
            if(p.val < root.val && q.val < root.val){
                 root = root.left;
            }

            else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
        
            else return root;
        }
    }
}

/**
 * Time and Space Complexity
 *  O(h)[Worst case] Atlmost we will iterate the height of the tree in worst case scenario.
 * O(1) No extra spaced added.
 */