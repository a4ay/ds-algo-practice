import java.util.*;

/***
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * 
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 * 
 * Example 1:
 * 
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 * Example 2:
 * 
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 * 
 */
class Solution {
    /***
     * Two pointer Method only works for already sorted array
     * @param arr
     * @param targetSum
     * @return
     * Complexity Analysis: O(N) time O(1) space;
     */
    public int[] search(int[] arr, int targetSum) {
        int leftPtr = 0, rightPtr = arr.length - 1;

        while(rightPtr < leftPtr) {
            int sum = arr[leftPtr] + arr[rightPtr];
            if(sum == targetSum) {
                return new int[]{leftPtr, rightPtr};
            } else if(sum < targetSum) {
                leftPtr++;
            } else {
                rightPtr--;
            }
        }

        return new int[]{};
    }
    /***
     * Mapping complement technique
     * Works for both ordered and unordered array set
     * @param nums
     * @param target
     * @return
     * Complexity Analysis: O(N) time O(N) space
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> com = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            int complement = target - nums[i];
            if(com.containsKey(complement)) {
                return new int[]{com.get(complement), i};
            }
            com.put(nums[i], i);
        }
        return new int[]{};
    }
}