
public class LCABST {
	
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	//TC - o(n)
	//SC-o(1)
	class Solution {
	    //lowest common Ancestor will be the root they both split
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        
	        int pVal = p.val;
	        int qVal = q.val;
	        
	        while(root != null) {
	            //check both values are greater thn the root val 
	            //if yes go to right side of tree
	            if(root.val < p.val && root.val < q.val) {
	                root = root.right;
	            }
	            //if both values less thn the root val
	            //go to left side of the root
	            else if(root.val > p.val && root.val > q.val){
	                root = root.left;
	            } 
	            //else they both are splitting 
	            //return the root
	            else {
	                return root;
	            }
	        }
	        return null;
	    }
	}

}
