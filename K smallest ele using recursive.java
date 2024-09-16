// Time complexity - 0(n)
// space complexity - 0(n)
// code successfully executed in leetcode
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        int count =0;
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            count++;
            if(count==k) return root.val;
            root = root.right;
        }
        return -1;
    }
        }