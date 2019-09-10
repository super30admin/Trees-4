/*tc:o(n)
sc recursive stack space o(n)
recursive apporach

find  p and q in tree when we found return true . for a node if left and right become true then LCA found
or node is p or q and return true from left or right then LCA found
*/

public class LCAOfBinaryTree {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	    private TreeNode ans;

	    public LCAOfBinaryTree() {
	        // Variable to store LCA node.
	        this.ans = null;
	    }

	    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

	        // If reached the end of a branch, return false.
	        if (currentNode == null) {
	            return false;
	        }

	        // Left Recursion. If left recursion returns true, set left = 1 else 0
	        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

	        // Right Recursion
	        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

	        // If the current node is one of p or q
	        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


	        // If any two of the flags left, right or mid become True
	        if (mid + left + right >= 2) {
	            this.ans = currentNode;
	        }

	        // Return true if any one of the three bool values is True.
	        return (mid + left + right > 0);
	    }

	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        // Traverse the tree
	        this.recurseTree(root, p, q);
	        return this.ans;
	    }
	

}
