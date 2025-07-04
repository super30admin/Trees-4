//Approach 1 : using backtracking , find paths of p and q . return last common before uncommonality
TC : O(n)
SC : O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>pathOfP = new ArrayList<>();
        List<TreeNode>pathOfQ = new ArrayList<>();
        helper(root, p  , pathOfP);
        helper(root , q , pathOfQ);
        int i = 0;
        while (i < pathOfP.size() && i < pathOfQ.size() && pathOfP.get(i) == pathOfQ.get(i)) {
            i++;
        }

        return pathOfP.get(i - 1); //we will return last common element
    }
        
    private void helper(TreeNode root , TreeNode target, List<TreeNode>path){
        //base
        if(root == null){
            return;
        }

        //logic:
        //action
        path.add(root);
        //recurse
        helper(root.left , target, path); //left
        if(path.get(path.size()-1) == target && !path.isEmpty() ){
            return;
        }

        helper(root.right , target , path); //right
        if(path.get(path.size()-1) == target && !path.isEmpty() ){
            return;
        }
        //backtrack
        path.remove(path.size()-1);

    

    }
}

//Approach 2 : Without using paths
//TC :O(n) SC:O(h)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Bottom Up recursion Approach : Without maintaining paths
        //base
        if(root == null || root== p || root == q){
            return root;
        }

        //logic
        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);

        if(left==null && right == null){
            return null;
        }
        else if(left!= null && right == null){
            return left;
        }
        else if(left == null && right != null){
            return right;
        }
        else {
            return root;
        }

        
    }
}