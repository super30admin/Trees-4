class Problem236 {
//TC=O(n)
//SC=O(3h) two list for p and q node and h in recursion stack
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        this.pathP=new ArrayList<>();
        this.pathQ=new ArrayList<>();
        backtrack(root,p,q,new ArrayList<>());
        for(int i=0;i<pathP.size();i++){
            if(pathP.get(i)!=pathQ.get(i))
                return pathP.get(i-1);
        }
        return null;
    }
    
    private void backtrack(TreeNode root, TreeNode p, TreeNode q, ArrayList<TreeNode> path){
        //base condition
        if(root==null)
            return;
        path.add(root);
        if(root==p){
            pathP=new ArrayList<>(path);
            pathP.add(root);
        }
        if(root==q){
            pathQ=new ArrayList<>(path);
            pathQ.add(root);
        }
        //recursion
        if(pathP.size()==0 || pathQ.size()==0){
            backtrack(root.left,p,q,path);
        }
        if(pathP.size()==0 || pathQ.size()==0){
            backtrack(root.right,p,q,path);
        }  
        //backtrack
        path.remove(path.size()-1);
    }
//TC=O(n)
//SC=O(h) ..recursion stack
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        
        if(left==null && right==null)
            return null;
        else if(left!=null && right==null)
            return left;
        else if(left==null && right!=null)
            return right;
        else
            return root;
    }
}
