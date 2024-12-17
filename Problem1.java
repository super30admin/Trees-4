// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
class Problem1 {
    int count =0;
    int result =-1;
    public int kthSmallest(TreeNode root, int k) {
        //dfsHelper(root,k);
        return iterativeHelper(root,k);
        //return result;
    }
    //TC:O(H) H can become n in a skewed tree
    //SC :O(H)
    public void dfsHelper(TreeNode root, int k){
        if(root ==null || result!=-1){
            return ;
        }

        dfsHelper(root.left,k);
        this.count++;
        if(count ==k){
            this.result = root.val;
        }
        dfsHelper(root.right,k);


    }

    public int iterativeHelper(TreeNode root, int k){
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null){
            while(root!=null){
                st.push(root);
                root= root.left;
            }

            root = st.pop();
            k--;
            if(k == 0){
                return root.val;
            }
            //note we are not putting it back to the stack
            root = root.right;
        }


        return -1;
    }
}
