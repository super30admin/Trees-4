List<TreeNode>pathP,pathQ;

public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){

if(root==null)return null;pathP=new ArrayList<>();pathQ=new ArrayList<>();

helper(root,p,q,new ArrayList<>());

if(pathP==null||pathQ==null)return null;
// System.out.println("Pathp : "+pathP.size());
// System.out.println("PathQ : "+pathQ.size());

for(int i=0;i<pathP.size();i++){if(i!=0&&pathP.get(i)!=pathQ.get(i)){return pathP.get(i-1);}}

return null;

}

private void helper(TreeNode root,TreeNode p,TreeNode q,List<TreeNode>path){
// base case
if(root==null)return;

// logic
path.add(root); // this line always should be in pre-order fashion. also before the actual logic
                // path as well
                /***********************
                 * ACTUAL LOGIC PATH : Following piece of code can be placed in inorder,
                 * preorder, and posorder manner as well
                 */
if(root.val==p.val){pathP=new ArrayList<>(path);pathP.add(p);

}if(root.val==q.val){pathQ=new ArrayList<>(path);pathQ.add(q);

}
/*********** placing above code anywhere doesn't make diff**************** */
// recurse
helper(root.left,p,q,path);helper(root.right,p,q,path);

// backtrack
path.remove(path.size()-1);}}

// conditional Recursion based on flag!

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/*
 * Approach-1
 * build a path , and add it to pathp, pathq
 * at last traverse a for loop, and return i-1 hen found uncommon node
 * hande edge case, out of bound, by adding the extra node twice at the end
 */
class Solution {
    List<TreeNode> pathP, pathQ;
    boolean foundP, foundQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();

        foundP = false;
        foundQ = false;
        helper(root, p, q, new ArrayList<>());

        if (pathP == null || pathQ == null)
            return null;
        // System.out.println("Pathp : "+pathP.size());
        // System.out.println("PathQ : "+pathQ.size());

        for (int i = 0; i < pathP.size(); i++) {
            if (i != 0 && pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i - 1);
            }
        }

        return null;

    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base case
        if (root == null)
            return;
        if (foundP && foundQ)
            return;

        path.add(root);
        // logic
        if (root.val == p.val) {
            pathP = new ArrayList<>(path);
            pathP.add(p);
            foundP = true;

        }
        if (root.val == q.val) {
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
            foundQ = true;

        }

        // conditional recurse
        if (!foundP || !foundQ)
            helper(root.left, p, q, path);

        if (!foundP || !foundQ)
            helper(root.right, p, q, path);

        // backtrack
        path.remove(path.size() - 1);
    }
}
