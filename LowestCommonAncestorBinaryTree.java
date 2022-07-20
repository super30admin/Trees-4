/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { List<TreeNode> pathP; 
    List<TreeNode> pathQ;
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
pathP= new ArrayList<>();
pathQ = new ArrayList<>();
helper(root, p, q, new ArrayList<>());
TreeNode res=null;

for(int i =0;i<pathP.size();i++)
{
if(pathP.get(i)!=pathQ.get(i))
{res=pathP.get(i-1);
break;
}
}
return res;
}
   
private void helper(TreeNode root, TreeNode p , TreeNode q, List<TreeNode> path )
{
if(root==null)
return;
path.add(root); //action

if(root==p)
{
pathP= new ArrayList<>(path);
pathP.add(p); // Adding a second time so that when we compare with pathQ , we get the correct lowest common ancestor
}
if(root==q)
{
pathQ= new ArrayList<>(path);
pathQ.add(q);
}

helper(root.left, p, q, path);  //recursion
helper(root.right, p, q, path); //recursion

path.remove(path.size()-1); //backtracking

}
}