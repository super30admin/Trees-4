// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// position of the last common ancestor would be where p and q would be on the left and right side
// one would be less and one would be greater
// till then if both p and q are less move to node.left, else if p and q are greater move to node.right

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        
        while(node!=null){
            if(node.val < p.val && node.val < q.val){
                node = node.right;
            }
            else if(node.val > p.val && node.val > q.val){
                node = node.left;
            }
            else{
                break;
            }
        }
        return node;
    }
}