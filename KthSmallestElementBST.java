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

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

}
