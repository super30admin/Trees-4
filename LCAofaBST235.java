//time complexity : O(logN)
//space complexity : O(K)
//leet code : yes
//steps : simple inroder.
class LCAofaBST235 {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(p.val < root.val && q.val <root.val){
                root =root.left;
            } else if(p.val >root.val && q.val > root.val){
                root = root.right;
            } else {
            return root;}
        }
        return null;
        
        
        /**
        if(root==null) return root;
        
        //if p,q < root
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left,p,q);
        
        
        //if p,q > root
       else if(p.val > root.val && q.val > root.val)
           return lowestCommonAncestor(root.right,p,q);
        
        //otherwise
      
        
       return root; 
        
        */

    }
}