class Solution {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {

        if(root == null)
            return -1;

        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root!=null){
            while(root!=null) {
                stack.add(root);
                root = root.left;
            }

            TreeNode popped = stack.pop();
            if(k==1)
                return popped.val;
            k--;
            root = popped.right;
        }
        return -1;
    }
}