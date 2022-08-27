/***
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
 *
 * Example 1:
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 *
 * Example 2:
 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
 */
public class Main {

    /***
     * Sliding Window
     * @param arr
     * @param k
     * @return
     * Worst Case => O(N) time O(1) space
     */
  public static int findLength(int[] arr, int k) {
    int right = 0, left = 0, longest = 0, totalZeros = 0;

    while(right < arr.length ) {
        
        if(arr[right] == 0) totalZeros++;

        while(totalZeros > k) {
            if(arr[left] == 0) totalZeros--;
            left++;
        }
        
        right++;
        longest = Math.max(longest, right - left);
    }

    return longest;
  }

  public static void main(String[] args) {
    int[] arr = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
    int k = 2;
    System.out.println(findLength(arr, k));
    
    arr = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
    k = 3;
    System.out.println(findLength(arr, k));

  }
}
