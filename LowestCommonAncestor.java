
// TC: O(n) traversing all the nodes to get to p and q
// SC: O(n) recurssive stack
// works on leetcode
public class LowestCommonAncestor {
    private List<TreeNode> pathP;
    private List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null) return null;
        //important piece here, we want a new copy of the array list
        backtrack(root, p, q, new ArrayList<>());
        for(int i=0; i<pathP.size(); i++){
            if(pathP.get(i) != pathQ.get(i)){
                return pathP.get(i-1);
            }
        }
        return null;
    }

    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path )
    {
        //base
        if(root == null) return;

        //action
        path.add(root);
        //logic
        if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }

        if(root == q)
        {
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }

        //recurse
        if(pathP == null || pathQ == null)
        {
            backtrack(root.left, p, q, path);
            backtrack(root.right, p, q, path);
        }
        //backtrack
        path.remove(path.size()-1);

}
