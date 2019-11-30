import java.util.Stack;

public class kthSmallestInBST {

	//	Time:  O(k) heihht of tree 
	//	Space O(k) stack
	//	LeetCode: yes

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	class Solution {
		public int kthSmallest(TreeNode root, int k) {
			Stack<TreeNode> stack = new Stack<TreeNode>();

			while(true){
				while(root != null){
					stack.add(root);
					root = root.left;
				}
				root = stack.pop();
				k--;
				if(k == 0){
					return root.val;
				}
				root = root.right;    
			}
		}
	}

}
