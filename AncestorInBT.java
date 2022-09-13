//TC : O(log(n))
//SC : O(1)
/*class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        helper(root,p,q,new ArrayList<>());
        for(int i=0;i<pathP.size();i++){
            if(pathP.get(i) != pathQ.get(i))
                return pathP.get(i-1);
        }
        return null;
    }
    
    private void helper(TreeNode root, TreeNode p, TreeNode q,List<TreeNode> path){
        if(root == null) return;
        path.add(root);
        //base
        if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root == q){
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        //logic
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);
        path.remove(path.size()-1);
    }
}*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root== q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left == null && right == null) return null;
        else if(left == null && right != null) return right;
        else if(left != null && right == null) return left;
        else return root;
    }
}
