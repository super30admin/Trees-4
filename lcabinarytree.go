// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if root is nil or == p or q return root
set left = recursive(root.Left)
set right = recursive(root.Right)
if both are not nil return root
if one is nil return other
*/
package main

import "fmt"

func lowestCommonAncestorBT(root, p, q *TreeNode) *TreeNode {
	if root == nil || root == p || root == q {
		return root
	}
	left := lowestCommonAncestorBT(root.Left, p, q)
	right := lowestCommonAncestorBT(root.Right, p, q)
	if left != nil && right != nil { return root }
	if left != nil { return left }
	return right
}

func MainLCABinaryTree() {
	q := &TreeNode{Val: 1, Left: &TreeNode{Val: 0}, Right: &TreeNode{Val: 8}}
	r := &TreeNode{Val: 2, Left: &TreeNode{Val: 7}, Right: &TreeNode{Val: 4}}
	p := &TreeNode{Val: 5, Left: &TreeNode{Val: 6}, Right: r}

	root := &TreeNode{Val: 3, Left: p, Right: q}
	fmt.Println(lowestCommonAncestorBT(root, p, q)) //expected 3
}
