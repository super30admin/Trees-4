import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KClosestElements {
/*
* PS - given sorted array find the closest k integers to the target x
* if 2 integers are both at the same distance then take the lower valued element
*
* Brute Force - calculate differences of each integer with the target value and store it in an array
* form a pair of original value element and the distance of that element to the target
* orig  = [1 2 3 4 5]  x= 3
* newArray = [2,1,0,1,2]
* result= [[0,3],[1,2],[1,4],[2,1],[2,5]]
* TC - O(nlogn)
* SC- O(n)
*
* Priority Heap -
* TC - EveryInsertion take log so O(nlogn)
* SC - O(n) as pq takes some space
* Expensive approaches
*
* 2 pointers
* keep 2 pointers one at orig start and one at its end
* move the pointer that is farther on the basis of the distance calculated
*Keep check the number of elements between 2 pointers
* TC - O(n-k + k )=O(n) as for 2 pointers we only do till n-k elements but then we need to iterate over k elements
* SC - O(1)
* When to use 2 pointers 1) sorted array and 2) moving 2 pointers should be easily distinguishable
*
* Binary Search
* Index of starting point from where k elements are needs to be picked
*  low = 0 and high = n-k reason above mentioned
*calulate mid and distance left
*TC - O(log(n-k)) +O(k)
* SC - O(1)
*
* */



    //https://leetcode.com/problems/find-k-closest-elements/

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        int k = 4,x=3;
        System.out.println(findClosestElements(arr,k,x));

    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr==null||arr.length==0) return Collections.emptyList();
        int low = 0;
        int high = arr.length-k;
        while(low<high){
            int mid = low+(high-low)/2;
            int distLeft = x- arr[mid];
            int distRight = arr[mid+k]-x;
            if(distLeft>distRight) low= mid+1;
            else high = mid;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = low; i <k ; i++) {
            result.add(arr[i]);
        }
        return  result;
    }

    //Two pointer approach

    /*

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
            if(arr==null||arr.length==0) return Collections.emptyList();
            int left = 0;
            int right = arr.length-1;
            while (right-left+1>k){//stopping condition for 2 pointers
                int disLeft = x-arr[left];
                int disRight = arr[right]-x;
                if(disRight>=disLeft) right--;
                else left++;


            }
            List<Integer> result = new ArrayList<>();
        for (int i = left; i <=right ; i++) {
result.add(arr[i]);
        }
        return result;
    }
*/
// One of the best solutions - code is compact
    /*
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = Arrays.stream(arr).boxed().sorted((a, b) -> {
            int v = Math.abs(a - x) - Math.abs(b - x);
            return v == 0 ? a - b : v;
        }).collect(Collectors.toList());
        ans = ans.subList(0, k);
        Collections.sort(ans);
        return ans;
    }*/
    /*
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<List<Integer>> result = new ArrayList<>();
        int[] arrNew = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
                arrNew[i] = x-arr[i];
        }
        System.out.println("AnotherArray "+Arrays.toString(arrNew));
        System.out.println(Arrays.toString(orderTheArray(arr,arrNew)));
        return Collections.emptyList();

    }

    private static int[] orderTheArray(int[] arr, int[] arrNew) {
            int temp[] = new int[arr.length],visited[]=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
            visited[i] = 0;
        }
        Arrays.sort(temp);
        int ind = 0;
        for (int i = 0; i < arr.length; i++) {
            int f = first(temp, 0, arr.length - 1, arrNew[i], arr.length);
            if (f == -1)
                continue;
            for (int j = f; (j < arr.length && temp[j] == arrNew[i]);
                 j++) {
                arr[ind++] = temp[j];
                visited[j] = 1;
            }
        }
            for (int i = 0; i < arr.length; i++)
                if (visited[i] == 0)
                    arr[ind++] = temp[i];
            return arr;
        }

    static int first(int arr[], int low, int high, int x,
                     int n)
    {
        if (high >= low) {

            int mid = low + (high - low) / 2;

            if ((mid == 0 || x > arr[mid - 1])
                    && arr[mid] == x)
                return mid;
            if (x > arr[mid])
                return first(arr, (mid + 1), high, x, n);
            return first(arr, low, (mid - 1), x, n);
        }
        return -1;
    }
*/

}
