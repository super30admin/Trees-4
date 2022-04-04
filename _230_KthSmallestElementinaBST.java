// Time Complexity : o(log(n)) where n is number of nodes
// Space Complexity : o(h) where h is height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Do inorder traversal of tree and decrement k when k ==0 , you have found your element
class Solution {

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        while(root != null){
            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()){
           root = stack.pop();
           k--;
           if(k == 0) return root.val;

           root = root.right;

           while(root != null){
            stack.push(root);
            root = root.left;
           }
        }

        return -1;

    }
}
