// Time Complexity :o(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: we keep checking if the given elements are less or greater than root if if its less then check on the right half else check on the lfet half


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        } else return root;
        
    }
}