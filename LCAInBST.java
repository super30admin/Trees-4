package Trees4;

public class LCAInBST {

	//TC : o(h)
	//SC : o(1) if iterative solution
	//Approach : If nodes are smaller than left move left or right. If one lie on left and other on right side of tree then root is LCA since it's a BST

	class Solution {
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        while(true){
	        if(root.val > p.val && root.val > q.val) root = root.left;
	        else if(root.val < p.val && root.val < q.val) root = root.right;
	        else return root;            
	        }
	    }
	}
}
