import java.util.*;

/***
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */
class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    //tripletList
    List<List<Integer>> triplets = new ArrayList<>();
    // sort the nums
    Arrays.sort(nums);
    //loop over nums, for each nums[i] try to find a pair that sums to -nums[i](Like 2sum problem) from rest of the nums i.e. i+1 till N
    for(int i = 0; i < nums.length-2; ++i) {

        if(i > 0 && nums[i] == nums[i-1]) {
            continue;
        }
        findPair(nums, -nums[i], i+1, triplets);
    }
    return triplets;
  }

  public void findPair(int[] nums, int target, int left, List<List<Integer>> triplets) {
    int right = nums.length - 1;
    while(left < right){
        int sum = nums[left] + nums[right];
        if( sum == target) {
            List<Integer> triplet = new ArrayList<>();
            triplet.add(-target);
            triplet.add(nums[left]);
            triplet.add(nums[right]);
            triplets.add(triplet);
            left++;
            right--;
            
            while(left < right && nums[left] == nums[left-1]) {
                left++;
            }

            while(left < right && nums[right] == nums[right+1]) {
                right--;
            }
        } else if (target > sum) {
            left++;
        } else {
            right--;
        }
    }
  } 

  public static void main(String[] args) {
    int[] nums = {-1,0,1,2,-1,-4};
    Solution soln = new Solution();
    System.out.println(soln.threeSum(nums));
  }
  
}
