package trees4;


public class KthSmallestElementInBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	// RECURSIVE APPROACH
	int count = 0, result = Integer.MIN_VALUE;
	
	public int kthSmallest(TreeNode root, int k) {
        
        helper(root, k);
        return result;
    }
    
    void helper(TreeNode root, int k) {
        if (root == null) return ;
        
        helper(root.left, k);
        count++;
        
        if(count == k) result = root.val;
        
        helper(root.right, k);
    }
    
    // ITERATIVE APPROACH
    /*
    public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
     TreeNode p = root;
     int count = 0;
     
     while(!stack.isEmpty() || p != null) {
         if(p != null) {
             stack.push(p);  // Just like recursion
             p = p.left;   
             
         } else {
            TreeNode node = stack.pop();
            if(++count == k) return node.val; 
            p = node.right;
         }
     }
     
     return Integer.MIN_VALUE;
    }
    */
	
}
