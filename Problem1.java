// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*Keep a stack and keep pushing elements from the left side. 
Continue popping and if the count reaches 0 from k, return the value at the root. 
Recurse on both left and right nodes of the tree. 
 * 
 */

class Problem1 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k == 0){
                return root.val;
            }   
            root = root.right;
        }
        return 100;
    }
}