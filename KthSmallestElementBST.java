import LCABinaryTree.TreeNode;
import java.util.*;

//TC - (o(n+k))
//SC - o(h) h- hight of the tree
public class KthSmallestElementBST {
	
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	  public int kthSmallest(TreeNode root, int k) {
	        
	        if(root == null)
	            return -1;
	        
	        Stack<TreeNode> st = new Stack<>();
	        
	        //do inorder traversal and stop once you get the kth element
	        while(root != null || !st.isEmpty()) {
	            while (root != null){
	                st.push(root);
	                root = root.left;
	            }
	            root = st.pop();
	            k--;
	            //traverse till k is zero
	            if(k == 0)
	                return root.val;
	            
	            root = root.right;
	        }
	        return -1;
	    }
}
