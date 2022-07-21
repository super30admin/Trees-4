// Time COmplexity: O(n)
// Space Complexity: O(n)
public class LCAinBinaryTree {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        helper(root, p, q, new ArrayList<>());
        for(int i=0; i<pathP.size();i++){
            if(pathP.get(i) != pathQ.get(i)){
                return pathP.get(i-1);
            }
        }
        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root == null) return;
        //action
        path.add(root);
        if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }
        if(root == q){
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }
        //logic


        //action
        helper(root.left, p , q, path);
        helper(root.right, p , q, path);
        //backtrack
        path.remove(path.size() - 1);
    }
}
