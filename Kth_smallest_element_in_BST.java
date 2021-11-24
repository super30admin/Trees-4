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
        int count = 0;
        
        Stack<TreeNode> st = new Stack<>();
        
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            count++;
            
            if(k == count) return root.val;
            root = root.right;
        }
        return -1;
    }
}

//TC: O(H+K)
//SC: O(K)

//Recursive

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
    int count = 0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        
       inorder(root, k);
        return result;
       
    }
    public void inorder(TreeNode root, int k){
        if(root == null){
            return;
        }
        inorder(root.left,k);
        count++;
        
        if(count == k){
            result = root.val;
        }
        
        if(count < k){
            inorder(root.right, k);
        }
    }
}

//TC: O(n)
//SC: O(k)

