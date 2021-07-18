public class KthSmallestElementBST {

    /*
    TC : O(N)
    SC : O(H)
    LC : yes
    Problems No
*/

    /**
     * We perform inordet traversal of the tree and add elements in an arraylist. As it is a BST, then the array generated will be in ascending order
     * Therefore return the k-1 th index element
     *
     * @param root
     * @param arr
     * @return
     */
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallest_inorder_recursive(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    /*
    TC : O(N) as we visit all Nodes of the tree
    SC : O(logN) as the stack can have max number of nodes equal to the height of the tree
     */

    public int kthSmallest_inorder_recursive(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }


            root = st.pop();
            k--;
            if (k == 0) return root.val;

            root = root.right;

        }

        return -1;
    }
}
