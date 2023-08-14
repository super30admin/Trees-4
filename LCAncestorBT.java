// Time complexity: O(n)
// Space complexity: O(h)

class Solution {
    
    List<TreeNode>pathp;
    List<TreeNode>pathq;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;
        
        helper(root, p,q, new ArrayList<>());
        
        for(int i=0;i<pathp.size();i++){
            if(pathp.get(i)!=pathq.get(i))
                return pathp.get(i-1);
        }
        return null;
    }
    
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if (root==null) return ;
        if(root==p){
            pathp= new ArrayList(path);
            pathp.add(root);
            pathp.add(root);
        }
        if(root==q){
            pathq= new ArrayList(path);
            pathq.add(root);
            pathq.add(root);
        }
        
        //logic
        //action
        path.add(root);
        //recurse
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);
        //backtrack
        path.remove(path.size()-1);
    }
}
