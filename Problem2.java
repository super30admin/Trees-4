// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//Time complexity : O(N)
//Space complexity : O(H)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            int val = root.val;
            if(val < p.val && val < q.val){
                root = root.right;
            }else if(val > p.val && val > q.val){
                root = root.left;
            }else{
                return root;
            }
        }
        return root;
    }
}