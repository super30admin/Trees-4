/**
 Intuition:
 We are using bottom up recursion in here.
 In this solution we are traversing to find p and q on both left and right sides of the tree.
 If we found both left and right at any parent then that is lowest common ancestor.
 If only one side of the tree returns non null value then return in uopwards.
 T.C: O(n)
 S.C: O(n)
 */
var lowestCommonAncestor = function (root, p, q) {
    // base
    if (!root) return null;
    if (p === root || q === root) return root;

    // recursion
    let left = lowestCommonAncestor(root.left, p, q);
    let right = lowestCommonAncestor(root.right, p, q);

    // action (bottom up recursion)
    if (left && right) return root;
    if (!left && right) return right;
    if (left && !right) return left;

};