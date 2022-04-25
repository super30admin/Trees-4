/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val   int
 *     Left  *TreeNode
 *     Right *TreeNode
 * }
 */

/*
    Approach: Brute force
    - Initial naive brute force
    - Get paths to p in logn
    - Get paths to q in logn
    - Then grab the last common between 2 paths
    
    time:   o(logN) +   o(logn) +   o(n) == 2o(logn) + o(n) == o(n)
            ToSearchP   ToSearchQ   ToFindLastCommonBetween2Paths
    Space: o(n)
*/

// func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
//     var dfs func(a *TreeNode, target *TreeNode, paths []*TreeNode) []*TreeNode
//     dfs = func(a *TreeNode, target *TreeNode, paths []*TreeNode) []*TreeNode {
//         // base
//         if a == nil || target == nil {
//             return nil
//         }
//         paths = append(paths, a)
        
//         // logic
//         if a.Val == target.Val {
//             return paths
//         }
//         if target.Val < a.Val {
//             return dfs(a.Left, target, paths)
//         }
//         return dfs(a.Right, target, paths)
//     }
//     pPaths := dfs(root, p, nil)
//     qPaths := dfs(root, q, nil)
    
//     var out *TreeNode
//     pPtr := 0
//     qPtr := 0
//     for pPtr < len(pPaths) && qPtr < len(qPaths) {
//         if pPaths[pPtr] == qPaths[qPtr] {
//             out = pPaths[pPtr] 
//         }
//         pPtr++
//         qPtr++
//     }
//     return out
// }



/*
    Approach: Recursion
    - Instead of checking p and q ( 1 at a time ), check them both in the same recursion
    - This is a BST, keeping that in mind
    - We can check if both p and q are > root , recurse right
    - If both p and q are < root , recurse left
    - otherwise return root -- because this is the common ancestor
    
    time:   o(logN)
    space:  o(h)
*/

// func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
//     // base 
//     if root == nil {
//         return nil
//     }
    
//     // logic
//     if p.Val > root.Val && q.Val > root.Val {
//         return lowestCommonAncestor(root.Right, p,q)
//     }
//     if p.Val < root.Val && q.Val < root.Val {
//         return lowestCommonAncestor(root.Left, p,q)
//     }
//     return root
// }


/*
    Approach: Iterative 
    - Instead of checking p and q ( 1 at a time ), check them both in the same recursion
    - This is a BST, keeping that in mind
    - We can check if both p and q are > root , change root to root.Right
    - If both p and q are < root , change root to root.Left
    - otherwise return root -- because this is the common ancestor
    - We do not need recursion here as we do not need to go back up the tree - I would have never thought of this .... 
    
    time:   o(logN)
    space:  o(1)
*/

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
    for true {
        if p.Val < root.Val && q.Val < root.Val {
            root = root.Left
        } else if p.Val > root.Val && q.Val > root.Val {
            root = root.Right
        } else {
            break
        }
    }
    return root
}
