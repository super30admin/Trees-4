public class KsmallestElementInBst {
    Stack<TreeNode> stack = new Stack<>();
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        while(!stack.isEmpty() || root!=null)
        {
            while(root!=null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            if(count==k)
                return root.val;
            root=root.right;
        }
        return -1;
    }
}
