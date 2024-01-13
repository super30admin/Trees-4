import java.util.Stack;

public class KthSmallestElementInBST {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {//We can take inorder traversal it will give sorted list as it is a BST
//        TC:O(n)
//        SC:O(h)
        this.count = k;
        this.result = k;
        helper(root, k);
        return result;
    }
    private void helper(TreeNode root, int k){
        if(root  == null)
            return;
        helper(root.left, k);
        count--;
        if(count == 0)
            result = root.val;
        helper(root.right, k);
    }
    public int kthSmallest2(TreeNode root, int k) {
        // Iterative approach using own stack
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k==0) return root.val;
            root = root.right;
        }
        return 0;
    }
}
