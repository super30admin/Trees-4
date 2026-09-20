o(n) time complexity
  o(n) space complexity

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode>  pathP;
    List<TreeNode>  pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pathP = new ArrayList<>();
          pathQ = new ArrayList<>();

        helper(root, p , q, new ArrayList<>());

        TreeNode result = null; 

        for(int i = 0 ; i < Math.min(pathP.size() , pathQ.size()); i++){
            if(pathP.get(i).val == pathQ.get(i).val){
                result = pathP.get(i);
            } else {
                break;
            }

        }
        return result;
       
      

        
    }

    private void helper(TreeNode root, TreeNode p , TreeNode q, List<TreeNode> path) {
        if(root == null){
             return;
        }
        path.add(root);

        helper(root.left, p  ,q, path);

        if(root == p ){
            pathP.addAll(path);
            pathP.add(root);

        }
        
        if(root == q ){
        
            pathQ.addAll(path);
            pathQ.add(root);
        }

        helper(root.right, p, q, path);
         path.remove(path.size() - 1);


    }
}
