// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
while root != nil
if p < root and q < root then move root to root.left
else if p > root and q > root then move root to root.right
else return root
*/
package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//var path1 []*TreeNode
//var path2 []*TreeNode

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	/*if p.Val < root.Val && q.Val < root.Val {
	      return lowestCommonAncestor(root.Left, p, q)
	  } else if p.Val > root.Val && q.Val > root.Val {
	      return lowestCommonAncestor(root.Right, p, q)
	  } else {
	      return root
	  }
	  return nil*/

	for root != nil {
	      if p.Val < root.Val && q.Val < root.Val {
	          root = root.Left
	      } else if p.Val > root.Val && q.Val > root.Val {
	          root = root.Right
	      } else {
	          return root
	      }
	  }
	  return nil

	/*some error//in case its not a bst but a binary tree
	path1 = []*TreeNode{}
	path2 = []*TreeNode{}
	backtrack(root, p, &path1)
	backtrack(root, q, &path2)
	for i:=0;i<len(path1);i++ {
		if path1[i] != path2[i] {
			return path1[i - 1]
		}
	}
	return nil*/
}

/*func backtrack(root, p *TreeNode, path *[]*TreeNode) {
	//base
	if root == nil {
		return
	}
	if root == p {
		*path = append(*path, root)
		return
	}
	//logic
	//action
	*path = append(*path, root)
	//recurse
	backtrack(root.Left, p, path)
	if (*path)[len(*path) - 1] == p {
		return
	}
	v := len(*path) - 1
	*path = (*path)[:v]
	backtrack(root.Right, p, path)
	v = len(*path) - 1
	*path = (*path)[:v]
}*/

func MainLCABST() {
	q := &TreeNode{Val: 8, Left: &TreeNode{Val: 7}, Right: &TreeNode{Val: 9}}
	r := &TreeNode{Val: 4, Left: &TreeNode{Val: 3}, Right: &TreeNode{Val: 5}}
	p := &TreeNode{Val: 2, Left: &TreeNode{Val: 0}, Right: r}

	root := &TreeNode{Val: 6, Left: p, Right: q}
	fmt.Println(lowestCommonAncestor(root, p, r)) //expected 2
}


