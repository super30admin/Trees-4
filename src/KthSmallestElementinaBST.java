import java.util.Stack;

/*
 * The complexity of the algorithm is O(n) where n is no of elements.
 * Space complexity is O(k) where k is height of tree.
 */

public class KthSmallestElementinaBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	// Iterative approach

	public int kthSmallest(TreeNode root, int k) {

		int count = 0;
		int result = 0;
		Stack<TreeNode> st = new Stack<>();
		// st.push(root);

		while (!st.isEmpty() || root != null) {

			while (root != null) {
				st.push(root);
				root = root.left;

			}

			root = st.pop();

			count++;
			if (count == k) {
				result = root.val;
				break;
			}

			root = root.right;

		}

		return result;
	}

	// recursive

//  int result=0;
//  int count;
//  public int kthSmallest(TreeNode root, int k) {

//      inorder(root,k);
//      return result;
//  }

//  private void inorder(TreeNode root, int k){
//      // base
//      if(root==null)
//          return ;

//      //logic

//      inorder(root.left,k);
//      count++;
//      if(count == k){
//          result= root.val;
//          return;
//      }

//         if(result == 0)
//    			inorder(root.right,k);

//  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
