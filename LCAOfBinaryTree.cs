// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



//recursive approach
//Here we call recursion on left and right subtree and with some condition, return the left, right, root or null

public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    
    if(root == null || root == p || root == q)
        return root;
    //traverse left and right unless we find p and q        
    TreeNode left = LowestCommonAncestor(root.left, p, q);
    TreeNode right = LowestCommonAncestor(root.right, p, q);
    
    //left and right not found, means p and p doesnt exists in tree
    if(left == null && right == null)
        return null;
    
    //one of them is found, return that one, that will be LCA
    else if(left != null && right == null)
        return left;
    
    else if(right != null && left == null)
        return right;
    //if left and right are not null, it means p and q are found, root wwoud be there LCA
    else
        return root;
}

//Backtracking approach

// 1) Maintain list of ancestor at every node, then compare the list of p and q to find matching node to LCA
// 	a. To find LCA, we will add p and q in the list once node is found in array at end
// 	b. Then we start finding mismatch element in two array starting from index 0, once mismatch is found, we will return last matched node, that is LCA.
// 2) But how  we store the list at every node, two ways
// 	a. Use backtracking, maintain one array, when we backtrack, we remove the element from array
// 	b. Or use recursion because array would be local and we are not creating new every time.

List<TreeNode> pathP;
List<TreeNode> pathQ;
public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    
    if(root == null || root == p || root == q)
        return root;
    
    pathP = new List<TreeNode>();
    pathQ = new List<TreeNode>();

    backtracking(root, p, q, new List<TreeNode>());

    for(int i = 0; i < pathP.Count; i++)
    {
        if(pathP[i] != pathQ[i])
            return pathP[i-1];
    }

    return null;
}

private void backtracking(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path)
{
    //base 
    if(root == null)
        return;
    
    //logic
    //action
    path.Add(root);
    if(root == p)
    {
        pathP = new List<TreeNode>(path);
        pathP.Add(root);
    }
    
    if(root == q)
    {
        pathQ = new List<TreeNode>(path);
        pathQ.Add(root);
    }
    //recursion
    backtracking(root.left, p, q, path);
    backtracking(root.right, p, q, path);

    //backtrack
    path.RemoveAt(path.Count - 1);
}