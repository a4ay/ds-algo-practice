/***
 * Maximum Sum Subarray of Size K
 */
class Main {

  /***
   * Sliding Window Solution
   * @param arr
   * @param k
   * @return
   * Worst => O(N) time O(1) space
   */
  public static int maxSumSubArray(int[] arr, int k) {
    int maxSum = 0, sum = 0, start = 0, end = 0;

    for (end = 0; end < arr.length; ++end) {
      sum += arr[end];
      if (end >= k - 1) {
        maxSum = Math.max(maxSum, sum);
        sum -= arr[start];
        start++;
      }
    }

    return maxSum;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 3, 4, 1, 5 };
    int k = 2;
    System.out.println(maxSumSubArray(arr, k));
  }
}
