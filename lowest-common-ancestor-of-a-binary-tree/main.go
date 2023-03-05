package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
// TC : O(n)
// SC : O(h) : h is the height of the tree
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {

	var dfs func(r *TreeNode) *TreeNode
	dfs = func(r *TreeNode) *TreeNode {
		//base
		if r == nil {
			return nil
		}
		//logic

		left := dfs(r.Left)
		right := dfs(r.Right)
		if r == p || r == q {
			return r
		}
		if left != nil && right != nil {
			return r
		}
		if left != nil || right != nil {

			if left == nil {
				return right
			}

			return left
		}

		return nil
	}
	return dfs(root)
}
