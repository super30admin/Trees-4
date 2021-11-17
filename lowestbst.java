// Time Complexity : 0(log n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func lowestCommonAncestor(_ root: TreeNode?, _ p: TreeNode?, _ q: TreeNode?) -> TreeNode? {
        guard let root = root, let p = p, let q = q else {return nil}
        if (root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val) {
            return root
        }
        if root.val > p.val && root.val > q.val {
            return lowestCommonAncestor(root.left,p,q)
        }
        if root.val < p.val && root.val < q.val {
            return lowestCommonAncestor(root.right,p,q)
        }
        return nil
    }
