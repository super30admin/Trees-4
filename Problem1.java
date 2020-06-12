//finding kth smallest element in a tree

//time o(n)
//space o(logn)
//recursive solution
class Solution {
    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    
    private void helper(TreeNode root) {
        //base case
        if(root == null)
            return;
        //logic
        helper(root.left);
        count--;
        if(count == 0)
            res = root.val;
        helper(root.right);
    }
}


//iteration
//time o(n)
//space o(logn)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root !=null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            k--;
            if(k == 0)
                return node.val;
            root = node.right;
        }
        return 0;
    }
}
