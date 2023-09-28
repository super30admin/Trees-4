//Tc = O(h)
//Sc = O(h)
class Solution {
    public LCABinarySearchTree lowestCommonAncestor(LCABinarySearchTree root, LCABinarySearchTree p,
            LCABinarySearchTree q) {
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else {
            return root;
        }

    }
}

public class LCABinarySearchTree {
    int val;
    LCABinarySearchTree left;
    LCABinarySearchTree right;

    LCABinarySearchTree(int x) {
        val = x;
    }
}
