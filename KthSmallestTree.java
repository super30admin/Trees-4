import java.util.Stack;
// Time Complexity : O(H) for Iterative and Recursive
// Space Complexity :  O(H) for Iterative and Recursive
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Yes


// Your code here along with comments explaining your approach

public class KthSmallestTree {
    int result = -1,count;
    public int kthSmallest(TreeNode root,int k){
        Stack<TreeNode> stack  = new Stack<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if(k == 0){
                return root.val;
            }
            root = root.right;
        }
        return result;
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        count--;
        if(count ==0){
            result = root.val;
        }
        inorder(root.right);
    }
}
