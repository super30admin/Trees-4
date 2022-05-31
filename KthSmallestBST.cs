// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// 1) We can do dfs recusively, left and right
// 2) Set count = k
// 3) After recursive left call, decrease count --, it means we processed one element in order traversal
// 4) Aslo check if cnt == 0, it means, we traversed k-1 element, currnet element is kth element
// 5) Inorder traversal gives ascending order, so this will work
// 6) We can do some optimization by checking is result is -1 or not so that we can remove extra recursive calls
//TC: O(n)
//SC: O(n)
int result = 0;
int cnt;
public int KthSmallest(TreeNode root, int k) {
    
    if(root == null)
        return result;
    
    cnt = k;
    result = -1;
    inorder(root, k);
    return result;
}

private void inorder(TreeNode root, int k)
{
    //base
    if(root == null)
        return;
    
    //logic
    //this result check will help removing extra recursive calls in stack if result is found
    if(result == -1)
        inorder(root.left, k);
    
    cnt--;

    if(cnt == 0){
        result = root.val;
        //little bit optimization, when we get the result, return result
        //but if there is any element in recursive stack before, it will still be processed.
        return;
    }
    
    //this result check will help removing extra recursive calls in stack if result is found
    if(result == -1)
        inorder(root.right, k);
}