import java.util.Stack;

class Solution {
	//Approach: Recursion
	//Recurse over the tree with inorder traversal, and keep decrementing the k value when it reaches 0, we can return the node value.
    int result = 0;int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        if(root == null)
            return 0;
        helper(root);
        return result;
    }
    private void helper(TreeNode root)
    {
        //base
        if(root == null)
            return;
        //logic
        helper(root.left);
        //root == st.pop()
        count--;
        if(count == 0)
        {
            result = root.val;return;
        }
        helper(root.right);
    }
}
//Time Complexity : O(k) worst case k might be n 
//Space Complexity : O(h) height of the tree for the recursive stack
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

//Approach: Iteration
	//Iterate over the tree with inorder traversal and a stack, and keep decrementing the k value when it reaches 0, we can return the node value.
class Solution1 {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null)
        {
            while(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if(k == 0)return root.val;
            root = root.right;                
        }
        return -1;
    }
}
//Time Complexity : O(k) worst case k might be n 
//Space Complexity : O(h) height of the tree
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
class TreeNode 
{
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}