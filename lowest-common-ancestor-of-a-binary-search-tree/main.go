package main

import "fmt"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val   int
 *     Left  *TreeNode
 *     Right *TreeNode
 * }
 */
// TC : O(N)
// SC : O(h) : height is the height of the tree
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	fmt.Println(root, p, q)
	if root == nil {
		return nil
	}
	var pathP []*TreeNode
	var pathQ []*TreeNode
	var dfs func(root, p, q *TreeNode, path []*TreeNode)
	dfs = func(root, p, q *TreeNode, path []*TreeNode) {
		// base
		if root == nil {
			return
		}
		// action
		path = append(path, root)
		if root.Val == p.Val {
			pathP = make([]*TreeNode, len(path))
			copy(pathP, path)
			pathP = append(pathP, root)
		}
		if root.Val == q.Val {
			pathQ = make([]*TreeNode, len(path))
			copy(pathQ, path)
			// adding extra to the list for cases where root itself is the p or q
			pathQ = append(pathQ, root)
		}
		// recurse
		dfs(root.Left, p, q, path)
		dfs(root.Right, p, q, path)
		// backtrack
		path = path[:len(path)-1]
	}
	dfs(root, p, q, []*TreeNode{})
	for i := 0; i < len(pathP); i++ {
		if pathP[i].Val != pathQ[i].Val {
			return pathP[i-1]
		}
	}
	return nil
}
