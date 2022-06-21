TC - O(K) 
SC - O(H) - where H is height of tree
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(root, k) {
    	var arr=[];
  		inorder(root,arr);
  		return arr[k-1];
};
var inorder = function(root,arr){
    if(root===null){
        return;
    }
    inorder(root.left,arr);
    arr.push(root.val);
    inorder(root.right,arr);
}