/**
Intuition:
To find the lowest common ancestor, At each step we are finding the direction that we need to traverse to.
If the root is less than both p and q, we need to traverse the root's right side, else root's left side.
If the root is the in between p and q, then the current root is the lowest common ancestor.
 */
// recusrion
// T.C: O(h), S.C: O(h)
var lowestCommonAncestor = function (root, p, q) {
    if (!root) return null;
    if (root.val > p.val && root.val > q.val) {
        return lowestCommonAncestor(root.left, p, q);
    } else if (root.val < p.val && root.val < q.val) {
        return lowestCommonAncestor(root.right, p, q);
    } else {
        return root;
    }
};
// iteration
// T.C: O(h), S.C: O(1)
var lowestCommonAncestor = function (root, p, q) {
    while (true) {
        if (p.val > root.val && q.val > root.val) {
            root = root.right;
        } else if (p.val < root.val && q.val < root.val) {
            root = root.left;
        } else {
            return root;
        }
    }
};