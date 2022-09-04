import java.util.Arrays;

/***
 * Given an array arr of unsorted numbers and a target sum, 
 * count all triplets in it such that arr[i] + arr[j] + arr[k] < target 
 * where i, j, and k are three different indices. Write a function to return the count of such triplets.
 * 
 * Example 1:
 * 
 * Input: [-1, 0, 2, 3], target=3 
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 * Example 2:
 * 
 * Input: [-1, 4, 2, 1, 3], target=5 
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target: 
 *    [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
class Solution
{
    /***
     * Pointers Method
     * @param arr
     * @param n
     * @param sum
     * @return
     * Complexity Analysis: O(N^2) time O(1) space 
     */
    long countTriplets(long arr[], int n,int sum)
    {
        Arrays.sort(arr); //nlogn
        long res = 0;
        for(int i = 0; i < n - 2; ++i) { // n * n
            int left = i+1, right = n - 1;
            while(left < right) { // n
                long target = arr[i] + arr[left] + arr[right];
                if(target < sum){
                    res += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return res;
    }
}
