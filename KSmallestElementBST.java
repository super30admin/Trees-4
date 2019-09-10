import java.util.ArrayList;
import java.util.LinkedList;

//idea is to traverse  dfs using recursion inorder traversal, store values in arraylist and return k-1 eleement
public class KSmallestElementBST {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	//DFS INORDER RECURSION
	/*TS: O(N)
	SC:O(N)*/
		  public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
		    if (root == null) return arr;
		    inorder(root.left, arr);
		    arr.add(root.val);
		    inorder(root.right, arr);
		    return arr;
		  }

		  public int kthSmallest(TreeNode root, int k) {
		    ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
		    return nums.get(k - 1);
		  }
		  
		  
		  //iterative solution with sstack
		  //tc(log N+k)
		  //sc log N+k
		  
			  public int kthSmallest2(TreeNode root, int k) {
			    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

			    while (true) {
			      while (root != null) {
			        stack.add(root);
			        root = root.left;
			      }
			      root = stack.removeLast();
			      if (--k == 0) return root.val;
			      root = root.right;
			    }
			  }
			
		  

}
