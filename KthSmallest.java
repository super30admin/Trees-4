//Time Complexity:O(n)
//Space complexity:O(h), h-height of tree
//Recursive inorder traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count;
    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
        this.count=k;
        this.result = null;
        inorder(root);
        return result.val;

    }

    private void inorder(TreeNode root){
        if(root == null)  return;

        if(result ==null)
            inorder(root.left);

        count--;
        if(count==0){
            result = root;
            return;
        }

        if(result ==null)
            inorder(root.right);

    }
}


//Time Complexity:O(n)
//Space complexity:O(h), h-height of tree
//Iterative inorder traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
       Stack<TreeNode> stack = new Stack<>();
       while(!stack.isEmpty() || root!=null){
           while(root!=null){
                stack.push(root);
            root = root.left;
           }
           
           root= stack.pop();
           k--;
        if(k==0) return root.val;
            root = root.right;

       }
       return -1;
    }

    
}