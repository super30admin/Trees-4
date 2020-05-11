

class Solution {

    /**
     * Itertive  Solution
     * @param root
     * @param k
     * @return
     */

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(maxDepth) maxDepth = size of stack
     */
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }


    /**
     * Recursive Solution
     * @param root
     * @param k
     * @return
     */

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(maxDepth)
     */
    public int kthSmallest(TreeNode root, int k) {

        int[] K = new int[2];
        K[0] = k;
        K[1] = 0;
        helper(K,root);
        return K[1];
    }

    private void helper(int[] k, TreeNode root){

        if(root==null)
            return;

        helper(k,root.left);

        if(--k[0]==0){
            k[1]= root.val;
            return;
        }
        helper(k,root.right);

    }


}


