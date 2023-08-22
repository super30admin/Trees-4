// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// Here will will be traversing on the left of the root and then on the right. This way we will check if p or q are on the left of the parent or on the right. 
// If we find p on the left side of the parent, then we just need to return root to the parent from the left and not traverse through the child nodes of the root. 
// Getting p on the left side ensures that , even if q is somewhere in the bottom, it doesn't matter as the root will either be the ancestor or any root at a level higher to it. 
// If the root at the higher level has to be the ancestor, then it only needs to check on the right side of the parent for q. 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if(root==null || root==p || root==q) return root;
        //logic
        TreeNode Left=lowestCommonAncestor(root.left, p, q);    //Node received from the left
        TreeNode Right=lowestCommonAncestor(root.right, p, q);  //Node received from the right
        if(Left==null && Right ==null)  // If we receive null from both the sides
        {
            return null;
        }        
        else if(Left==null && Right!=null)
        {
            return Right;
        }
        else if(Left!=null && Right==null)
        {
            return Left;
        }
        else
        {
            return root;
        }

    }
}


//Using Lists . Since this is not BST the the values are not sorted. So we will create a path for both p and q. We will store the values of all the roots visited until we get p and q. We will iterate through the lists and keep checking the common elements. The moment we reach an element which is uncommon, it means , the root previous to that is the ancestor. TC: O(n) SC: O(h)


class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        backtrack(root,p,q,new ArrayList<>());

        for(int i=0;i<pathP.size();i++)
        {
            if(pathP.get(i)!=pathQ.get(i))
            {
                return pathP.get(i-1);
            }
        }
        return null;
    }

    private void backtrack(TreeNode root, TreeNode p, TreeNode q,List<TreeNode> path)
    {
        //base
        if (root==null) return;
        //logic

        //action
        path.add(root);
        if(root==p)
        {
            this.pathP=new ArrayList<>(path);   //creating a deep copy of path in pathP
            pathP.add(root);    //add p twice in the list in the end
        }
        if(root==q)
        {
            this.pathQ=new ArrayList<>(path);
            pathQ.add(root);    //add q twice in the list in the end
        }
        //recurse
        backtrack(root.left,p,q,path);  //traversing though the left side first
        backtrack(root.right,p,q,path); //right side

        //backtrack
        path.remove(path.size()-1);     //removing the last element
    }
}