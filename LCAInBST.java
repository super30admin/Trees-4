// Time O(LogN) where N is no of nodes
// Space O(h) h is the height of the tree

public class LCAInBST {
	 TreeNode result;
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	      
	    if(p.val <q.val)    
	     helper(root,p,q);
	    else
	     helper(root,q,p);   
	        
	        return result;
	        
	    }
	    public void helper(TreeNode root, TreeNode p, TreeNode q){
	        if(root==null)
	            return;
	        
	        if(p==root || q==root){
	            result= root;
	            return; 
	        }
	           
	            
	        if(p.val < root.val && q.val > root.val){
	           result= root;
	            return;
	       }
	        if(p.val <root.val && q.val <root.val)
	            helper(root.left, p,q);
	        else 
	            helper(root.right,p,q);
	        
	    }
}
