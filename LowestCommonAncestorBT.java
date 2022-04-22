//Time Complexity : O(n)
//Space Complexity : O(H); were H is height of the tree
public class LowestCommonAncestorBT {	
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
	
	/**Approach: Bottom Up Recursion**/
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if(root == null || root.val == p.val || root.val == q.val) return root;
            
        //logic
        TreeNode left= lowestCommonAncestor(root.left, p, q);
        TreeNode right= lowestCommonAncestor(root.right, p, q);     
        if(left != null && right != null){
            return root;
        } else if (left != null && right == null){
            return left;
        } else if (left == null && right != null){
            return right;
        }        
        
        return null;               
    }

	public static void main (String[] args) {
		LowestCommonAncestorBT ob= new LowestCommonAncestorBT();
		TreeNode t1= new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
		TreeNode p= new TreeNode(2);
		TreeNode q= new TreeNode(4);
		
		System.out.println("LCA of node "+p.val+" and "+q.val+" is: "+ob.lowestCommonAncestor(t1, p, q).val);	
		
	}
}
