//Time Complexity : O(n)
//Space Complexity : O(n)
public class KthSmallestElement_BST {	
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
	
	/**Approach#1: Recursive**/
	int count;
	int result;
	public int kthSmallest(TreeNode root, int k) {
        count=k;
		inorder(root);
		return result;
    }
	private void inorder(TreeNode root) {
		//base
		if(root==null) return;
		//logic
		inorder(root.left);
		count--;
		if(count ==0) {
			result= root.val;
			return;
		}
		inorder(root.right);
	}
		
	/**Approach#2: Iterative| Time O(n) | Space O(n)**/
	/*public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st= new Stack<>();
        while(true){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root= st.pop();
            k--;
            if(k==0) return root.val;
            root= root.right;
        }
    }*/

	public static void main (String[] args) {
		KthSmallestElement_BST ob= new KthSmallestElement_BST();
		TreeNode t1= new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
		int k=5;
		
		System.out.println(k+"th smallest element in BST is: "+ob.kthSmallest(t1, k));	
		
	}
}
