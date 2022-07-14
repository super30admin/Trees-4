//Time complexity : O(n)
//Space Complexity : O(k)
//Did it run on leetcode : yes

import java.util.Stack;

public class Kth_Smallest_In_BST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k == 0)
                return root.val;
            root = root.right;
        }
        return -1;
    }
}