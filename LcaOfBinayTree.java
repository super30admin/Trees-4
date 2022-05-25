//backtracking method
class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        backtracking(root, p, q, new ArrayList<>());
        
        for(int i = 0; i < pathP.size(); i++) {
            if(pathP.get(i) != pathQ.get(i)) { // since we know there exists a duplciate entry at the end we traverse till we find the node of mismatch
                return pathP.get(i - 1); //then return the node just before taht mismatch which is actually the lowest common ancestor
            }
        }
        return null;
    }
    
    private void backtracking(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        //base
        if(root == null) {
            return;
        }
        //logic
        //action
        path.add(root);
        if(root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(root); // note that we are addingone more duplicate node entry here 
        }
        if(root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(root); // here as well 
        }
        //recurse
        backtracking(root.left, p, q, path);
        backtracking(root.right, p, q, path);
        //backtracking
        path.remove(path.size() - 1);
    }
}