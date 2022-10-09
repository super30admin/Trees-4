//Problem2 - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

public class problem2 {
    List<TreeNode> pathp;
    List<TreeNode> pathq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        helper(root, p,q,new ArrayList<>());
        
        for(int i=0;i<pathp.size();i++){
            if(pathp.get(i) != pathq.get(i)){
                return pathp.get(i - 1);
            }
        }
        return null;
    }
    
    private void helper(TreeNode root,TreeNode p,TreeNode q, List<TreeNode> path){
        if(root == null) return;
        if(root==p){
            pathp = new ArrayList<>(path);
            pathp.add(root);
            pathp.add(root);
        }
        if(root==q){
            pathq = new ArrayList<>(path);
            pathq.add(root);
            pathq.add(root);
        }
        
        path.add(root);
        
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);
        
        path.remove(path.size()-1);
    }
}
