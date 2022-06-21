SC - O(H)
TC - O(H)

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, n1, n2) {
    if(root=== null || root===n1 || root===n2)
        { return root; }
    var resL = lowestCommonAncestor(root.left,n1,n2);
    var resR = lowestCommonAncestor(root.right,n1,n2);
    return (resL && resR) ? root : (resL||resR);
       
};