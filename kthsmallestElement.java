class KthSmallestElementInBST {

    // Time Complexity: O(h+k)    (where h -> height of the tree)
    // Space Complexity: O(h)

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            k--;
            if(k == 0)
                return top.val;
            root = top.right;
        }
        return -1;
    }
} 