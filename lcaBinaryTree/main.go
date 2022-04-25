/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

/*
    approach: brute force
    - Find paths that lead to p and q
    - Find the last common node between the 2 paths
    - The last common node is the lowest common ancestor
    
    time: o(n)
        - worse case our recursion goes left first and p and q are located in the right subtree as leaf nodes
    space: o(p+q)
        - o(h) for recursion stack + o(p+q) the paths array for both p and q which would be larger compared to o(h) in worse case
*/

// func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
//     var pPaths []*TreeNode
// 	var qPaths []*TreeNode

// 	var backtrack func(r *TreeNode, paths []*TreeNode)
// 	backtrack = func(r *TreeNode, paths []*TreeNode) {
// 		// base
//         if r == nil{
// 			return
// 		}
        
//         // exit early
//         if len(pPaths) != 0 && len(qPaths) != 0 {return}
        
// 		// logic
// 		// action
//         paths = append(paths, r)
//         if r.Val == p.Val {
//             // new list since we backtrack paths arr so that we dont end up with empty list ( since we remove last element from paths )
// 			newP := make([]*TreeNode, len(paths))
// 			copy(newP, paths)
// 			pPaths = newP
// 		}
// 		if r.Val == q.Val {
// 			newQ := make([]*TreeNode, len(paths))
// 			copy(newQ, paths)
// 			qPaths = newQ
// 		}
// 		// recurse
// 		backtrack(r.Left, paths)
// 		backtrack(r.Right, paths)
// 		// backtrack
// 		paths = paths[:len(paths)-1]
// 	}
// 	backtrack(root, nil)

// 	var out *TreeNode
// 	pPtr := 0
// 	qPtr := 0
// 	for pPtr < len(pPaths) && qPtr < len(qPaths) {
//         if pPaths[pPtr] == qPaths[qPtr] {
// 			out = pPaths[pPtr]
// 		}
// 		pPtr++
// 		qPtr++
// 	}
// 	return out
// }


/*
    approach:
    - The implied logic in this approach only works IF ITS GURANTEED THAT BOTH P AND Q EXISTS
    - Instead of maintaining paths that lead to both p and q ( top down recursion )
    - We will do bottom up recursion
        - Remember bottom up recursion is when we get an answer from childs to process parent node
        - Example: max height of tree, get height of two childs, pass them back to parent, parent takes max and adds 1
            - In this parent relied on answers from both left and right childs ( bottom up processing )
    - For this case, as soon as we find either p or q when we are on specific root node, we will return that root node itself
    - i.e the child will return back the child node it was on back to its parent ( left and/or right )
    - If a parent sees that both of its childs ( left and right ) has returned a node (i.e not null )
        - then that parent must pass back itself!
    - If left == nil && right is not, return right response
    - If left is not nil and right is nil, return left response
    - If both childs returned nil, return nil
    
    TLDR is; if we find p or q, return that node itself and parent should propagate the same node
    
    time: o(n)
    space: o(h)
*/
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
    // base
    if root == nil || root.Val == p.Val || root.Val == q.Val{
        return root
    }
    // logic
    
    left := lowestCommonAncestor(root.Left, p,q)
    right := lowestCommonAncestor(root.Right, p,q)
    if left == nil && right == nil {return nil}
    if left != nil && right == nil {return left}
    if left == nil && right != nil {return right}
    // otherwise if left and right are both NOT NIL, return the current root node 
    // because if a parent recieves 2 not nulls from left and right, it means this node is lowest common ancestor
    return root
}
