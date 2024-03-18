
import java.util.ArrayList;
import java.util.List;

public class KthSmallestinBST_usingCounter {
	int count=0;
	int out;
	 public int kthSmallest(TreeNode root, int k) {
		helper(root, k);
		return out;
	}

	private void helper(TreeNode root, int k) {
		// base
		if (root == null)
			return;
		helper(root.left, k);
		count++;
		if(count==k)
			out= root.val;
		helper(root.right, k);

	}
		public static void main(String[] args) {
	        // Input: root = [5,3,6,2,4,null,null,1], k = 3
	        TreeNode root = new TreeNode(5);
	        root.left = new TreeNode(3);
	        root.right = new TreeNode(6);
	        root.left.left = new TreeNode(2);
	        root.left.right = new TreeNode(4);
	        root.left.left.left = new TreeNode(1);
	        
	        KthSmallestinBST_usingCounter solution = new KthSmallestinBST_usingCounter();
	        int k = 3;
	        int result = solution.kthSmallest(root, k);
	        System.out.println("Output: " + result);
	}
}
