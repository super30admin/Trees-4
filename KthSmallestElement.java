// Time COmplexity: O(n)
// Space Complexity: O(n)
public class KthSmallestElement {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k);
    }

    public int inorder(TreeNode root, int k){
        //base
        if(root == null) return 0;
        //logic
        inorder(root.left, k);
        count++;
        if(count == k){
            result = root.val;
        }
        inorder(root.right, k);
        return result;
    }
}
