
// Time - O(N)
// Space - O(N)



class Solution {

    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {

        result = -1;

        inorder(root, k);

        return result;


    }


    private void inorder(TreeNode root, int k) {

        // base

        if(root == null) return;


        // logic
        if(result == -1) {
            inorder(root.left,k);
        }
        // st.pop()
        System.out.println(root.val);
        count++;

        if(count == k) {
            result = root.val;
            return;
        }

        if(result == -1) {
            inorder(root.right,k);
        }


    }
}