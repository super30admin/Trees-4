
//LCA means  node in between p and q if p<q then p<LCA<q
	//iteratve tc:o(n) sc o(1)
	//recusive tc:o(n) sc o(n)
public class LCAOfBST {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	//iteratve tc:o(n) sc o(1)
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

	        // Value of p
	        int pVal = p.val;

	        // Value of q;
	        int qVal = q.val;

	        // Start from the root node of the tree
	        TreeNode node = root;

	        // Traverse the tree
	        while (node != null) {

	            // Value of ancestor/parent node.
	            int parentVal = node.val;

	            if (pVal > parentVal && qVal > parentVal) {
	                // If both p and q are greater than parent
	                node = node.right;
	            } else if (pVal < parentVal && qVal < parentVal) {
	                // If both p and q are lesser than parent
	                node = node.left;
	            } else {
	                // We have found the split point, i.e. the LCA node.
	                return node;
	            }
	        }
	        return null;
	    }
	    
	    
	    //recursive
	
	        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

	            // Value of current node or parent node.
	            int parentVal = root.val;

	            // Value of p
	            int pVal = p.val;

	            // Value of q;
	            int qVal = q.val;

	            if (pVal > parentVal && qVal > parentVal) {
	                // If both p and q are greater than parent
	                return lowestCommonAncestor(root.right, p, q);
	            } else if (pVal < parentVal && qVal < parentVal) {
	                // If both p and q are lesser than parent
	                return lowestCommonAncestor(root.left, p, q);
	            } else {
	                // We have found the split point, i.e. the LCA node.
	                return root;
	            }
	        }
	    

}
