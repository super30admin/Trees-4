# Solution

# // Time Complexity : O(n) since we go to each node till the count reaches k
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Go to the leftmost node, then we will reach the smallest element. From there start increasing the count since we will be coming
# across the numbers in ascending order now. Increment the count inorder, that means when we reach root of any recursion after
# processing the left side we can increase the count, this makes sure we are increasing count exactly in increasing order. The
# moment count == k we have found the element and that can be returned.

# This does not run since I have not worked on creating the BST part instead just wrote the solution

count = 0
result = None
def helper(root,k):
    if root == None:
        return
    
    helper(root.left,k)
    count += 1
    if count == k:
        result = root
        return
    if result == None:
       helper(root.right,k)

def kthSmallest(root, k):
    helper(root,k)
    return result.val