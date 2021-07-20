/*Bottom up recursion  o(n)
 * */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == p || root == q || root == null) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);
        if (left != null && right != null) {
            return root;
        } 
        if (left != null) return left;
        if (right != null) return right;
        
        if (left == null && right == null) return null;
     return null;   
    }
}




/*path - bactrack in inorder
 * */
class Solution {
    TreeNode result =  new TreeNode();
    List<TreeNode> path1 ;
      List<TreeNode> path2 ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        backtrack(root, p, q, new ArrayList<>());
        for(int i = 0 ; i < path1.size(); i++){
            if (path1.get(i) != path2.get(i)){
                return path1.get(i-1);
            }
        }
        
        
        //return result;
        return null;
        
    }
    public void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        
        
        // base
        if (root == null) return ;
        
        if (root == p){
            // add the node twice to the path1 and
            path1 = new ArrayList(path);
            path1.add(p);
            path1.add(p);
            
            
        }
         if (root == q){
            // add the node twice to the path1 and
            path2 = new ArrayList(path);
            path2.add(q);
            path2.add(q);
            
            
        }
        // action 
        path.add(root);
        
        
        
        backtrack(root.left, p,q,path);
         backtrack(root.right, p,q,path);
        
        path.remove(path.size()-1);
        
    }
}
