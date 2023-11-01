//TC = O(n)
//SC = O(h)
//Here we are forming two list which are the path of p and q and
//then compare the node of till we find the common element.

class Solution{
    List<TreeNode> pathq;
    List<TreeNode> pathp;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        helper(root, p, q, new ArrayList<>());
        for(int i=0; i<pathp.size(); i++){
            if(pathp.get(i)!=pathq.get(i)){
                return pathp.get(i-1);
            }
        }
        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
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

        //logic
        //action
        path.add(root);
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);

        path.remove(path.size()-1);
        //backtrack

    }
}