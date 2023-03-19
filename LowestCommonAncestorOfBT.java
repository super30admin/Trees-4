// top down recursion
public class LowestCommonAncestorOfBT {
    List<TreeNode> pathp;
    List<TreeNode> pathq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // null case
        if(root==null) return null;
        helper(root,p,q,new ArrayList<>());
        for(int i=0;i<pathp.size();i++){
            if(pathp.get(i)!=pathq.get(i)){
                return pathp.get(i-1);
            }
        }
        return null;
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        // base case
        if(root==null) return;

        path.add(root); // action
        if(root==p){
            pathp = new ArrayList<>(path);
            pathp.add(root);
        }
        if(root==q){
            pathq = new ArrayList<>(path);
            pathq.add(root);
        }

        // recurse
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);

        // backtrack
        path.remove(path.size()-1);
    }
}

// TC - O(n)
// SC - O(h)


// bottom up recursion
public class LowestCommonAncestorOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left==null && right==null) return null;
        else if(left!=null && right==null) return left;
        else if(left==null && right!=null) return right;
        else return root;
    }
}

// TC - O(n)
// SC - O(h)