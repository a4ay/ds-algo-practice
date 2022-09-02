import java.util.Arrays;

/***
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 * 
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * 
 */
class Solution {

    /**
     * Three Pointers
     * @param nums
     * @param target
     * @return 
     * Complexity Analysis: O(N^2) time O(N) space
     */
    public int threeSumClosest(int[] nums, int target) {
        int closeDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2; ++i) {
            int left = i + 1, right = nums.length-1;
            while(left < right) {
                int currDiff = nums[i] + nums[left] + nums[right] - target;
                
                if(currDiff == 0) {
                    return target-currDiff;
                }
                
                // IF currDiff is closer to zero than closeDiff then closeDiff = currDiff
                if(Math.abs(currDiff) < Math.abs(closeDiff)) {
                    closeDiff = currDiff;
                }
                
                if(currDiff < 0) {
                    left++;
                } else {
                    right--;
                }
                
            }
        }
        
        return closeDiff + target;
    }

}