
//DFS
class Solution {
    TreeNode p; TreeNode q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p= p;
        this.q=q;
    return helper(root);    
    }
    private TreeNode helper(TreeNode root){
        if(root == null) return null;
        if(root==p || root==q) {
            return root;
        }
        if(p.val<root.val && q.val<root.val) {
            return helper(root.left);
        }
        if(p.val>root.val && q.val>root.val) {
            return helper(root.right);
        }
        return root;
    }
}
//time complexity- O(n)
//space complexity- O(n)

//BFS

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node= root;
        while(node!= null){
            if(node==p || node==q) {
                return node;
            }
            else if(p.val<node.val && q.val<node.val) {
                node=node.left;
            }
            else if(p.val>node.val && q.val>node.val) {
                node= node.right;
            }
            else
                break;
        } 
        return node;
    } 
}
//time complexity- O(n)
//space complexity- O(1)