// Time Complexity : O(n)
// Space Complexity :O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      
        while(true){
        
            if(p.val>root.val && q.val>root.val){
                return lowestCommonAncestor(root.right,p,q);
            }
            else if(p.val<root.val && q.val<root.val){
                return lowestCommonAncestor(root.left,p,q);
            }else{
                return root;
            }
        }
    }
}