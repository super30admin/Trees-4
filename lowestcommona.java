
time complexity: O(n)
space complexity: O(n)

//traversing through the tree, comparing the values and assigning to a variable

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode t = root;
 
    while(t!=null){
        if(p.val >t.val && q.val >t.val){
            t = t.right;
        }else if (p.val<t.val && q.val<t.val){
            t = t.left;
        }else{
            return t;
        }
    }
 
    return null;
    }
}