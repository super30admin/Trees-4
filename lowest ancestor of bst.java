//Timecomplexity:-O(h) where h<n as only required branch is searched.
//Spacecomplexity:-O(n) for reccursion stack.
//did it run on leetcode:- yes.
//What problems did you face:- faced many wrong answers initially.
//traversing left branch and right branch depending on p,q values and for every branch applying reccursion.



class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val==p.val||root.val==q.val){
            return root;
        }
        if((p.val<root.val && q.val>root.val)||(q.val<root.val && p.val>root.val)){
            return root;
        }
        else if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return lowestCommonAncestor(root.right,p,q);
    }
}