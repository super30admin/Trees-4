//TC: O(h) & O(log n) if complete Binary Tree is given
//SC: O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,  p,  q);
        else if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right,  p,  q);
        else return root;
        
    }
}

//TC: O(h) & O(log n) if complete Binary Tree is given
//SC: O(1)
//iterative
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
             if(root.val > p.val && root.val > q.val) root = root.left;
            else if(root.val < p.val && root.val < q.val) root= root.right;
             else return root;
            
        }
       
        
    }
}
