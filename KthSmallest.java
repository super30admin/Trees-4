/*
 * tc - o(n)
 * sc - o(h)
 */

public class KthSmallest{
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }

    // int count;
    // int result;
    // public int kthSmallest(TreeNode root, int k) {
    //     this.count = 0;
    //     helper(root, k);
    //     return result;
    // }

    // public void helper(TreeNode root,int k){
    //     //base 
    //     if(root == null){
    //         return;
    //     }

    //     //helper
    //     helper(root.left,k);
    //     count++;
    //     if(k == count){
    //         this.result = root.val;
    //         return;
    //     }

    //     helper(root.right,k);
    // }
}