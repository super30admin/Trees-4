/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* Iterative approach
Time: O(logn) the search space is divided into half at each iteration
Space: O(1)
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while(root!=null){

            if(p.val<root.val && q.val<root.val){
                root=root.left;
            }
            else if(p.val>root.val && q.val>root.val){
            }
            else return root;

        }
        return null;

    }
}