/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BTLCA {
    List<TreeNode> pPath;
    List<TreeNode> qPath;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path = new ArrayList<>();
        helper(root, p, q, path);
        for(int i=0; i<pPath.size(); i++){
            if(pPath.get(i) != qPath.get(i))
                return pPath.get(i-1);
        } 
        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        if(root == null)
            return;

        path.add(root);
        //BaseCase
        if(root == p)
        {
            pPath = new ArrayList<>(path);
            pPath.add(root);
        }

        if(root == q)
        {
            qPath = new ArrayList<>(path);
            qPath.add(root);
        }
        //Recursive
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);
        //BackTrack
        path.remove(path.size()-1);
    }
}