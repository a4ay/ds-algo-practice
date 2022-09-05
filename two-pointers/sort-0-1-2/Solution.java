
/***
 * Problem Statement #
 * Given an array containing 0s, 1s and 2s, sort the array in-place. 
 * You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 * 
 * The flag of the Netherlands consists of three colors: red, white and blue; 
 * and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.
 * 
 * Example 1:
 * 
 * Input: [1, 0, 2, 1, 0]
 * Output: [0 0 1 1 2]
 * Example 2:
 * 
 * Input: [2, 2, 0, 1, 2, 0]
 * Output: [0 0 1 2 2 2 ]
 */
class Solution
{
    /***
     * Pointer Method
     * @param a
     * @param left
     * @param right
     * @param x
     * @return
     * Complexity: O(N) time, O(1) space
     */
    public static int sortForX(int a[], int left, int right, int x) {
        while(right < a.length) {
            if(a[right] == x) {
                a[right] = a[left];
                a[left] = x;
                left++;
            }
            right++;
        }
        return left;
    }
    public static void sort012(int a[], int n)
    {
        int left = sortForX(a, 0, 0, 0);
        sortForX(a, left, left, 1);
    }
}