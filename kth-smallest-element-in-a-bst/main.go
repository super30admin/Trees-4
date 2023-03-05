package main

import "fmt"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
// since this is BST - do an inorder traversal and that gives you the sorted list - return the kth element
// try to optimize this now

// TODO : follow up with maybe another solution; like a heap if possible?

// TC : O(n)
// SC : O(n) : n is the height of the tree and this will be in the recursive stack
func kthSmallest(root *TreeNode, k int) int {
	var dfs func(root *TreeNode, k int)
	var inOrder []int
	dfs = func(root *TreeNode, k int) {
		//base
		if root == nil {
			return
		}
		// logic
		dfs(root.Left, k)
		inOrder = append(inOrder, root.Val)
		dfs(root.Right, k)

	}
	dfs(root, k)
	fmt.Println(inOrder)
	return inOrder[k-1]
}
