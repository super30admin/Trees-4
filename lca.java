//TC : Overall O(n), since DFS may visit every node and path comparison adds only O(h).
//SC : Overall O(h) for recursion + two paths (worst-case O(n) if tree is skewed).

//Do a DFS from root, carrying a path; when you hit p or q, snapshot that path into pathP/pathQ.
//After both paths are found, scan from the start until indices diverge.
//Return the last equal node before divergence.

class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        helper(root, p, q, new ArrayList<>());
        
        for(int i=0; i<pathP.size(); i++){
            if(pathP.get(i) != pathQ.get(i)){
                return pathP.get(i-1);
            }
        }

        return null;
    }


    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){

        if(root == null) return;

        
        path.add(root);

        if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }

        if(root == q){
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }

        if(pathP == null || pathQ == null)
            helper(root.left, p, q, path);

        if(pathP == null || pathQ == null)
            helper(root.right, p, q, path);

        path.remove(path.size()-1);
    }
}