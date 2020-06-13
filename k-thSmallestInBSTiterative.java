//Approach: Iterative solution using stack. Do inorder traversal and decrease the value of k by one each time an element is popped out. When k equals zero the last popped out element is the k-th smallest element.

//time complexity O(n)
//space complexity O(n)

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
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop(); k--;
            if(k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }
}
