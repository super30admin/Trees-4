// Time Complexity : 0(n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func lowestCommonAncestor(_ root: TreeNode?, _ p: TreeNode?, _ q: TreeNode?) -> TreeNode? {
       if root == nil {
           return root
       } 
        if root?.val == p?.val || root?.val == q?.val {
            return root
        }
        var left = lowestCommonAncestor(root?.left,p,q)
        var right = lowestCommonAncestor(root?.right,p,q)
        if let left = left, let right = right {
            return root
        } else if let left = left {
            return left
        } else {
            return right
        }   
    }
