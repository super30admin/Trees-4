// USING : BACKTRACKING
// TC : O(n)
// SC : O(h)
class Solution {
    List<TreeNode> pathp;
    List<TreeNode> pathq;
    boolean flagp = false;
    boolean flagq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        helper(root, p ,q, new ArrayList<>());
        for(int i=0; i<pathp.size(); i++){
            if(pathp.get(i) != pathq.get(i)){
                return pathp.get(i-1);
            }
        }
        return null;
        
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root == null) return;
        // logic
        // action
        path.add(root);
        if(root == p){
            flagp = true;
            pathp = new ArrayList<>(path);
            pathp.add(root);
            
        }
        if(root == q){
            flagq = true;
            pathq = new ArrayList<>(path);
            pathq.add(root);
            
        }

        
        // recurse
        if ( !flagp || !flagq )
            helper(root.left, p, q, path);
        if ( !flagp || !flagq )
            helper(root.right, p, q, path);
        // backtrack
        path.remove(path.size()-1);
    }
}



// USING : bottom up approach
// TC : O(n)
// SC : O(h)

class Solution {
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);

        if(left == null && right == null) return null;
        else if(left != null && right == null) return left;
        else if(left== null && right != null) return right;
        else return root; 
    }
}
