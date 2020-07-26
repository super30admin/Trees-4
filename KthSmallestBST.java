/**
 * Time: O(K) K-given k value can also go till N-total nodes int he tree
 * Space: O(H) height of the tree - stack space
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

        Stack <TreeNode> st = new Stack<>();

        while(true){

            while(root != null){

                st.push(root);

                root = root.left;

            }

            root = st.pop();

            k--;

            if(k == 0) return root.val;

            root = root.right;

        }

    }

}