// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: yes
// Any problem you faced while coding this: no
// Your code here along with comments explaining your approach: inorder array, and return kth from the beginning

import java.util.ArrayList;
import java.util.List;

public class KthLargestBST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        List<Integer> arr = inorder(root, new ArrayList<>());
        return arr.get(k - 1);
    }

    public List<Integer> inorder(TreeNode root, List<Integer> array) {
        if (root == null) {
            return array;
        }
        array = inorder(root.left, array);
        array.add(root.val);
        array = inorder(root.right, array);
        return array;
    }
}
