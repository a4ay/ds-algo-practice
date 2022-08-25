
/*
 * Given an array of positive numbers and a positive number ‘S’,
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. 
 * Return 0, if no such subarray exists.
 * Input: [2, 1, 5, 2, 3, 2], S=7 
 * Output: 2
 * Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
 * Input: [2, 1, 5, 2, 8], S=7 
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 */
public class Main {

    /***
     * Sliding Window
     * @param arr
     * @param s
     * @return
     * Worst => O(N) time O(1) space
     */
    public static int smallestSubarraySum(int[] arr, int s) {
        int start = 0, end = 0;
        int minSubArray = Integer.MAX_VALUE;
        int sum = 0;
        while(end < arr.length) {
            sum += arr[end];

            while(sum >= s) {
                minSubArray = Math.min(minSubArray, end-start+1);
                sum -= arr[start];
                start++;
            }
            end++;
        }

        return minSubArray;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 1, 6};
        int s = 8;

        System.out.println(smallestSubarraySum(arr, s));
    }
}
