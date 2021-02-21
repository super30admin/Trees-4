//TC - o(n)
//SC - o(h)
public class LCABinaryTree {
	
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }
        
        //return root when find p or q
        if(root == p || root == q){
            return root;
        }
        
        //call left sub tree and right subtree to find p and q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //if left and right both are not null
        //return root
        if(left != null && right != null){
            return root;
        }
        //else return whichever is not null
        //this is possible bcs in question they have mentioned p and q exist in the tree
        return left != null ? left : right;
    }

}
