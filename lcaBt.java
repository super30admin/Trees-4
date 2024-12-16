/*
 * tc - o(n)
 * sc - o(h)
 */

public class lcaBt {
  // no extra space 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    public TreeNode helper(TreeNode node, TreeNode p, TreeNode q){
        if(node == null || node.val == p.val ||  node.val == q.val){
            return node;
        }
        TreeNode left = helper(node.left, p, q);
        TreeNode right = helper(node.right, p, q);
        if(left != null && right != null){
            return node;
        }else if(right != null){
            return right;
        }else{
            return left;
        }

    }

    //Extra space there
    // List<TreeNode> pList = new ArrayList<>();
    // List<TreeNode> qList = new ArrayList<>();
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     helper(root, p, q, new ArrayList<>());
    //     for(int i = 0; i < pList.size(); i++){
    //         if(pList.get(i) != qList.get(i)){
    //             return pList.get(i-1);
    //         }
    //     }
    //     return null;
    // }

    // public void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
    //     //base 
    //     if(root == null) return;
    //     if(pList.size() > 0 && qList.size() > 0) return; //early stop- if we have both of them found, then we dont need to continue the rest of the traversal 

    //     //logic 
    //     path.add(root);
    //     if(p == root){
    //         pList = new ArrayList<>(path);
    //         pList.add(root); //adding one additional time to handle if both the lenghts are different 
    //     }
    //     if(q == root){
    //         qList = new ArrayList<>(path);
    //         qList.add(root);//adding one additional time to handle if both the lenghts are different 
    //     }
    //     helper(root.left, p,q,path);
    //     helper(root.right, p, q, path);
    //     path.removeLast();
        
    // }  
}
