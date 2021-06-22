//Recurive approach
//Time Complexity : O(h). h is the height of the tree(in the worst case is a skewed tree). In case if the tree is a balanced one then the time complexity is O(log n)
//Space Complexity : O(n). Recursive stack space
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        //if p and q values are greater than root then iterate right
        if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        //otherwise left
        else if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        //if not both then return root
        else{
            return root;
        }
        
    }
}
//Iterative approach
//Time Complexity : O(h). h is the height of the tree(in the worst case is a skewed tree). In case if the tree is a balanced one then the time complexity is O(log n)
//Space Complexity : O(1).
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        while(true){
            //if p and q values are greater than root then iterate right
            if(root.val<p.val && root.val<q.val){
                root = root.right;
            }
            //otherwise left
            else if(root.val>p.val && root.val>q.val){
                root = root.left;
            }
            //if not both then return root
            else{
                return root;
            }
        }

    }
}