/*
    LC - 230. Kth Smallest Element in a BST
    TC - O(k) 
    SC - O(h)
    Approach -
        Since it is BST, inorder gives the ascending order of the elements.
        Using iterative inorder approach (dfs)
*/

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
        if(root == null) {
            return -1;
        }
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || !st.isEmpty()) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k==0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}

/*
    LC - 230. Kth Smallest Element in a BST
    TC - O(k) 
    SC - O(h) recursive stack space
    Approach -
        Using recursive inorder approach (dfs)
*/

class Solution {
    int cnt, answer;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        cnt = k;
        answer = -1;
        inorder(root);
        return answer;
    }
    public void inorder(TreeNode root) {
        // base
        if(root == null || cnt == 0) {
            return;
        }

        // logic
        inorder(root.left);
        cnt--;
        if(cnt == 0) {
            answer = root.val;
            return;
        }
        inorder(root.right);
    }
}