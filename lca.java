// Iterative 
// Time - Avg - O(LgN), Worst - O(N)
// Space - O(1)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while(root!= null) {
            if(p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            else if(p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            else {
                break;
            }
        }
        
        return root;
    }
}

// Recursive
// Time - Avg - O(LgN), Worst - O(N)
// Space - Avg, O(lgN), Worst - O(N)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }
        
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);            
        }
        else if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);            
        }
        else {
            return root;
        }
        
    }
    
}
