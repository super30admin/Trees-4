//Time Complexity : O(n)
//Space Complexity : O(1)
public class LowestCommonAncestorBST {	
	/**Definition for binary tree node.**/
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
		
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		/**Approach#2: Iterative**/		
		while(true){
            if (root.val > p.val && root.val > q.val) root= root.left;
            else if (root.val < p.val && root.val < q.val) root= root.right; 
            else return root;
	    } 
        
		/**Approach#1: Recursive | Time O(n) | Space O(n)**/
        /*if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        } else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return root;
        }*/
    }

	// Driver code to test above
	public static void main (String[] args) {
		LowestCommonAncestorBST ob= new LowestCommonAncestorBST();
		TreeNode t1= new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
		TreeNode p= new TreeNode(2);
		TreeNode q= new TreeNode(8);		
		
		System.out.println("LCA of node "+p.val+" and "+q.val+" is: "+ob.lowestCommonAncestor(t1, p, q).val);	
		
	}
}
