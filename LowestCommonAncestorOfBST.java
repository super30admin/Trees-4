package trees4;

public class LowestCommonAncestorOfBST {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
		// TC : O(n)
		// SC : O(1)
		
		// ITERATIVE APPROACH
        TreeNode parentRoot = root;
        int pVal = p.val;
        int qVal = q.val;
        
        while(parentRoot != null) {
            
            int parentVal = parentRoot.val;
            
            if(pVal > parentVal && qVal > parentVal)
                parentRoot = parentRoot.right;
            
            else if(pVal < parentVal && qVal < parentVal)
                parentRoot = parentRoot.left;
            
            else
                return parentRoot;
        }
        
        return null;
        
        // TC : O(n)
        // SC : O(n) - space utilized by recursive stack
        
        // RECURSIVE APPROACH
        /*
        int parentRoot = root.val;
        int pVal = p.val;
        int qVal = q.val;
        
        if(pVal > root.val && qVal > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else if(pVal < parentRoot && qVal < parentRoot) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else return root;
        */
    }
}
