//time O(n)
//space O(n)

class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        inorder(root, p, q, new ArrayList<>());
        pathP.add(pathP.get(pathP.size()-1));
        pathQ.add(pathQ.get(pathQ.size()-1));
        for(int i = 0; i < pathP.size(); i++) {
            if(pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i-1);
            }
        }
        return null;
    }
    
    private void inorder(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        //base
        if(root == null) return;
        
        path.add(root);
        //logic
        inorder(root.left, p, q, path);
        inorder(root.right, p, q, path);
        if(root.val == p.val) {
            pathP = new ArrayList<>(path);
        }
        if(root.val == q.val) {
            pathQ = new ArrayList<>(path);
        }
        path.remove(path.size()-1);
    }
}
