//230 Kth smallest element in a BST
// Time - O(h)
//Space - O(h)

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        int result = 0;
        while(!stack.isEmpty() || root != null){
            
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            
            root = stack.pop();
       k--;
            if(k == 0){
                result = root.val;
                break;
            }
            
            root = root.right;
        }
        return result;
    }
}