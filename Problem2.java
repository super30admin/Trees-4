//time complexity-O(n)
//space complexity-O(n)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(true){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            TreeNode top = st.pop();
            k--;
            if(k==0)  return top.val;
            root=top.right;
        }
  
    }
}